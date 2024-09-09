package com.dw.dao.impl;

/**
 * 数据访问层，学生信息CRUD操作
 * @author DY1101shaoyuxian
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;

import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.DynamicLabel;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.ResourceIterable;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.index.Index;
import org.neo4j.graphdb.index.IndexManager;
import org.neo4j.graphdb.traversal.Evaluators;
import org.neo4j.graphdb.traversal.TraversalDescription;
import org.neo4j.graphdb.traversal.Traverser;
import org.neo4j.graphdb.traversal.Uniqueness;
import org.neo4j.kernel.Traversal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dw.dao.StudentDao;
import com.dw.model.IsFriendOf;
import com.dw.model.MyRelationshipTypes;
import com.dw.model.Student;
import com.dw.util.DbConn;

public class StudentDaoImpl implements StudentDao {
	
	private static Logger logger = LoggerFactory.getLogger(StudentDaoImpl.class);
	
	private GraphDatabaseService graphDb = DbConn.getGraphDb();
	
	/**
	 * 注册用户
	 * @param page
	 * @return 
	 */
	public boolean register(Student stu){
		String id = stu.getStId();
		String name = stu.getStName();
		String password = stu.getStPassword();
		
		boolean flag = true;
		try(Transaction tx = graphDb.beginTx()){
			Node student = graphDb.createNode(DbConn.studentLabel);
			if(student == null){
				flag = false;
			}
			Long nodeId = student.getId();
			//logger.info("created user:" + student.getId());
			student.setProperty("stId", id);
			student.setProperty("nodeId", nodeId);
			student.setProperty("stName", name);
			student.setProperty("stPassword", password);
			student.setProperty("stRegTime", (new java.util.Date()).toString());
			//Index<Node> stIndex = graphDb.index().forNodes(StIndexName);
			//stIndex.add(student, "stId", id);
			//添加管理员的管理关系
			ResourceIterable<Node> result=
	    			graphDb.findNodesByLabelAndProperty(DbConn.adminLabel, "adminId", "admin");
			Node admin = result.iterator().next();
			Relationship manager = admin.createRelationshipTo(student, MyRelationshipTypes.MANAGER);
			manager.setProperty("type", "student");
			tx.success();
		}
		return flag;
	}
	/**
     * 登陆用户验证
     * @param page
     * @return
     */
    public boolean isLogin(Student stu) {
    	String id = stu.getStId();
    	String password = stu.getStPassword();
    	boolean flag = false;
    	ResourceIterable<Node> result=
    			graphDb.findNodesByLabelAndProperty(DbConn.studentLabel, "stId", id);
    	String stPassword = result.iterator().next().getProperty("stPassword").toString();
        if(stPassword.equals(password)){
        	flag = true;
        }
    	return flag;
        //logger.info("Execution result:" + result.toString());
    	/*
    	List<Student> list = findAllStudent();
    	boolean flag = false;
	 	for(Student student: list){
	 		if(id.equals(student.getStId())){
	 			String stPassword = student.getStPassword();
	 			if(stPassword.equals(password)){
	 				flag = true;
	 			}
	 		}
	 	}
	 	*/
    }
	/**
	 * 修改用户的密码
	 * @param page
	 * @return
	 */
	public boolean updatePassWord(Student stu) {
		String id = stu.getStId();
    	String password = stu.getStPassword();
    	boolean flag = false;
    	try(Transaction tx = graphDb.beginTx()){
    		ResourceIterable<Node> result=
    			graphDb.findNodesByLabelAndProperty(DbConn.studentLabel, "stId", id);
    		result.iterator().next().setProperty("stPassword", password);
    		flag = true;
    		tx.success();
    	}
    	return flag;
	}
	/**
	 * 删除用户信息--注销
	 * @param id
	 * @return flag
	 */
	public boolean delStudent(String id) {
		boolean flag = false;
		try(Transaction tx = graphDb.beginTx()){
			ExecutionEngine engine = new ExecutionEngine(graphDb);
			String cql = "match () - [r:MANAGER] - (stu:STUDENT)" +
					"where stu.stId = " + id +
					"delete r";
			ExecutionResult result = engine.execute(cql);
			flag = true;
	        //logger.info("Execution result:" + result.toString());
			tx.success();
		}
		try(Transaction tx = graphDb.beginTx()){
			ExecutionEngine engine = new ExecutionEngine(graphDb);
			String cql = "match (stu:STUDENT) - [r] - ()" +
					"where stu.stId = " + id +
					"delete stu, r";
			ExecutionResult result = engine.execute(cql);
	        //logger.info("Execution result:" + result.toString());
			flag = true;
			tx.success();
		}
		return flag;
	}
	
	/**
	 * 更新用户信息
	 * 
	 * @param stu
	 * @return flag
	 */
	public boolean updateMessage(Student stu) {
		String id = stu.getStId();
		String stSex = stu.getStSex();
		String stAge = stu.getStAge();
		String stTel = stu.getStTel();
		String stDept = stu.getStDept();
		String stAddress = stu.getStAddress();
		String stIdCard = stu.getStIdCard();
    	boolean flag = false;
    	try(Transaction tx = graphDb.beginTx()){
    		ResourceIterable<Node> result=
    			graphDb.findNodesByLabelAndProperty(DbConn.studentLabel, "stId", id);
    		result.iterator().next().setProperty("stSex", stSex);
    		result.iterator().next().setProperty("stAge", stAge);
    		result.iterator().next().setProperty("stTel", stTel);
    		result.iterator().next().setProperty("stDept", stDept);
    		result.iterator().next().setProperty("stAddress", stAddress);
    		result.iterator().next().setProperty("stIdCard", stIdCard);
    		flag = true;
    		tx.success();
    	}
    	return flag;
	}
	
	/**
	 * 查询所有已经注册的用户id
	 * 
	 * @return list
	 */
	public List<Student> findAllStudent(){
		List<Student> list = new ArrayList<Student>();
		try(Transaction tx = graphDb.beginTx()){
			ExecutionEngine engine = new ExecutionEngine(graphDb);
			String cql = "match (stu:STUDENT)" +
					"return stu";
			ExecutionResult result = engine.execute(cql);
			Iterator<Student> ite = result.columnAs("stu");
			while (ite.hasNext()) {
				 Student stu = ite.next();
				 list.add(stu);
			}
	        //logger.info("Execution result:" + result.toString());
    		tx.success();
    	}
		return list;
	}
	/**
	 * 查询所有的好友
	 * 
	 * @return list
	 */
	public Set<Student>  findAllFriends(String id) {
		Set<Student> set = new HashSet<Student>();
		try(Transaction tx = graphDb.beginTx()){
			ExecutionEngine engine = new ExecutionEngine(graphDb);
			String cql = "match (stu:STUDENT) - [r] - (friend)" +
					"where stu.stId = " + id +
					"return friend";
			ExecutionResult result = engine.execute(cql);
			Iterator<Student> ite = result.columnAs("friend");
			while (ite.hasNext()) {
				 Student stu = ite.next();
				 set.add(stu);
			}
	        //logger.info("Execution result:" + result.toString());
    		tx.success();
    	}
		return set;
	}
	/**
	 * 分页查询
	 * 
	 * @return list
	 */
	/*
	public Set<Student> findFriendsByPageIndex(int pageIndex, int pageSize){
		
	}
	*/
	/**
	 * 删除指定的好友
	 * 
	 * @param id
	 * @return 
	 */
	public boolean delFriendByStId(String stId, String id) {
		boolean flag = false;
		try(Transaction tx = graphDb.beginTx()){
			ExecutionEngine engine = new ExecutionEngine(graphDb);
			String cql = "match (stu:STUDENT) - [r] - (friend:STUDENT)" +
					"where stu.stId = " + stId +
					"and friend.stId = " + id +
					"delete friend";
			ExecutionResult result = engine.execute(cql);
			flag = true;
	        //logger.info("Execution result:" + result.toString());
    		tx.success();
    	}
		return flag;
	}
	/**
	 * 添加指定的好友
	 * 
	 * @param id
	 * @return 
	 */
	public boolean addFriend(String stId, String fid) {
		boolean flag = false;
		try(Transaction tx = graphDb.beginTx()){
			ExecutionEngine engine = new ExecutionEngine(graphDb);
			String cql = "create (stu:STUDENT) - [r:IS_FRIEND_OF] -> (friend:STUDENT)" +
					"where stu.stId = " + stId +
					"and friend.stId = " + fid +
					"return r";
			ExecutionResult result = engine.execute(cql);
			flag = true;
	        //logger.info("Execution result:" + result.toString());
    		tx.success();
    	}
		return flag;
	}
	/**
	 * 根据stId查询某个学生
	 * 
	 * @param id
	 * @return 
	 */
	public Student findStudentByStId(String stId) {
		Student stu = new Student();
		try(Transaction tx = graphDb.beginTx()){
			ExecutionEngine engine = new ExecutionEngine(graphDb);
			String cql = "match (stu:STUDENT)" +
					"where stu.stId = " + stId +
					"return stu";
			ExecutionResult result = engine.execute(cql);
			Iterator<Student> ite = result.columnAs("stu");
			stu = ite.next();
	        //logger.info("Execution result:" + result.toString());
    		tx.success();
    	}
		return stu;
	}
	/**
	 * 查询某个好友
	 */
	public Student findFriendByStId(String stId, String id) {
		Student stu = new Student();
		try(Transaction tx = graphDb.beginTx()){
			ExecutionEngine engine = new ExecutionEngine(graphDb);
			String cql = "match (stu:STUDENT) -[r:IS_FRIEND_OF] - (friend:STUDENT)" +
					"where stu.stId = " + stId +
					"and friend.stId = " + id +
					"return stu";
			ExecutionResult result = engine.execute(cql);
			Iterator<Student> ite = result.columnAs("stu");
			stu = ite.next();
	        //logger.info("Execution result:" + result.toString());
    		tx.success();
    	}
		return stu;
	}
	/**
	 * 深度关系搜索实现
	 */
	public Set<Student> findStudentByDeepSearch(String stId, int deepth, String name, String age, String dept){
		Set<Student> set = new HashSet<Student>();
		try(Transaction tx = graphDb.beginTx()){
			ResourceIterable<Node> result=
	    			graphDb.findNodesByLabelAndProperty(DbConn.studentLabel, "stId", stId);
			Node node = result.iterator().next();
			TraversalDescription traversalFriends = 
					Traversal.description()
					.relationships(MyRelationshipTypes.IS_FRIEND_OF)
					.relationships(MyRelationshipTypes.IS_FRIEND_OF, Direction.OUTGOING)
						.uniqueness(Uniqueness.NODE_GLOBAL)
						.evaluator(Evaluators.atDepth(deepth));
			Traverser traverser = traversalFriends.traverse(node);
			Iterable<Node> nodes = traverser.nodes();
	        for(Node n: nodes){
	        	Student stu = (Student) n;
	        	if(stu.getStName() == name){
	        		continue;
	        	}
	        	if(stu.getStAge() == age){
	        		continue;
	        	}
	        	set.add(stu);
	        }
    		tx.success();
    	}
		return set;
	}
}

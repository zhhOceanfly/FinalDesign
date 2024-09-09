package com.dw.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.ResourceIterable;
import org.neo4j.graphdb.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dw.dao.AdminDao;
import com.dw.model.Admin;
import com.dw.model.Blog;
import com.dw.model.Student;
import com.dw.util.DbConn;

public class AdminDaoImpl implements AdminDao{

	private static Logger logger = LoggerFactory.getLogger(AdminDaoImpl.class);
	
	private GraphDatabaseService graphDb = DbConn.getGraphDb();
	/**
     * 登陆用户验证
     * @param page
     * @return
     */
    public boolean isLogin(Admin admin){
    	String adminid = admin.getAdminId();
    	String adpassword = admin.getAdPassword();
    	boolean flag = false;
    	ResourceIterable<Node> result=
    			graphDb.findNodesByLabelAndProperty(DbConn.adminLabel, "adminId", adminid);
    	String adPassword = result.iterator().next().getProperty("adPassword").toString();
        if(adPassword.equals(adpassword)){
        	flag = true;
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
				 list.add(stu);  //按照注册时间进行排序
			}
	        //logger.info("Execution result:" + result.toString());
    		tx.success();
    	}
		return list;
	}
	/**
	 * 根据stId查询某个学生
	 * 
	 * @param id
	 * @return 
	 */
	public Student findStudentBySId(String stId) {
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
	 * 删除用户
	 * @param id
	 * @return flag
	 */
	public boolean delStudent(String id){
		boolean flag = false;
		try(Transaction tx = graphDb.beginTx()){
			ExecutionEngine engine = new ExecutionEngine(graphDb);
			String cql = "match () - [r:MANAGER] - (stu:STUDENT)" +
					"where stu.stId = " + id +
					"delete stu, r";
			ExecutionResult result = engine.execute(cql);
	        //logger.info("Execution result:" + result.toString());
			flag = true;
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
	 * 空间日志列表--并按照时间排序
	 */
	public Map<Student, Blog> findAllBlog(){
		Map<Student, Blog> map = new HashMap<Student, Blog>();
		try(Transaction tx = graphDb.beginTx()){
			ExecutionEngine engine = new ExecutionEngine(graphDb);
			String cql = "match (stu:STUDENT) - [r:PUBLISH] - (blog:BLOG)" +
					"return stu, blog";
			ExecutionResult result = engine.execute(cql);
			Iterator<Blog> ite = result.columnAs("blog");
			Iterator<Student> ite1 = result.columnAs("stud");
			while(ite.hasNext() && ite1.hasNext()){
				map.put(ite1.next(), ite.next());
			}
	        //logger.info("Execution result:" + result.toString());
			tx.success();
		}
		return map;
	}
	/**
	 * 查询用户的日志列表
	 */
	public Map<Student, Blog> findAllBlogByStId(String stId){
		Map<Student, Blog> map = new HashMap<Student, Blog>();
		try(Transaction tx = graphDb.beginTx()){
			ExecutionEngine engine = new ExecutionEngine(graphDb);
			String cql = "match (stu:STUDENT) - [r:PUBLISH] - (blog:BLOG)" +
					"where stu.stId = " + stId +
					"return stu, blog";
			ExecutionResult result = engine.execute(cql);
			Iterator<Blog> ite = result.columnAs("blog");
			ResourceIterable<Node> result1 =
	    			graphDb.findNodesByLabelAndProperty(DbConn.studentLabel, "stId", stId);
			Student stu = (Student)result1.iterator().next();
			while(ite.hasNext()){
				map.put(stu, ite.next());
			}
	        //logger.info("Execution result:" + result.toString());
			tx.success();
		}
		return map;
	}
	/**
	 * 删除博客
	 * @param id
	 * @return flag
	 */
	public boolean delBlog(String id){
		boolean flag = false;
		try(Transaction tx = graphDb.beginTx()){
			ExecutionEngine engine = new ExecutionEngine(graphDb);
			String cql = "match () - [r] - (blog:BLOG)" +
					"where blog.blogId = " + id +
					"delete r, blog";
			ExecutionResult result = engine.execute(cql);
	        //logger.info("Execution result:" + result.toString());
			flag = true;
			tx.success();
		}
		return flag;
	}
	
}

package com.dw.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.ResourceIterable;
import org.neo4j.graphdb.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dw.dao.BlogDao;
import com.dw.model.Blog;
import com.dw.model.Comment;
import com.dw.model.MyRelationshipTypes;
import com.dw.model.Student;
import com.dw.util.DbConn;

public class BlogDaoImpl implements BlogDao  {

	private static Logger logger = LoggerFactory.getLogger(BlogDaoImpl.class);
	
	private GraphDatabaseService graphDb = DbConn.getGraphDb();
	/**
	 * 发表日志
	 */
	public boolean addBlog(String title, String stId) {
		boolean flag = false;
		try(Transaction tx = graphDb.beginTx()){
			ResourceIterable<Node> result=
	    			graphDb.findNodesByLabelAndProperty(DbConn.studentLabel, "stId", stId);
			Node stu = result.iterator().next();
			Node blog = graphDb.createNode(DbConn.blogLabel);
			Long nodeId = blog.getId();
			//logger.info("created user:" + student.getId());
			blog.setProperty("blogId", Blog.blogId);
			blog.setProperty("nodeId", nodeId);
			blog.setProperty("title", title);
			stu.createRelationshipTo(blog, MyRelationshipTypes.PUBLISH);
			//添加管理员的管理关系
			ResourceIterable<Node> result1=
	    			graphDb.findNodesByLabelAndProperty(DbConn.adminLabel, "adminId", "admin");
			Node admin = result1.iterator().next();
			Relationship manager = admin.createRelationshipTo(blog, MyRelationshipTypes.MANAGER);
			manager.setProperty("type", "blog");
			flag = true;
			tx.success();
    	}
		return flag;
	}
	/**
	 * 删除日志
	 */
	/*
	public boolean delBlogByBId(String id) {
		
	}
	*/
	/**
	 * 得到用户的某条日志
	 */
	public Map<Student, Blog> findOneBlogByBId(String bId){
		Map<Student, Blog> map = new HashMap<Student, Blog>();
		try(Transaction tx = graphDb.beginTx()){
			ResourceIterable<Node> result=graphDb.findNodesByLabelAndProperty(DbConn.blogLabel, "blogId", bId);
			Blog blog = (Blog)result.iterator().next();
			ExecutionEngine engine = new ExecutionEngine(graphDb);
			String cql = "match (stu) -[r:PUBLISH] - (blog:BLOG)" +
					"where blog.blogId = " + bId +
					"return stu";
			ExecutionResult result1 = engine.execute(cql);
			Iterator<Student> ite = result1.columnAs("stu");
			Student stu = ite.next();
			map.put(stu, blog);
			tx.success();
		}
		return map;
	}
	/**
	 * 空间日志列表--并按照时间排序
	 */
	public Map<Student, Blog> findAllFriendAndMeBlog(int count, String stId) {
		Map<Student, Blog> map = new HashMap<Student, Blog>();
		try(Transaction tx = graphDb.beginTx()){
			ResourceIterable<Node> result=graphDb.findNodesByLabelAndProperty(DbConn.studentLabel, "stId", stId);
			Student stu = (Student)result.iterator().next();
			ExecutionEngine engine = new ExecutionEngine(graphDb);
			String cql = "match (stu:STUDENT) -[r:PUBLISH] - (blog)," +
					"where stu.stId = " + stId +
					"return blog";
			ExecutionResult result1 = engine.execute(cql);
			Iterator<Blog> ite1 = result1.columnAs("blog");
			String cql2 = "match (stu:STUDENT) - [r1:IS_FRIEND_OF] -> (stud) - [r2:PUBLISH] -> (blog)" +
					"where stu.stId = " + stId +
					"return stud, blog";
			ExecutionResult result2 = engine.execute(cql2);
			Iterator<Blog> ite2 = result2.columnAs("blog");
			Iterator<Student> ite3 = result2.columnAs("stud");
			while(ite1.hasNext()){
				map.put(stu, ite1.next());
			}
			while(ite2.hasNext() && ite3.hasNext()){
				map.put(ite3.next(), ite2.next());
			}
			tx.success();
		}
		return map;
	}
	/**
	 * 查询用户的日志列表
	 */
	public List<Blog> findAllBlogByBId(String stId) {
		List<Blog> list = new ArrayList<Blog>();
		try(Transaction tx = graphDb.beginTx()){
			ExecutionEngine engine = new ExecutionEngine(graphDb);
			String cql = "match (stu:STUDENT) -[r:PUBLISH] - (blog)" +
					"where stu.stId = " + stId +
					"return blog";
			ExecutionResult result1 = engine.execute(cql);
			Iterator<Blog> ite = result1.columnAs("blog");
			while(ite.hasNext()){
				Blog blog = (Blog)ite.next();
				list.add(blog);
			}
			tx.success();
		}
		return list;
	}
	
	/**
	 * 查询日志的所有评论
	 */
	public List<Comment> findAllCommentOfBlogByBId(String id) {
		List<Comment> list = new ArrayList<Comment>();
		try(Transaction tx = graphDb.beginTx()){
			ExecutionEngine engine = new ExecutionEngine(graphDb);
			String cql = "match (blog:BLOG) -[r:COMMENT] - (comment)" +
					"where blog.blogId = " + id +
					"return comment";
			ExecutionResult result1 = engine.execute(cql);
			Iterator<Comment> ite = result1.columnAs("comment");
			while(ite.hasNext()){
				Comment com = (Comment)ite.next();
				list.add(com);
			}
			tx.success();
		}
		return list;
	}
	/**
	 * 评论某用户的日志
	 */
	public boolean commentBlog(String id, String title, String stId){
		boolean flag = false;
		try(Transaction tx = graphDb.beginTx()){
			ResourceIterable<Node> result=
	    			graphDb.findNodesByLabelAndProperty(DbConn.studentLabel, "stId", stId);
			Node stu = result.iterator().next();
			result = graphDb.findNodesByLabelAndProperty(DbConn.blogLabel, "blogId", id);
			Node blog = result.iterator().next();
			//logger.info("created user:" + student.getId());
			Relationship com = stu.createRelationshipTo(blog, MyRelationshipTypes.COMMENT);
			com.setProperty("comDate", new java.util.Date());
			com.setProperty("comTitle", title);
			flag = true;
			tx.success();
    	}
		return flag;
	}
	
	/**
	 * 点赞
	 */
	public boolean goodBlog(String id){
		boolean flag = false;
		try(Transaction tx = graphDb.beginTx()){
			ResourceIterable<Node> result = graphDb.findNodesByLabelAndProperty(DbConn.blogLabel, "blogId", id);
			Blog blog = (Blog)result.iterator().next();
			blog.addGoodCounts();
			flag = true;
			tx.success();
    	}
		return flag;
	}
	
	/**
	 * 深度关系搜索实现
	 */
	
	
}

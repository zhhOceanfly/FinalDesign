package com.dw.util;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.After;
import org.junit.Before;
import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.tooling.GlobalGraphOperations;

import com.dw.model.Student;

public class DbConn {
	
	private static Logger logger = LoggerFactory.getLogger(DbConn.class);
	/**
	 * 数据库连接类
	 * @author DY1101shaoyuxian
	 */
	private static String url = "tmp/neo4j/sns"; //"tmp/neo4j/sns"+RandomStringUtils.randomAlphanumeric(5)
	private static GraphDatabaseService graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(url);
	public static Label studentLabel = DynamicLabel.label("STUDENT");
	public static Label blogLabel = DynamicLabel.label("BLOG");
	public static Label adminLabel = DynamicLabel.label("ADMIN");
	
	public DbConn(){
		
	}
	public static GraphDatabaseService getGraphDb() {
		graphDb.schema().indexFor(studentLabel).on("stId").create();
		graphDb.schema().indexFor(blogLabel).on("blogId").create();
		graphDb.schema().indexFor(adminLabel).on("adminId").create();
		//graphDb.schema().indexFor(studentLabel).on("stPassword").create();
		manager();
		//添加管理员
		return graphDb;
	}
	/**
	 * 初始管理员配置
	 */
	public static void manager(){
		String adminid = "admin";
		String adpassword = "admin";
		
		try(Transaction tx = graphDb.beginTx()){
			Node admin = graphDb.createNode(DbConn.adminLabel);
			Long nodeId = admin.getId();
			admin.setProperty("adminId", adminid);
			admin.setProperty("nodeId", nodeId);
			admin.setProperty("adPassword", adpassword);
			//Index<Node> stIndex = graphDb.index().forNodes(StIndexName);
			//stIndex.add(student, "stId", id);
			tx.success();
		}
	}
	public void reset() {
        try (Transaction tx = graphDb.beginTx()) {
            GlobalGraphOperations ggo = GlobalGraphOperations.at(graphDb);
            for (Relationship r : ggo.getAllRelationships()) {
                r.delete();
            }
            for (Node n : ggo.getAllNodes()) {
                n.delete();
            }
            tx.success();
        }
    }
	@After
	public void closeGraphDb() {
		this.graphDb.shutdown();
	}
	//测试
	public static void main(String[] args) {
		
	}

}

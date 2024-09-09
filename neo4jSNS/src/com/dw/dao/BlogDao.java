package com.dw.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dw.model.Blog;
import com.dw.model.Comment;
import com.dw.model.Student;

public interface BlogDao {

	/**
	 * 发表日志
	 */
	public boolean addBlog(String title, String stId);
	/**
	 * 删除日志
	 */
	//public boolean delBlogByBId(String id);
	
	/**
	 * 得到用户的某条日志
	 */
	public Map<Student, Blog> findOneBlogByBId(String bId);
	/**
	 * 空间日志列表--并按照时间排序
	 */
	public Map<Student, Blog> findAllFriendAndMeBlog(int count, String stId);
	/**
	 * 查询用户的日志列表
	 */
	public List<Blog> findAllBlogByBId(String stId);
	
	/**
	 * 查询某日志的所有评论
	 */
	public List<Comment> findAllCommentOfBlogByBId(String id);
	/**
	 * 评论某用户的日志
	 */
	public boolean commentBlog(String id, String title, String stId);
	
	/**
	 * 点赞
	 */
	public boolean goodBlog(String id);
	
	/**
	 * 深度关系搜索实现
	 */
	
}
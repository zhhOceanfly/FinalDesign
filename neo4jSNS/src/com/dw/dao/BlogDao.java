package com.dw.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dw.model.Blog;
import com.dw.model.Comment;
import com.dw.model.Student;

public interface BlogDao {

	/**
	 * ������־
	 */
	public boolean addBlog(String title, String stId);
	/**
	 * ɾ����־
	 */
	//public boolean delBlogByBId(String id);
	
	/**
	 * �õ��û���ĳ����־
	 */
	public Map<Student, Blog> findOneBlogByBId(String bId);
	/**
	 * �ռ���־�б�--������ʱ������
	 */
	public Map<Student, Blog> findAllFriendAndMeBlog(int count, String stId);
	/**
	 * ��ѯ�û�����־�б�
	 */
	public List<Blog> findAllBlogByBId(String stId);
	
	/**
	 * ��ѯĳ��־����������
	 */
	public List<Comment> findAllCommentOfBlogByBId(String id);
	/**
	 * ����ĳ�û�����־
	 */
	public boolean commentBlog(String id, String title, String stId);
	
	/**
	 * ����
	 */
	public boolean goodBlog(String id);
	
	/**
	 * ��ȹ�ϵ����ʵ��
	 */
	
}
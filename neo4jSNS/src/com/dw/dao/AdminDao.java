package com.dw.dao;

import java.util.List;
import java.util.Map;

import com.dw.model.Admin;
import com.dw.model.Blog;
import com.dw.model.Student;

/**
 * 数据访问层，管理员CRUD操作
 * @author DY1101shaoyuxian
 */

public interface AdminDao {

	/**
     * 登陆用户验证
     * @param page
     * @return
     */
    public boolean isLogin(Admin admin);
    /**
	 * 查询所有已经注册的用户id
	 * 
	 * @return list
	 */
	public List<Student> findAllStudent();
	/**
	 * 根据stId查询某个学生
	 * 
	 * @param id
	 * @return 
	 */
	public Student findStudentBySId(String stId);
    /**
	 * 删除用户
	 * @param id
	 * @return flag
	 */
	public boolean delStudent(String id);
	/**
	 * 空间日志列表--并按照时间排序
	 */
	public Map<Student, Blog> findAllBlog();
	/**
	 * 查询用户的日志列表
	 */
	public Map<Student, Blog> findAllBlogByStId(String stId);
	/**
	 * 删除博客
	 * @param id
	 * @return flag
	 */
	public boolean delBlog(String id);
	
}

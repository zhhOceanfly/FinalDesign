package com.dw.dao;

import java.util.List;
import java.util.Map;

import com.dw.model.Admin;
import com.dw.model.Blog;
import com.dw.model.Student;

/**
 * ���ݷ��ʲ㣬����ԱCRUD����
 * @author DY1101shaoyuxian
 */

public interface AdminDao {

	/**
     * ��½�û���֤
     * @param page
     * @return
     */
    public boolean isLogin(Admin admin);
    /**
	 * ��ѯ�����Ѿ�ע����û�id
	 * 
	 * @return list
	 */
	public List<Student> findAllStudent();
	/**
	 * ����stId��ѯĳ��ѧ��
	 * 
	 * @param id
	 * @return 
	 */
	public Student findStudentBySId(String stId);
    /**
	 * ɾ���û�
	 * @param id
	 * @return flag
	 */
	public boolean delStudent(String id);
	/**
	 * �ռ���־�б�--������ʱ������
	 */
	public Map<Student, Blog> findAllBlog();
	/**
	 * ��ѯ�û�����־�б�
	 */
	public Map<Student, Blog> findAllBlogByStId(String stId);
	/**
	 * ɾ������
	 * @param id
	 * @return flag
	 */
	public boolean delBlog(String id);
	
}

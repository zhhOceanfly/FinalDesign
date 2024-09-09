package com.dw.dao;

/**
 * ���ݷ��ʲ㣬ѧ����ϢCRUD����
 * @author DY1101shaoyuxian
 */

import java.util.List;
import java.util.Set;

import org.neo4j.graphdb.GraphDatabaseService;

import com.dw.model.Student;
import com.dw.util.DbConn;

public interface StudentDao {
	
	/**
	 * ע���û�
	 * @param page
	 * @return 
	 */
	public boolean register(Student stu);
	/**
     * ��½�û���֤
     * @param page
     * @return
     */
    public boolean isLogin(Student stu);
	/**
	 * �޸��û�������
	 * @param page
	 * @return
	 */
	public boolean updatePassWord(Student stu);
	/**
	 * ɾ���û���Ϣ--ע��
	 * @param id
	 * @return flag
	 */
	public boolean delStudent(String id);
	
	/**
	 * �����û���Ϣ
	 * 
	 * @param stu
	 * @return flag
	 */
	public boolean updateMessage(Student stu);

	/**
	 * ��ѯ�����Ѿ�ע����û�id
	 * 
	 * @return list
	 */
	public List<Student> findAllStudent();
	/**
	 * ��ѯ���еĺ���
	 * 
	 * @return list
	 */
	public Set<Student>  findAllFriends(String id);
	/**
	 * ��ҳ��ѯ
	 * 
	 * @return list
	 */
	//public Set<Student> findFriendsByPageIndex(int pageIndex, int pageSize);
	/**
	 * ɾ��ָ���ĺ���
	 * 
	 * @param id
	 * @return 
	 */
	public boolean delFriendByStId(String stId, String id);
	/**
	 * ���ָ���ĺ���
	 * 
	 * @param id
	 * @return 
	 */
	public boolean addFriend(String stId, String fid);
	/**
	 * ��ѯĳ������
	 * 
	 * @param id
	 * @return
	 */
	public Student findFriendByStId(String stId, String id);
	/**
	 * ����stId��ѯĳ��ѧ��
	 * 
	 * @param id
	 * @return 
	 */
	public Student findStudentByStId(String stId);
	
	/**
	 * ��ȹ�ϵ����ʵ��
	 */
	public Set<Student> findStudentByDeepSearch(String stId, int deepth, String name, String age, String dept);
}

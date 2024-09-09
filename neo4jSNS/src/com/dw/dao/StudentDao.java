package com.dw.dao;

/**
 * 数据访问层，学生信息CRUD操作
 * @author DY1101shaoyuxian
 */

import java.util.List;
import java.util.Set;

import org.neo4j.graphdb.GraphDatabaseService;

import com.dw.model.Student;
import com.dw.util.DbConn;

public interface StudentDao {
	
	/**
	 * 注册用户
	 * @param page
	 * @return 
	 */
	public boolean register(Student stu);
	/**
     * 登陆用户验证
     * @param page
     * @return
     */
    public boolean isLogin(Student stu);
	/**
	 * 修改用户的密码
	 * @param page
	 * @return
	 */
	public boolean updatePassWord(Student stu);
	/**
	 * 删除用户信息--注销
	 * @param id
	 * @return flag
	 */
	public boolean delStudent(String id);
	
	/**
	 * 更新用户信息
	 * 
	 * @param stu
	 * @return flag
	 */
	public boolean updateMessage(Student stu);

	/**
	 * 查询所有已经注册的用户id
	 * 
	 * @return list
	 */
	public List<Student> findAllStudent();
	/**
	 * 查询所有的好友
	 * 
	 * @return list
	 */
	public Set<Student>  findAllFriends(String id);
	/**
	 * 分页查询
	 * 
	 * @return list
	 */
	//public Set<Student> findFriendsByPageIndex(int pageIndex, int pageSize);
	/**
	 * 删除指定的好友
	 * 
	 * @param id
	 * @return 
	 */
	public boolean delFriendByStId(String stId, String id);
	/**
	 * 添加指定的好友
	 * 
	 * @param id
	 * @return 
	 */
	public boolean addFriend(String stId, String fid);
	/**
	 * 查询某个好友
	 * 
	 * @param id
	 * @return
	 */
	public Student findFriendByStId(String stId, String id);
	/**
	 * 根据stId查询某个学生
	 * 
	 * @param id
	 * @return 
	 */
	public Student findStudentByStId(String stId);
	
	/**
	 * 深度关系搜索实现
	 */
	public Set<Student> findStudentByDeepSearch(String stId, int deepth, String name, String age, String dept);
}

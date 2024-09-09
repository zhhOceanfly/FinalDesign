package com.dw.model;

import java.util.HashSet;
import java.util.Set;

/**
 * 管理员实体类
 * 
 * @author DY1101shaoyuxian
 * 
 */
public class Admin {

	private String adminId;// 账号
	private Long nodeId; //neo4j内部编号
	private String adPassword;// 密码
	
	Set<Student> student = new HashSet<Student>();
	
	Set<Blog> blog = new HashSet<Blog>();
	
	public Set<Student> getStudent() {
		return student;
	}
	public void addStudent(Student stu) {
		student.add(stu);
	}
	
	public Set<Blog> getBlog() {
		return blog;
	}
	public void deleteBlog(Blog blog){
		this.blog.remove(blog);
	}
	
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	
	public Long getNodeId() {
		return nodeId;
	}
	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}
	
	public String getAdPassword() {
		return adPassword;
	}
	public void setAdPassword(String adpassword) {
		this.adPassword = adpassword;
	}
	
	public Admin() {
		super();
	}
	public Admin(String adminId, String adpassword) {
		this.adminId = adminId;
		this.adPassword = adpassword;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admin stu = (Admin) o;

        if (nodeId != null ? !nodeId.equals(stu.nodeId) : stu.nodeId != null) return false;
        
        return true;
    }

    @Override
    public int hashCode() {
        return nodeId != null ? nodeId.hashCode() : 0;
    }
}

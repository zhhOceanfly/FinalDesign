package com.xidian.stuweb.user;

import java.util.HashSet;
import java.util.Set;

import com.xidian.stuweb.blog.Blog;

/**
 *用户的实体类，跟stuweb数据库中的user表相互关联，有用户名,学号，电话，性别，密码；
 *+----------+-------------+------+-----+---------+----------------+
| Field    | Type        | Null | Key | Default | Extra          |
+----------+-------------+------+-----+---------+----------------+
| uid      | int(11)     | NO   | PRI | NULL    | auto_increment |
| username | varchar(20) | YES  |     | NULL    |                |
| stuid    | varchar(30) | YES  |     | NULL    |                |
| phone    | varchar(30) | YES  |     | NULL    |                |
| gender   | varchar(10) | YES  |     | NULL    |                |
| password | varchar(20) | YES  |     | NULL    |                |
+----------+-------------+------+-----+---------+----------------+
 *
 */
public class User {
	private String username;
	private String stuid;
	private String phone;
	private String gender;
	private Integer uid;
	private String password;
	private Set<Blog> blogs = new HashSet<Blog>();
	
	public Set<Blog> getBlogs() {
		return blogs;
	}
	public void setBlogs(Set<Blog> blogs) {
		this.blogs = blogs;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", stuid=" + stuid + ", phone="
				+ phone + ", gender=" + gender + ", uid=" + uid + ", password="
				+ password + "]";
	}
	
	
	
}

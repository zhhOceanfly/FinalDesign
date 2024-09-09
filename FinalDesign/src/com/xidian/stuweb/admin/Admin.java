package com.xidian.stuweb.admin;

import java.util.HashSet;
import java.util.Set;

import com.xidian.stuweb.notice.Notice;

/**
 * +-----------+-------------+------+-----+---------+----------------+
| Field     | Type        | Null | Key | Default | Extra          |
+-----------+-------------+------+-----+---------+----------------+
| aid       | int(11)     | NO   | PRI | NULL    | auto_increment |
| adminname | varchar(20) | YES  |     | NULL    |                |
| password  | varchar(20) | YES  |     | NULL    |                |
+-----------+-------------+------+-----+---------+----------------+
 *
 */
public class Admin {
	
	private String adminname;
	private String password;
	private Integer aid;
	private Set<Notice> notices = new HashSet<Notice>();
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Set<Notice> getNotices() {
		return notices;
	}
	public void setNotices(Set<Notice> notices) {
		this.notices = notices;
	}
	@Override
	public String toString() {
		return "Admin [adminname=" + adminname + ", password=" + password
				+ ", aid=" + aid + ", ]";
	}
	

}

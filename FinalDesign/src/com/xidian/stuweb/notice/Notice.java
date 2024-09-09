package com.xidian.stuweb.notice;


import java.util.Date;


import com.xidian.stuweb.admin.Admin;

/**
 * +---------+-------------+------+-----+---------+----------------+
| Field   | Type        | Null | Key | Default | Extra          |
+---------+-------------+------+-----+---------+----------------+
| nid     | int(11)     | NO   | PRI | NULL    | auto_increment |
| title   | varchar(60) | YES  |     | NULL    |                |
| content | text        | YES  |     | NULL    |                |
| aid     | int(11)     | YES  | MUL | NULL    |                |
| date    | datetime    | YES  |     | NULL    |                |
+---------+-------------+------+-----+---------+----------------+
 *
 */

public class Notice {
	
	private Integer nid;
	private String title;
	private String content;
	private Admin admin;
	private Date date;
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	@Override
	public String toString() {
		return "Notice [nid=" + nid + ", title=" + title + ", content="
				+ content + ", admin=" + admin +date+ "]";
	}
	
	
}

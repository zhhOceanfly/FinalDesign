package com.xidian.stuweb.blog;

import java.util.Date;
/*+----------+--------------+------+-----+---------+----------------+
| Field    | Type         | Null | Key | Default | Extra          |
+----------+--------------+------+-----+---------+----------------+
| bid      | int(11)      | NO   | PRI | NULL    | auto_increment |
| content  | varchar(255) | YES  |     | NULL    |                |
| blogdate | datetime     | YES  |     | NULL    |                |
| uid      | int(11)      | YES  | MUL | NULL    |                |
+----------+--------------+------+-----+---------+----------------+*/

import com.xidian.stuweb.user.User;

public class Blog {
	private Integer bid;
	private String content;
	private Date blogdate;
	private User user;
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getBlogdate() {
		return blogdate;
	}
	public void setBlogdate(Date blogdate) {
		this.blogdate = blogdate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

	
}

package com.xidian.stuweb.test;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport {
	
	private String content;
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String run(){
		return "loginSuccess";
	}
	public String index(){
		return "indexSuccess";
	}
	public String edit(){
		
		
		
		return "editSuccess";
	}
	
}

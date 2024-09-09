package com.xidian.stuweb.blog;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xidian.stuweb.admin.Admin;
import com.xidian.stuweb.user.User;
import com.xidian.stuweb.user.UserService;

public class BlogAction extends ActionSupport implements ModelDriven<Blog> {
	private BlogService blogService;
	private UserService userService;
	//模型驱动封装数据blog，
	private Blog blog = new Blog();
	private Integer uid;
	
	

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public void setBlogService(BlogService blogService) {
		this.blogService = blogService;
	}
	@Override
	public Blog getModel() {
		return this.blog;
	}
	
	
	public String blogPage(){
		return "blogPageSuccess";
	}
	//保存通知消息，首先通过页面传过来的uid参数查询出指定的user表中的记录，将该记录保存到blog实例对象中，
	//通过封装数据，将blog保存到blog表中即可；
	public String saveBlog(){
		User user = userService.findByUid(uid);
		blog.setUser(user);
		blog.setBlogdate(new Date());
		blogService.saveBlog(blog);
		this.addActionMessage("发送留言成功");
		return "saveBlogSuccess";
	}
	//查询所有留言信息的方法，将查询结果列表存储到值栈中，采用的是模型驱动，blog存在值栈中
	public String findAllBlog(){
		
		List<Blog>bloglist = blogService.findAllBlog();
		ActionContext.getContext().getValueStack().set("bloglist", bloglist);
		
		
		return "findAllBlogSuccess";
	}
	

}

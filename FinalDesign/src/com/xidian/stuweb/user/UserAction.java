package com.xidian.stuweb.user;

import java.util.List;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.xidian.stuweb.notice.Notice;
import com.xidian.stuweb.notice.NoticeAction;
import com.xidian.stuweb.notice.NoticeService;
import com.xidian.stuweb.utils.PageBean;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	
	private Integer page;//接受页数
	private UserService userService;
	private NoticeService noticeService;
	private User user = new User();//模型驱动封装数据
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return this.user;
	}
	//根据页数来查找学生，实现分页查找的功能；
	public String findByPage(){
		
		PageBean pageBean = userService.findByPage(page);
		ActionContext.getContext().getSession().put("pageBean", pageBean);
		
		return "findByPageSuccess";
	}
	//根据学生表中的uid主键来查找指定的学生信息，
	public String findByUid(){
		//将数据表中的该学生的信息封装的user对象中，因为user是模型驱动封装的数据，所以在访问该action
		//的时候，该user对象直接放到了值栈中，在jsp页面中直接取得即可，注意取值的时候要用model.属性的方法取值
		user = userService.findByUid(user.getUid());
		
		return "findByUidSuccess";
	}
	
	//实现更新学生信息的功能；
	public String updateUser(){
		
		//jsp传递过来的信息通过模型驱动封装到user对象中，通过user对象来直接操纵数据库实现更新。
		userService.updateUser(user);
		this.addActionMessage("更新学生信息成功");
		return "msgSuccess";
	}
	//实现通过学生的uid来删除学生的功能
	public String deleteByUid(){
		userService.deleteByUid(user);
		this.addActionMessage("删除该学生信息成功");
		return "msgSuccess";
	}
	
	//该方法主要是为了访问到添加用户的jsp页面，即是实现跳转到添加用户页面的功能
	public String addUserPage(){
		
		
		return "addUserPageSuccess";
	}
	
	//实现添加用户的功能
	public String addUser(){
		userService.addUser(user);
		this.addActionMessage("添加学号为"+user.getStuid()+"的学生信息成功");
		return "msgSuccess";
	}
	
	//实现按照学号查询指定学生信息的方法。
	@InputConfig(resultName="findByStuidInput")//当有actionError错误的时候指定imput的跳转页面。
	public String findByStuid(){
		List<User> list = userService.findByStuid(user);
		if(list == null || list.size() == 0){
			this.addActionError("该"+user.getStuid()+"学号不存在请重新搜索");
			return "findByStuidInput";
		}
		else{
			
			
			
			//将查询到的信息放到session域中取名为userlist;
			ActionContext.getContext().getSession().put("userlist", list);
			return "findByStuidSuccess";
		}
	}
	//实现按照学生姓名查询指定学生信息的方法。
	@InputConfig(resultName="findByStuidInput")
	public String findByUsername(){
		
		List<User>list = userService.findByUsername(user);
		if(list == null || list.size() == 0){
			this.addActionError("没有姓名为"+user.getUsername()+"学生的记录请重新搜索");
			return "findByStuidInput";
		}
		else{
			ActionContext.getContext().getSession().put("userlist", list);
			return "findByStuidSuccess";
		}
		
	}
	//实现访问登录页面的功能；
	public String loginPage(){
		
		return "loginPageSuccess";
	}
	
	/**
	 * 实现登录功能的方法，
	 * 1、从登录页面传递过来的账号密码值(其中账号的默认值是学号，密码的默认值是学号的后六位)，被封装到了user对象中
	 * 2、通过该user对象查询数据库，即从数据库中查找也学号和密码相匹配的数据。
	 * 3、如果数据存在，则证明用户存在，登录成功；如果用户数据不存在，返回的为空值，则说明该账号和密码所对应的数据不存在提示登录失败；
	 * @return
	 */
	@InputConfig(resultName="loginInput")
	public String login(){
		
		//产生uuid为了让每次显示的错误信息有不同的提示，便于识别。
		String uuid = UUID.randomUUID().toString().substring(0, 5);
		User exituser = userService.findUser(user);
		if(exituser == null){
			this.addActionError("账号或者密码错误请重新登录错误代码:"+uuid);
			return "loginInput";
			
		}
		else {
			//将登录用户的数据保存到session域中,名为exituser;
			ActionContext.getContext().getSession().put("exituser", exituser);
			
			
			/*保证实时获得发布的通知消息,因为访问网站的首页的时候，就先进行了一次查询通知数据的操作，并且将该数据保存在
			 * session域当中，而用户登录之后的首页中也会显示通知，所以此处再做一次查询通知数据的操作，并且覆盖掉之前session域
			 * 中已经保存了的通知数据，实现session域中key为noticelist的value值的更新。也是为了当后台发布通知消息后，用户的首页页面能够实时的显示
			 * */
			
			List<Notice> noticelist = noticeService.findAllNotice();
			ActionContext.getContext().getSession().put("noticelist", noticelist);
			return "loginSuccess";
		}
			
		
	}
	
}

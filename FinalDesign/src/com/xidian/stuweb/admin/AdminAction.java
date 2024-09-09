package com.xidian.stuweb.admin;

import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

public class AdminAction extends ActionSupport implements ModelDriven<Admin> {
	
	//采用模型驱动
	private Admin admin = new Admin();
	private AdminService adminService;
	
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}


	@Override
	public Admin getModel() {
		// TODO Auto-generated method stub
		return admin;
	}
	
	//跳转到登录页面 
	public String loginPage(){
		return "loginPageSuccess";
	}
	
	@InputConfig(resultName = "loginInput")
	public String login(){
		UUID uuid = UUID.randomUUID();
		String wrong = uuid.toString().substring(0,5);
		Admin exitadmin = adminService.findAdmin(admin);//调用该方法实现从表中查询封装在admin中的账号和密码，返回查询的结果
		if(exitadmin ==null){  //判断查询的结果是否为空，为空则表示数据库中有对应的记录，登录成功，否则登录失败
			this.addActionError("账号或者密码错误请重新登录"+wrong);//添加相应的提示信息，uuid确保每次信息不同
			return "loginInput";
		}
		else{
			ActionContext.getContext().getSession().put("exitadmin", exitadmin);
			return "loginSuccess";
			}
	}
	//跳转到发布通知页面
	public String pubInfoPage(){
		return "pubInfoPageSuccess";
	}
	//管理员退出操作
	public String exitAdmin(){
		//销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		
		return "exitAdminSuccess";
	}
	

}

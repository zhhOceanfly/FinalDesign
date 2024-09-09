package com.xidian.stuweb.notice;

import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.xidian.stuweb.admin.Admin;
import com.xidian.stuweb.admin.AdminService;

public class NoticeAction extends ActionSupport implements ModelDriven<Notice> {
	private NoticeService noticeService;
	private AdminService adminService;
	private Notice notice = new Notice();
	private Integer aid;
	
	
	
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}
	
	//模型驱动封装数据到notice中；
	@Override
	public Notice getModel() {
		return notice;
	}
	//保存通知消息，因为采用的是模型驱动，所以标题，和文本信息都封装到了notice对象中了，只需要执行相关的操作就可以了
	public String saveNotice(){
		Admin admin = adminService.findByAid(aid);
		notice.setAdmin(admin);
		notice.setDate(new Date());
		noticeService.saveNotice(notice);
		
		//当保存的时候实时更新session中的通知的信息
		List<Notice> noticelist = noticeService.findAllNotice();
		ActionContext.getContext().getSession().put("noticelist", noticelist);
		this.addActionMessage("发布通知消息成功");
		
		return "msgSuccess";
	}
	//实现查询通知的方法，根据通知的nid主键进行查询；
	public String findByNid(){
		
		notice = noticeService.findByNid(notice.getNid());
		
		return "findByNidSuccess";
	}
	
	//实现跳转页面的功能，访问到指定的jsp页面,管理员查询通知信息的页面
	public String noticeAdminPage(){
		
		return "noticeAdminPageSuccess";
		
	}
	//实现跳转页面的功能，访问到指定的jsp页面,用户查询通知信息的页面
	public String noticeUserPage(){
		
		return "noticeUserPageSuccess";
		
	}
	//实现删除通知消息的功能，将jsp页面传递过来的数据封装到notice对象中，然后执行删除的操作
	public String deleteByNid(){
		noticeService.deleteByNid(notice);
		//删除之后，再次查询notice表的操作，将查询的结果再次放到session域中，实现session域中的数据的更新。
		List<Notice> noticelist = noticeService.findAllNotice();
		ActionContext.getContext().getSession().put("noticelist", noticelist);
		this.addActionMessage("删除该通知消息成功");
		return "msgSuccess";//跳转到msg.jsp中并且显示相应的提示信息
	}
	
	
}

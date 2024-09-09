package com.xidian.stuweb.index;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.xidian.stuweb.notice.Notice;
import com.xidian.stuweb.notice.NoticeService;

public class IndexAction {
	
	private NoticeService noticeService;
	
	
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	//跳转到网站首页的操作，先执行查询所有的通知的操作，将其保存到session域中
	public String execute(){
		
		List<Notice> noticelist = noticeService.findAllNotice();
		ActionContext.getContext().getSession().put("noticelist", noticelist);
		
		
		return "indexSuccess";
	}
	
	
}

package com.xidian.stuweb.notice;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class NoticeDao extends HibernateDaoSupport {
	
	//保存通知信息的操作
	public void saveNotice(Notice notice) {
		
		this.getHibernateTemplate().save(notice);
		
	}
	
	//查询所有通知的操作，并且按照主键进行倒叙的方式进行查找，为了将后面发布的通知显示在前面的位置上面。
	public List<Notice> findAllNotice() {
		
		List <Notice> list = this.getHibernateTemplate().find("from Notice order by nid desc");
		return list;
	}
	
	//根据notice的主键查询对应的通知消息
	public Notice findByNid(Integer nid) {
		List <Notice> list = this.getHibernateTemplate().find("from Notice where nid = ?",nid);
		if(list!=null && list.size()>0)
			return list.get(0);
		else
			return null;
	}
	//根据主键删除对应的通知消息
	public void deleteByNid(Notice notice) {

		this.getHibernateTemplate().delete(notice);
	}

}

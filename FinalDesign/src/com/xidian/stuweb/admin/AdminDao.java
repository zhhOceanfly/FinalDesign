package com.xidian.stuweb.admin;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AdminDao extends HibernateDaoSupport {

	//查询指定账号和密码的管理员用户
	public Admin findAdmin(Admin admin) {
		
		List<Admin> list = this.getHibernateTemplate().find("from Admin where adminname = ? and password = ?",admin.getAdminname(),admin.getPassword());
		if(list!=null && list.size()>0)
			return list.get(0);
		else
			return null;
	}
	//根据主键aid来查找指定的管理员用户
	public  Admin findByAid(Integer aid) {
		List <Admin> list = this.getHibernateTemplate().find("from Admin where aid = ?",aid);
		if(list!=null && list.size()>0)
			return list.get(0);
		else
			return null;
	}

}

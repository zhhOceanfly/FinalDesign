package com.xidian.stuweb.admin;

import org.springframework.transaction.annotation.Transactional;

//注解开启事务
@Transactional
public class AdminService {
	
	private AdminDao adminDao;
	

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}


	public Admin findAdmin(Admin admin) {
			
		return adminDao.findAdmin(admin);
		}


	public Admin findByAid(Integer aid) {

		return adminDao.findByAid(aid);
	}

}

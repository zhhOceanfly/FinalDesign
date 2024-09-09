package com.xidian.stuweb.user;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xidian.stuweb.utils.PageBean;

@Transactional
public class UserService {
	
	private UserDao userDao;
	

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public PageBean findByPage(Integer page) {
		
		PageBean pageBean = new PageBean();//实例化一个PageBean对象；
		pageBean.setPage(page);//设置当前页数
		Integer limit = 8; 
		pageBean.setLimit(limit);//设置每页显示的条数为8；
		Integer totalCount = userDao.findByTotalCount();//通过持久层去查询user表中总共的记录数
		pageBean.setTotalCount(totalCount);//设置总共的记录数
		//设置总共的页数，为总的记录数除以每页显示数，不够除则加1取整；
		Integer totalPage = 0;
		if(totalCount%limit == 0 ){
			totalPage = totalCount/limit;
			pageBean.setTotalPage(totalPage);
		}
		if(totalCount%limit != 0){
			totalPage = totalCount/limit+1;
			pageBean.setTotalPage(totalPage);
		}
		//查询当前页说现实的记录数，当前页的开始记录数为 （当前页-1）*每页的显示数
		Integer begin = (page-1) * limit;
		List<User>list = userDao.findByPage(begin,limit);  //通过持久层去查询出指定页面的记录然后封装到List<User>中；
		pageBean.setList(list);
		return pageBean;
	}


	public User findByUid(Integer uid) {
		return userDao.findByUid(uid);
	}


	public void updateUser(User user) {
		
		userDao.updateUser(user);
	}


	public void deleteByUid(User user) {
		userDao.deleteByUid(user);
		
	}


	public void addUser(User user) {
		userDao.addUser(user);
		
	}


	public List<User> findByStuid(User user) {
		return userDao.findByStuid(user);
	}


	public List<User> findByUsername(User user) {
		return userDao.finByUsername(user);
	}


	public User findUser(User user) {
		return userDao.findUser(user);
	}

}

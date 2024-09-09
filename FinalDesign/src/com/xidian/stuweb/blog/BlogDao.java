package com.xidian.stuweb.blog;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;



public class BlogDao extends HibernateDaoSupport {

	//保存留言的操作
	public void saveBlog(Blog blog) {
		
		this.getHibernateTemplate().save(blog);
	}
	//查询所有留言的操作
	public List<Blog> findAllBlog() {
		List <Blog> list = this.getHibernateTemplate().find("from Blog order by bid desc");
		return list;
	}

}

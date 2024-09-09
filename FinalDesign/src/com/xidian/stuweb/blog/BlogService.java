package com.xidian.stuweb.blog;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional

public class BlogService {
	
	private BlogDao blogDao;

	public void setBlogDao(BlogDao blogDao) {
		this.blogDao = blogDao;
	}



	public void saveBlog(Blog blog) {
		blogDao.saveBlog(blog);
	}



	public List<Blog> findAllBlog() {
		return blogDao.findAllBlog();
	}
	
}

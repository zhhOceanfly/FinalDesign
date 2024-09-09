package com.xidian.stuweb.user;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDao extends HibernateDaoSupport {

	public Integer findByTotalCount() {
		
		List <Long> list = this.getHibernateTemplate().find("select count(*) from User");
		return list.get(0).intValue();
	}
	//进行分页查询，传入的参数，分页的第一条的记录数，每页显示的记录数
	//通过调用hibernate模板中的executeFind方法，得到Hibernate中”对应的”session对象，便可以很容易的得到Query对象了，便也可以很好的进行查询。
	public List<User> findByPage(final Integer begin, final Integer limit) {
		
		List<User> list = this.getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Query query = session.createQuery("from User");
				query.setFirstResult(begin);//设置起始的查询记录数
				query.setMaxResults(limit);//设置每页的显示数
				List list2 = query.list(); //查询操作返回为列表；
				return list2;
			}
		});
		
		return list;
	}
	//根据uid主键去查询指定的user表中的记录
	public User findByUid(Integer uid) {
		
		User user = this.getHibernateTemplate().get(User.class, uid);
		return user;
		
	}
	//根据user对象中的数据去更新user表中对应的记录
	public void updateUser(User user) {
		this.getHibernateTemplate().update(user);
		
	}
	//根据user对象中的数据去删除user表中对应的记录
	public void deleteByUid(User user) {
		
		this.getHibernateTemplate().delete(user);
		
	}
	//将user对象中的数据作为记录添加到user表中。
	public void addUser(User user) {
		
		 this.getHibernateTemplate().save(user);
		
	}
//根据学号去查询user表中的记录
	public List<User> findByStuid(User user) {
		List<User> list = this.getHibernateTemplate().find("from User where stuid=?",user.getStuid());
		return list;
	}
//根据用户的名字去查询user表中的记录
	public List<User> finByUsername(User user) {
		List <User> list = this.getHibernateTemplate().find("from User where username=?",user.getUsername());
		return list;
		
	}
//根据user对象中的学号和密码去查询user表中是否有指定的记录
	public User findUser(User user) {
		
		List <User> list = this.getHibernateTemplate().find("from User where stuid = ? and password = ?",user.getStuid(),user.getPassword());
		if(list!=null && list.size()>0)
			return list.get(0);
		else
			return null;
	}

}


package com.hibernate.repository.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hibernate.entity.Users;
import com.hibernate.entity.vo.UsersVo;
import com.hibernate.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
    private SessionFactory sessionFactory;

	/**
	 * 1. openSession每次打开都是新的Session,所以多次获取的Session实例是不同的，并且需要人为的调用close方法进行Session关闭。
	 * 		可选@Transactional
	 * 2. getCurrentSession是从当前上下文中获取Session并且会绑定到当前线程，第一次调用时会创建一个Session实例，如果该Session未关闭，
	 *	 	后续多次获取的是同一个Session实例；事务提交或者回滚时会自动关闭Sesison,无需人工关闭。
	 *		必须加@Transactional
	 */
    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    
//    @Autowired
//    public HibernateTemplate hibernateTemplate;
//
//    @Override
//    public Long save(Users entity) {
//        return (Long) hibernateTemplate.save(entity);
//    }
	
	@Override
	public Long save(Users user) {
		return (Long) getCurrentSession().save(user);
	}

    @Override
    public UsersVo getUserByMobile(String mobile) {
    	
    	String hql = " SELECT"
    			+ " 	new com.hibernate.entity.vo.UsersVo(u.userId, u.mobile, u.userName, ue.point)"
    			+ " FROM Users AS u LEFT JOIN UserExtends AS ue "
    			+ "		ON u.userId=ue.userId"
    			+ " WHERE"
    			+ " 	u.mobile=:mobile";   
    	Query query = getCurrentSession().createQuery(hql);
    	query.setParameter("mobile", mobile, StringType.INSTANCE);
    	query.setFirstResult(0);
    	query.setMaxResults(1);
    	List<UsersVo> list = query.list();
        if (list.size() > 0) {
        	return list.get(0);
        }
    	return null;
    }

	@Override
	public List<UsersVo> getUserList() {
		
		String hql = " SELECT"
    			+ " 	new com.hibernate.entity.vo.UsersVo(u.userId, u.mobile, u.userName, ue.point)"
    			+ " FROM Users AS u LEFT JOIN UserExtends AS ue "
    			+ "		ON u.userId=ue.userId";
    	Query query = getCurrentSession().createQuery(hql);
    	query.setFirstResult(0);
    	query.setMaxResults(5);
    	return (List<UsersVo>) query.list();
	}

	@Override
	public int updateUser(String mobile, String userName) {
		String hql = " UPDATE"
    			+ " 	Users SET userName=:userName"
    			+ "	WHERE "
    			+ " 	mobile=:mobile";
		Query query = getCurrentSession().createQuery(hql);
		query.setParameter("mobile", mobile, StringType.INSTANCE);
		query.setParameter("userName", userName, StringType.INSTANCE);
		return query.executeUpdate();
	}
    
    
    
}

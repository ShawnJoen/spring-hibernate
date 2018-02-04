package com.hibernate.repository.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.hibernate.entity.Users;
import com.hibernate.entity.vo.UsersVo;
import com.hibernate.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
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
    
}

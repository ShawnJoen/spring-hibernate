package com.hibernate.repository.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import com.hibernate.entity.Users;
import com.hibernate.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    public HibernateTemplate hibernateTemplate;
    
    @Override
    public Users load(Long id) {
        return hibernateTemplate.load(Users.class, id);
    }
    @Override
    public Users get(Long id) {
        return hibernateTemplate.get(Users.class,id);
    }
    @Override
    public List<Users> findAll() {
        return null;
    }
    @Override
    public void persist(Users entity) {
    	hibernateTemplate.persist(entity);
    }
    @Override
    public Long save(Users entity) {
        return (Long) hibernateTemplate.save(entity);
    }
    @Override
    public void saveOrUpdate(Users entity) {
    	hibernateTemplate.saveOrUpdate(entity);
    }
    @Override
    public void delete(Long id) {
    	Users user = load(id);
    	hibernateTemplate.delete(user);
    }
    @Override
    public void flush() {
    	hibernateTemplate.flush();
    }

}

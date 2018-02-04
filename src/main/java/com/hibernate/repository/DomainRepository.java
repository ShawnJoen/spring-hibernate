package com.hibernate.repository;

import java.io.Serializable;
import java.util.List;

/**
 * 数据库访问层
 */
public interface DomainRepository<T extends Serializable> {
	T load(Long id);

    T get(Long id);

    List<T> findAll();

    void persist(T entity);

    Long save(T entity);

    void saveOrUpdate(T entity);

    void delete(Long id);

    void flush();
}

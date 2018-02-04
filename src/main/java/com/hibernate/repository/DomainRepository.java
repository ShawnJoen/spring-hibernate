package com.hibernate.repository;

import java.io.Serializable;
import java.util.List;

/**
 * 数据库访问层
 */
public interface DomainRepository<T extends Serializable> {
    Long save(T entity);
}

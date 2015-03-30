package com.mugbya.injection.dao;

import java.util.List;

/**
 * Created by mugbya on 2015/3/30.
 */
public interface  BaseDAO<T,K> {
    public int save(T entity)throws Exception;

    public int update(T entity)throws Exception;

    public int delete(K id)throws Exception;

    public T findById(K id)throws Exception;

    public List<T> findAll()throws Exception;
}

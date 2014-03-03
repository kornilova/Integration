package com.estylesoft.integration.Database.mybatis;

import org.apache.ibatis.exceptions.PersistenceException;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 29.01.14
 * Time: 15:05
 * To change this template use File | Settings | File Templates.
 */
public interface IDAO<T> {
    public T getById(String query,Long id) throws PersistenceException;
    public T getByCode(String query,String name) throws PersistenceException;
    public ArrayList<T> getAll(String query) throws PersistenceException;
    public T create(String query,T obj) throws PersistenceException;
    void update(String query,T obj) throws PersistenceException;
    void delete(String query,Long id)  throws PersistenceException;
    void delete(String query,String value)  throws PersistenceException;
    void delete(String query,T obj)  throws PersistenceException;
    public T getByMap(String query,Map params) throws PersistenceException;
}

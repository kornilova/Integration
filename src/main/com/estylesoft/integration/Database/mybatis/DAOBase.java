package com.estylesoft.integration.Database.mybatis;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 28.01.14
 * Time: 19:11
 * To change this template use File | Settings | File Templates.
 */
public abstract class DAOBase<T> implements IDAO<T> {

    private SqlSessionFactory session;
    private Class<T> type;

    public DAOBase(Class<T> type, SqlSessionFactory session) {
        org.apache.ibatis.logging.LogFactory.useLog4JLogging();
        this.type = type;
        this.session = session;
        if (session == null) throw new NullPointerException();


    }

    protected SqlSessionFactory getSessionFactory() {
        return session;
    }

    @Override
    public T getById(String query, Long id) throws PersistenceException {
        SqlSession sqlSession = session.openSession();
        T obj = null;
        try {
            obj = (T) sqlSession.selectOne(query, id);
        } finally {
            sqlSession.close();
        }
        return obj;
    }

    @Override
    public T getByCode(String query, String code) throws PersistenceException {
        SqlSession sqlSession = session.openSession();
        T obj = null;
        try {
            obj = (T) sqlSession.selectOne(query, code);
        } finally {
            sqlSession.close();
        }
        return obj;
    }

    @Override
    public T getByMap(String query, Map params) throws PersistenceException {
        SqlSession sqlSession = session.openSession();
        T obj = null;
        try {
            obj = (T) sqlSession.selectOne(query, params);
        } finally {
            sqlSession.close();
        }
        return obj;
    }

    @Override
    public ArrayList<T> getAll(String query) throws PersistenceException {
        SqlSession sqlSession = session.openSession();
        ArrayList<T> list = null;
        try {
            list = (ArrayList<T>) sqlSession.selectList(query);
        } finally {
            sqlSession.close();
        }
        return list;
    }

    @Override
    public T create(String query, T obj) throws PersistenceException {
        SqlSession sqlSession = session.openSession();
        try {
            sqlSession.insert(query, obj);
            sqlSession.commit();
            return obj;
        } catch (Exception ex) {
            throw new UnsupportedOperationException(ex);
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void update(String query, T obj) throws PersistenceException {
        SqlSession sqlSession = session.openSession();
        try {
            sqlSession.update(query, obj);
            sqlSession.commit();
        } catch (Exception ex) {
            throw new UnsupportedOperationException(ex);
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void delete(String query, Long id) throws PersistenceException {
        SqlSession sqlSession = session.openSession();
        try {
            sqlSession.delete(query, id);
            sqlSession.commit();
        } catch (Exception ex) {
            throw new UnsupportedOperationException(ex);
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void delete(String query, String value) throws PersistenceException {
        SqlSession sqlSession = session.openSession();
        try {
            sqlSession.delete(query, value);
            sqlSession.commit();
        } catch (Exception ex) {
            throw new UnsupportedOperationException(ex);
        } finally {
            sqlSession.close();
        }
    }

    @Override
    public void delete(String query, T obj) throws PersistenceException {
        SqlSession sqlSession = session.openSession();
        try {
            sqlSession.delete(query, obj);
            sqlSession.commit();
        } catch (Exception ex) {
            throw new UnsupportedOperationException(ex);
        } finally {
            sqlSession.close();
        }
    }


}

package com.estylesoft.integration.Database.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 28.01.14
 * Time: 20:11
 * To change this template use File | Settings | File Templates.
 */
public abstract class MyBatisSqlSession {
    public static SqlSessionFactory SQL_SESSION_FACTORY;

    public static SqlSessionFactory getSqlSessionFactory(){  return SQL_SESSION_FACTORY; }
}

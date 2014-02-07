package com.estylesoft.integration.Database.mybatis;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.Properties;

public class MyBatisPtksSqlSessionFactory extends MyBatisSqlSession {

    static {
        try {
            Reader reader = Resources.getResourceAsReader(
                    MyBatisPtksSqlSessionFactory.class.getClassLoader(), "mybatis/mybatis.xml");
            assert reader != null;
            Properties props = new Properties();
           props.setProperty("resource", "mybatis/databasePtks.properties");
            SQL_SESSION_FACTORY = new SqlSessionFactoryBuilder().build(reader, props);
        } catch (Exception e) {
            throw new RuntimeException("Fatal error. Cause: " + e.getMessage(), e);
        }
    }

   /* public static SqlSessionFactory setSqlSessionFactory(SqlSessionFactory factory) {
        SqlSessionFactory oldFactory = SQL_SESSION_FACTORY;
        SQL_SESSION_FACTORY = factory;
        return oldFactory;
    }  */
}

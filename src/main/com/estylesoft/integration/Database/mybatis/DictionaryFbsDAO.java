package com.estylesoft.integration.Database.mybatis;

import java.util.List;

import com.estylesoft.integration.Model.TbFbsModelBase;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class DictionaryFbsDAO {
    private static SqlSession session;

    static {
        SqlSessionFactory sqlSessionFactory = MyBatisFbsSqlSessionFactory.getSqlSessionFactory();
        session = sqlSessionFactory.openSession(true);
    }

    public List<TbFbsModelBase> getCodeKbk() {
        //Map params = new HashMap();
        //params.put("name", null);
        return (List<TbFbsModelBase>) session.selectList("getCodeKbk");
    }

    public List<TbFbsModelBase> getNameInsurerType() {
        //Map params = new HashMap();
        //params.put("name", null);
        return (List<TbFbsModelBase>) session.selectList("getNameInsurerType");
    }

    public void closeSession() {
        session.close();
    }
}

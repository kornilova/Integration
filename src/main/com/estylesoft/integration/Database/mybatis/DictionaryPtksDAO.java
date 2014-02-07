package com.estylesoft.integration.Database.mybatis;

import com.estylesoft.integration.Model.TbPtksModelBase;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 31.10.13
 * Time: 17:38
 * To change this template use File | Settings | File Templates.
 */
public class DictionaryPtksDAO {
    private static SqlSession session;

    static {
        SqlSessionFactory sqlSessionFactory = MyBatisPtksSqlSessionFactory.getSqlSessionFactory();
        session = sqlSessionFactory.openSession(true);
    }

    public List<TbPtksModelBase> getCodeFbsIsActualKbk() {
        //Map params = new HashMap();
        //params.put("name", null);
        return (List<TbPtksModelBase>) session.selectList("getCodeFbsIsActualKbk");
    }

    public List<TbPtksModelBase> getNameFbsIsActualInsurerType() {
        //Map params = new HashMap();
        //params.put("name", null);
        return (List<TbPtksModelBase>) session.selectList("getNameFbsIsActualInsurerType");
    }

    public void closeSession() {
        session.close();
    }
}

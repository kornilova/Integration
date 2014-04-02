package com.estylesoft.integration.Database.mybatis.Fbs.Dictionary;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Fbs.Dictionary.KbkModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 14:14
 * To change this template use File | Settings | File Templates.
 */
public class KbkDAO extends DAOBase<KbkModel> {

    private final String namespace = "kbk";

    public KbkDAO(Class<KbkModel> type, SqlSessionFactory containerSessionFactory) {
        super(type, containerSessionFactory);
    }

    public Long insert(KbkModel obj) {
        return super.create(namespace + "." + "insert", obj).getId();
    }

    public void delete(Long id) {
        super.delete(namespace + "." + "delete", id);
    }

    public KbkModel getByCode(String code)
    {
        return super.getByCode(namespace + "." + "getByCode", code);
    }

    public KbkModel getById(Long id)
    {
        return super.getById(namespace + "." + "getById", id);
    }
}

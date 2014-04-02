package com.estylesoft.integration.Database.mybatis.Ptks;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Ptks.OkvedModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 14:24
 * To change this template use File | Settings | File Templates.
 */
public class OkvedDAO extends DAOBase<OkvedModel> {

    private final String namespace = "okved";

    public OkvedDAO(Class<OkvedModel> type,SqlSessionFactory containerSessionFactory) {
        super(type,containerSessionFactory);
    }

    public Long insert(OkvedModel obj)
    {
        return super.create(namespace + "." + "insert", obj).getId();
    }

    public void delete(Long id)
    {
        super.delete(namespace + "." + "delete", id);
    }

    public OkvedModel getByCode(String code)
    {
        return super.getByCode(namespace + "." + "getByCode", code);
    }

    public OkvedModel getById(Long id)
    {
        return super.getById(namespace + "." + "getById", id);
    }
}

package com.estylesoft.integration.Database.mybatis.Ptks;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Ptks.OkatoModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 13:38
 * To change this template use File | Settings | File Templates.
 */
public class OkatoDAO extends DAOBase<OkatoModel> {

    private final String namespace = "okato";

    public OkatoDAO(Class<OkatoModel> type,SqlSessionFactory containerSessionFactory) {
        super(type,containerSessionFactory);
    }

    public Long insert(OkatoModel obj)
    {
        return super.create(namespace + "." + "insert", obj).getId();
    }

    public void delete(Long id)
    {
        super.delete(namespace + "." + "delete", id);
    }

    public OkatoModel getByCode(String code)
    {
        return super.getByCode(namespace + "." + "getByCode", code);
    }

    public OkatoModel getById(Long id)
    {
        return super.getById(namespace + "." + "getById", id);
    }
}

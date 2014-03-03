package com.estylesoft.integration.Database.mybatis.Ptks;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Ptks.AdmTerritoryModel;
import com.estylesoft.integration.Model.Ptks.StreetModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 17:00
 * To change this template use File | Settings | File Templates.
 */
public class StreetDAO extends DAOBase<StreetModel> {

    private final String namespace = "street";

    public StreetDAO(Class<StreetModel> type, SqlSessionFactory containerSessionFactory) {
        super(type,containerSessionFactory);
    }

    public Long insert(StreetModel obj)
    {
        return super.create(namespace + "." + "insert", obj).getId();
    }

    public void delete(StreetModel obj)
    {
        super.delete(namespace + "." + "delete", obj.getCode());
    }

    public StreetModel getByCode(String code)
    {
        return super.getByCode(namespace + "." + "getByCode", code);
    }
}
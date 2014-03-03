package com.estylesoft.integration.Database.mybatis.Ptks;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Ptks.AdmTerritoryModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 17:00
 * To change this template use File | Settings | File Templates.
 */
public class AdmTerritoryDAO extends DAOBase<AdmTerritoryModel> {

    private final String namespace = "admTerritory";

    public AdmTerritoryDAO(Class<AdmTerritoryModel> type,SqlSessionFactory containerSessionFactory) {
        super(type,containerSessionFactory);
    }

    public Long insert(AdmTerritoryModel obj)
    {
        return super.create(namespace + "." + "insert", obj).getId();
    }

    public void delete(AdmTerritoryModel obj)
    {
        super.delete(namespace + "." + "delete", obj.getCode());
    }

    public AdmTerritoryModel getByCode(String code)
    {
        return super.getByCode(namespace + "." + "getByCode", code);
    }
}
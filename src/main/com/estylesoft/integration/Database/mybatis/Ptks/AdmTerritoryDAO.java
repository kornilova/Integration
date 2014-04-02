package com.estylesoft.integration.Database.mybatis.Ptks;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Ptks.AdmTerritoryModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Map;

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

    public void delete(Long id)
    {
        super.delete(namespace + "." + "delete", id);
    }

    public AdmTerritoryModel getByCodeRegionIdTerDepIdBaseDepId(Map params)
    {
        return super.getByMap(namespace + "." + "getByCodeRegionIdTerDepIdBaseDepId", params);
    }

    public AdmTerritoryModel getById(Long id)
    {
        return super.getById(namespace + "." + "getById", id);
    }
}
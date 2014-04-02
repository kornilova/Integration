package com.estylesoft.integration.Database.mybatis.Ptks;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Ptks.AdmTerritoryModel;
import com.estylesoft.integration.Model.Ptks.CityModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 17:00
 * To change this template use File | Settings | File Templates.
 */
public class CityDAO extends DAOBase<CityModel> {

    private final String namespace = "city";

    public CityDAO(Class<CityModel> type, SqlSessionFactory containerSessionFactory) {
        super(type,containerSessionFactory);
    }

    public Long insert(CityModel obj)
    {
        return super.create(namespace + "." + "insert", obj).getId();
    }

    public void delete(Long id)
    {
        super.delete(namespace + "." + "delete", id);
    }

    public CityModel getByCodeAdmTerrIdRegionIdTerDepIdBaseDepId(Map params)
    {
        return super.getByMap(namespace + "." + "getByCodeAdmTerrIdRegionIdTerDepIdBaseDepId", params);
    }

    public CityModel getByCode(String code)
    {
        return super.getByCode(namespace + "." + "getByCode", code);
    }

    public CityModel getById(Long id)
    {
        return super.getById(namespace + "." + "getById", id);
    }
}
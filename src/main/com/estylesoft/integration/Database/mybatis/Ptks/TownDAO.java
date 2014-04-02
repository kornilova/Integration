package com.estylesoft.integration.Database.mybatis.Ptks;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Ptks.CityModel;
import com.estylesoft.integration.Model.Ptks.TownModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 17:00
 * To change this template use File | Settings | File Templates.
 */
public class TownDAO extends DAOBase<TownModel> {

    private final String namespace = "town";

    public TownDAO(Class<TownModel> type, SqlSessionFactory containerSessionFactory) {
        super(type,containerSessionFactory);
    }

    public Long insert(TownModel obj)
    {
        return super.create(namespace + "." + "insert", obj).getId();
    }

    public void delete(Long id)
    {
        super.delete(namespace + "." + "delete", id);
    }

    public TownModel getByCodeCityIdAdmTerritoryIdRegionIdTerDepIdBaseDepId(Map params)
    {
        return super.getByMap(namespace + "." + "getByCodeCityIdAdmTerritoryIdRegionIdTerDepIdBaseDepId", params);
    }

    public TownModel getById(Long id)
    {
        return super.getById(namespace + "." + "getById", id);
    }
}
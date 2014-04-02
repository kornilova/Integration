package com.estylesoft.integration.Database.mybatis.Ptks;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Ptks.AdmTerritoryModel;
import com.estylesoft.integration.Model.Ptks.StreetModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Map;

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

    public void delete(Long id)
    {
        super.delete(namespace + "." + "delete", id);
    }

    public StreetModel getByCodeCityIdTownIdAdmTerIdRegionIdBaseDepId(Map params)
    {
        return super.getByMap(namespace + "." + "getByCodeCityIdTownIdAdmTerIdRegionIdBaseDepId", params);
    }

    public StreetModel getById(Long id)
    {
        return super.getById(namespace + "." + "getById", id);
    }
}
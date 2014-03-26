package com.estylesoft.integration.Exchange;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.AdmTerritoryDAO;
import com.estylesoft.integration.Database.mybatis.Ptks.CityDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.AdmTerritoryModel;
import com.estylesoft.integration.Model.Ptks.CityModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 13:41
 * To change this template use File | Settings | File Templates.
 */
public class CityHelper {

    private CityDAO cityDAO;

    public CityHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.cityDAO=new CityDAO(CityModel.class, sqlSessionFactory);
    }

    public CheckResult create(CityModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        obj.setId(cityDAO.insert(obj));
        if (obj.getId()==null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_CITY is not inserted.");
        }
        return res;
    }

    public void delete(CityModel obj) throws IntegrationException {
        cityDAO.delete(obj);
    }


    public CityModel getByCodeAdmTerrIdRegionIdTerDepIdBaseDepId(String code,
                                                                Long admTerritoryId,
                                                                Long regionId,
                                                                Long terDepartmentPFRId,
                                                                Long baseDepartmentId) throws IntegrationException {
        Map<String, Object> params = new HashMap<String, Object>(5);
        params.put("code", code);
        params.put("admTerritoryId", admTerritoryId);
        params.put("regionId", regionId);
        params.put("terDepartmentPFR.id", terDepartmentPFRId);
        params.put("baseDepartmentId", baseDepartmentId);
        return code!=null?cityDAO.getByCodeAdmTerrIdRegionIdTerDepIdBaseDepId(params):null;
    }

    public CityModel getByCode(String code) throws IntegrationException {
        return cityDAO.getByCode(code);
    }
}

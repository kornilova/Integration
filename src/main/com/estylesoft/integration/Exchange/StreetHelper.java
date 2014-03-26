package com.estylesoft.integration.Exchange;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.AdmTerritoryDAO;
import com.estylesoft.integration.Database.mybatis.Ptks.StreetDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.AdmTerritoryModel;
import com.estylesoft.integration.Model.Ptks.StreetModel;
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
public class StreetHelper {

    private StreetDAO streetDAO;

    public StreetHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.streetDAO=new StreetDAO(StreetModel.class, sqlSessionFactory);
    }

    public CheckResult create(StreetModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        obj.setId(streetDAO.insert(obj));
        if (obj.getId()==null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_STREET is not inserted.");
        }
        return res;
    }

    public void delete(StreetModel obj) throws IntegrationException {
        streetDAO.delete(obj);
    }

    public StreetModel getByCodeCityIdTownIdAdmTerIdRegionIdBaseDepId(String code,
                                                                      Long cityId,
                                                                      Long townId,
                                                                      Long admTerritoryId,
                                                                      Long regionId,
                                                                      Long baseDepartmentId) throws IntegrationException {
        Map<String, Object> params = new HashMap<String, Object>(4);
        params.put("code", code);
        params.put("cityId", cityId);
        params.put("admTerritoryId", admTerritoryId);
        params.put("regionId", regionId);
        params.put("townId", townId);
        params.put("baseDepartmentId", baseDepartmentId);

        return code!=null? streetDAO.getByCodeCityIdTownIdAdmTerIdRegionIdBaseDepId(params):null;
    }
}

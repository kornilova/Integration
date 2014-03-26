package com.estylesoft.integration.Exchange;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.CityDAO;
import com.estylesoft.integration.Database.mybatis.Ptks.TownDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.CityModel;
import com.estylesoft.integration.Model.Ptks.TownModel;
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
public class TownHelper {

    private TownDAO townDAO;

    public TownHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.townDAO=new TownDAO(TownModel.class, sqlSessionFactory);
    }

    public CheckResult create(TownModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        obj.setId(townDAO.insert(obj));
        if (obj.getId()==null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_TOWN is not inserted.");
        }
        return res;
    }

    public void delete(TownModel obj) throws IntegrationException {
        townDAO.delete(obj);
    }

    public TownModel getByCodeCityIdAdmTerritoryIdRegionIdTerDepIdBaseDepId(String code,
                                                                            Long cityId,
                                                                            Long admTerritoryId,
                                                                            Long regionId,
                                                                            Long terDepartmentPFRId,
                                                                            Long baseDepartmentId) throws IntegrationException {
        Map<String, Object> params = new HashMap<String, Object>(4);
        params.put("code", code);
        params.put("cityId", cityId);
        params.put("admTerritoryId", admTerritoryId);
        params.put("regionId", regionId);
        params.put("terDepartmentPFRId", terDepartmentPFRId);
        params.put("baseDepartmentId", baseDepartmentId);

        return code!=null? townDAO.getByCodeCityIdAdmTerritoryIdRegionIdTerDepIdBaseDepId(params):null;
    }
}

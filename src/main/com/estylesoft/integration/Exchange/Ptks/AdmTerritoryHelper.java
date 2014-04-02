package com.estylesoft.integration.Exchange.Ptks;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.AdmTerritoryDAO;
import com.estylesoft.integration.Database.mybatis.Ptks.RegionDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.AdmTerritoryModel;
import com.estylesoft.integration.Model.Ptks.RegionModel;
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
public class AdmTerritoryHelper {

    private AdmTerritoryDAO admTerritoryDAO;

    public AdmTerritoryHelper(SqlSessionFactory sqlSessionFactory) {
        this.admTerritoryDAO = new AdmTerritoryDAO(AdmTerritoryModel.class, sqlSessionFactory);
    }

    public CheckResult create(AdmTerritoryModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        obj.setId(admTerritoryDAO.insert(obj));
        if (obj.getId() == null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_TERRITORY is not inserted.");
        }
        return res;
    }


    public CheckResult delete(AdmTerritoryModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);

        if (obj.getId() == null)
            obj = getByCodeRegionIdTerDepIdBaseDepId(obj.getCode(),
                    obj.getRegionId(),
                    obj.getTerDepartmentPFRId(),
                    obj.getBaseDepartmentId());

        admTerritoryDAO.delete(obj.getId());

        if (admTerritoryDAO.getById(obj.getId()) != null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_TERRITORY is not deleted.");
        }

        return res;
    }

    public AdmTerritoryModel getByCodeRegionIdTerDepIdBaseDepId(String code,
                                                                Long regionId,
                                                                Long terDepartmentPFRId,
                                                                Long baseDepartmentId) throws IntegrationException {
        Map<String, Object> params = new HashMap<String, Object>(4);
        params.put("code", code);
        params.put("regionId", regionId);
        params.put("terDepartmentPFRId", terDepartmentPFRId);
        params.put("baseDepartmentId", baseDepartmentId);
        return code != null ? admTerritoryDAO.getByCodeRegionIdTerDepIdBaseDepId(params) : null;
    }
}

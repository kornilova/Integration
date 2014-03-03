package com.estylesoft.integration.Exchange;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.AdmTerritoryDAO;
import com.estylesoft.integration.Database.mybatis.Ptks.RegionDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.AdmTerritoryModel;
import com.estylesoft.integration.Model.Ptks.RegionModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 13:41
 * To change this template use File | Settings | File Templates.
 */
public class AdmTerritoryHelper {

    private AdmTerritoryDAO admTerritoryDAO;

    public AdmTerritoryHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.admTerritoryDAO=new AdmTerritoryDAO(AdmTerritoryModel.class, sqlSessionFactory);
    }

    public CheckResult create(AdmTerritoryModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        obj.setId(admTerritoryDAO.insert(obj));
        if (obj.getId()==null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_TERRITORY is not inserted.");
        }
        return res;
    }

    public void delete(AdmTerritoryModel obj) throws IntegrationException {
        admTerritoryDAO.delete(obj);
    }

    public AdmTerritoryModel getByCode(String code) throws IntegrationException {
        return admTerritoryDAO.getByCode(code);
    }
}

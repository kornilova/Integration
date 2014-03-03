package com.estylesoft.integration.Exchange;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.OkatoDAO;
import com.estylesoft.integration.Database.mybatis.Ptks.RegionDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.OkatoModel;
import com.estylesoft.integration.Model.Ptks.RegionModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 13:41
 * To change this template use File | Settings | File Templates.
 */
public class RegionHelper {

    private RegionDAO regionDAO;

    public RegionHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.regionDAO=new RegionDAO(RegionModel.class, sqlSessionFactory);
    }

    public CheckResult create(RegionModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        obj.setId(regionDAO.insert(obj));
        if (obj.getId()==null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_REGION is not inserted.");
        }
        return res;
    }

    public void delete(RegionModel obj) throws IntegrationException {
        regionDAO.delete(obj);
    }


    public RegionModel getByCode(String code) throws IntegrationException {
        return regionDAO.getByCode(code);
    }
}

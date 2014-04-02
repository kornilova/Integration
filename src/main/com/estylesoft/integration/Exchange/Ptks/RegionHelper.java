package com.estylesoft.integration.Exchange.Ptks;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.OkatoDAO;
import com.estylesoft.integration.Database.mybatis.Ptks.RegionDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.OkatoModel;
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

    public CheckResult delete(RegionModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);

        if (obj.getId() == null)
            obj = getByCode(obj.getKladrCode());

        regionDAO.delete(obj.getId());

        if (regionDAO.getById(obj.getId()) != null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_REGION is not deleted.");
        }

        return res;
    }


    public RegionModel getByCode(String code) throws IntegrationException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("code", code);
        return code!=null?regionDAO.getByCode(params):null;
    }
}

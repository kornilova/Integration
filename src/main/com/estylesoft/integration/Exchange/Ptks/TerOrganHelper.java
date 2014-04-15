package com.estylesoft.integration.Exchange.Ptks;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.TerOrganDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.TerOrganModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 31.01.14
 * Time: 18:01
 * To change this template use File | Settings | File Templates.
 */
public class TerOrganHelper {

    private TerOrganDAO terOrganDAO;

    public TerOrganHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.terOrganDAO=new TerOrganDAO(TerOrganModel.class, sqlSessionFactory);
    }

    public CheckResult create(TerOrganModel obj
    ) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        if (terOrganDAO.insert(obj)==null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_TERRITORIAL_ORGAN is not inserted.");
        }
        return res;
    }

    public CheckResult delete(TerOrganModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);

        if (obj.getId() == null)
            obj = getByCodeOpfr(
                    obj.getCode(), obj.getOpfrId());

        terOrganDAO.delete(obj.getId());

        if ( terOrganDAO.getById(obj.getId()) != null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_TERRITORIAL_ORGAN is not deleted.");
        }

        return res;
    }

    public TerOrganModel getByCodeOpfr(String code, Long opfrId) throws IntegrationException {
        Map<String, Object> params = new HashMap<String, Object>(2);
        params.put("code", code);
        params.put("opfrId", opfrId);
        return terOrganDAO.getByCodeOpfr(params);
    }

    public List<TerOrganModel> getAll()
    {
        return terOrganDAO.getAll();
    }
}

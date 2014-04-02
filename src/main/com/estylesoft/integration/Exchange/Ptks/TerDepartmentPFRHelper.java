package com.estylesoft.integration.Exchange.Ptks;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.TerDepartmentPFRDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.TerDepartmentPFRModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 12:05
 * To change this template use File | Settings | File Templates.
 */
public class TerDepartmentPFRHelper
{
    private TerDepartmentPFRDAO terDepDAO;

    public TerDepartmentPFRHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.terDepDAO=new TerDepartmentPFRDAO(TerDepartmentPFRModel.class, sqlSessionFactory);
    }

    public CheckResult create(TerDepartmentPFRModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        obj.setId(terDepDAO.insert(obj));
        if (obj.getId()==null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_TERRITORY_DPT_PFR is not inserted.");
        }
        return res;
    }

    public CheckResult delete(TerDepartmentPFRModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);

        if (obj.getId() == null)
            obj = getByCodeBaseDepTerOrgan(
                    obj.getCode(), obj.getBaseDepartmentId(), obj.getTerOrganId());

        terDepDAO.delete(obj.getId());

        if ( terDepDAO.getById(obj.getId()) != null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_TERRITORY_DPT_PFR is not deleted.");
        }

        return res;
    }

    public TerDepartmentPFRModel getByCode(String code) throws IntegrationException {
        return terDepDAO.getByCode(code);
    }

    public TerDepartmentPFRModel getByCodeBaseDepTerOrgan(String code,
                                                          Long baseDepartmentId,
                                                          Long terOrganId) throws IntegrationException {
        Map<String, Object> params = new HashMap<String, Object>(3);
        params.put("code", code);
        params.put("baseDepartmentId", baseDepartmentId);
        params.put("terOrganId", terOrganId);
        return terDepDAO.getByCodeBaseDepTerOrgan(params);
    }
}

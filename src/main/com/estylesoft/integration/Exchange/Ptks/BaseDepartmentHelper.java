package com.estylesoft.integration.Exchange.Ptks;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.BaseDepartmentDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.BaseDepartmentModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 29.01.14
 * Time: 0:21
 * To change this template use File | Settings | File Templates.
 */
public class BaseDepartmentHelper {

    private BaseDepartmentDAO boDAO;

    public BaseDepartmentHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.boDAO=new BaseDepartmentDAO(BaseDepartmentModel.class, sqlSessionFactory);
    }

    public CheckResult create(BaseDepartmentModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        obj.setId(boDAO.insert(obj));
        if (obj.getId()==null) {
                    res.setIsSuccess(false);
                    res.setMessageTest("ERROR: STH_REG_DIV_PFR is not inserted.");
                }
        return res;
    }

    public CheckResult delete(BaseDepartmentModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);

        if(obj.getId()==null)
            obj = getByCodeOpfr(obj.getCode(), obj.getOpfrId());

        boDAO.delete(obj.getId());

        if(boDAO.getById(obj.getId())!=null)
        {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_REG_DIV_PFR is not deleted.");
        }

        return res;
    }

    public BaseDepartmentModel getByCodeOpfr(String code, Long opfrId) throws IntegrationException {
        Map<String, Object> params = new HashMap<String, Object>(2);
        params.put("code", code);
        params.put("opfrId", opfrId);
        return code!=null?boDAO.getByCodeOpfr(params):null;
    }
}

package com.estylesoft.integration.Exchange;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.BaseDepartmentDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.BaseDepartmentModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 29.01.14
 * Time: 0:21
 * To change this template use File | Settings | File Templates.
 */
public class BaseDepartmentHelper {

    private BaseDepartmentDAO boDAO;

    public BaseDepartmentHelper(BaseDepartmentDAO boDAO)
    {
        this.boDAO=boDAO;
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

    public void delete(BaseDepartmentModel obj) throws IntegrationException {
        boDAO.delete(obj);
    }
}

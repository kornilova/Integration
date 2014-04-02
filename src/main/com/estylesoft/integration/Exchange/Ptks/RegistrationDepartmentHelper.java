package com.estylesoft.integration.Exchange.Ptks;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.OpfDAO;
import com.estylesoft.integration.Database.mybatis.Ptks.RegistrationDepartmentDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.OpfModel;
import com.estylesoft.integration.Model.Ptks.RegistrationDepartmentModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 29.01.14
 * Time: 0:21
 * To change this template use File | Settings | File Templates.
 */
public class RegistrationDepartmentHelper {

    private RegistrationDepartmentDAO registrationDepartmentDAO;

    public RegistrationDepartmentHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.registrationDepartmentDAO=new RegistrationDepartmentDAO(RegistrationDepartmentModel.class, sqlSessionFactory);
    }

    public CheckResult create(RegistrationDepartmentModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        obj.setId(registrationDepartmentDAO.insert(obj));
        if (obj.getId()==null) {
                    res.setIsSuccess(false);
                    res.setMessageTest("ERROR: STH_TERRITORY_DPT_REG is not inserted.");
                }
        return res;
    }

    public CheckResult delete(RegistrationDepartmentModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);

        if (obj.getId() == null)
            obj = getByCode(obj.getCode());

        registrationDepartmentDAO.delete(obj.getId());

        if (registrationDepartmentDAO.getById(obj.getId()) != null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_TERRITORY_DPT_REG is not deleted.");
        }

        return res;
    }

    public RegistrationDepartmentModel getByCode(String code) throws IntegrationException {
        return registrationDepartmentDAO.getByCode(code);
    }
}

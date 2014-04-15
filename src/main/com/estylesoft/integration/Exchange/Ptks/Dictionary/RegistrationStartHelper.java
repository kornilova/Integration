package com.estylesoft.integration.Exchange.Ptks.Dictionary;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.Dictionary.RegistrationStartDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.Dictionary.RegistrationStartModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 29.01.14
 * Time: 0:21
 * To change this template use File | Settings | File Templates.
 */
public class RegistrationStartHelper {

    private RegistrationStartDAO registrationStartDAO;

    public RegistrationStartHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.registrationStartDAO=new RegistrationStartDAO(RegistrationStartModel.class, sqlSessionFactory);
    }

    public CheckResult create(RegistrationStartModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        registrationStartDAO.insert(obj);
        obj.setId(registrationStartDAO.getByCode(obj.getCode()).getId());
        if (obj.getId()==null) {
                    res.setIsSuccess(false);
                    res.setMessageTest("ERROR: STH_ARRANGE_REG is not inserted.");
                }
        return res;
    }

    public CheckResult delete(RegistrationStartModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);

        if (obj.getId() == null)
            obj = getByCode(obj.getCode());

        registrationStartDAO.delete(obj.getId());

        if (registrationStartDAO.getById(obj.getId()) != null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_ARRANGE_REG is not deleted.");
        }

        return res;
    }

    public RegistrationStartModel getByCode(String code) throws IntegrationException {
        return registrationStartDAO.getByCode(code);
    }

    public List<RegistrationStartModel> getAll() throws IntegrationException {
        return registrationStartDAO.getAll();
    }
}

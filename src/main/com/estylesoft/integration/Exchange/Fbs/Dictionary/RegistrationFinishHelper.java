package com.estylesoft.integration.Exchange.Fbs.Dictionary;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Fbs.Dictionary.RegistrationFinishDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Fbs.Dictionary.RegistrationFinishModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 29.01.14
 * Time: 0:21
 * To change this template use File | Settings | File Templates.
 */
public class RegistrationFinishHelper {

    private RegistrationFinishDAO registrationFinishDAO;

    public RegistrationFinishHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.registrationFinishDAO=new RegistrationFinishDAO(RegistrationFinishModel.class, sqlSessionFactory);
    }

    public CheckResult create(RegistrationFinishModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        registrationFinishDAO.insert(obj);
        obj.setId(registrationFinishDAO.getByCode(obj.getCode()).getId());
        if (obj.getId()==null) {
                    res.setIsSuccess(false);
                    res.setMessageTest("ERROR: FBS_REG_FINISH is not inserted.");
                }
        return res;
    }

    public CheckResult delete(RegistrationFinishModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);

        if (obj.getId() == null)
            obj = getByCode(obj.getCode());

        registrationFinishDAO.delete(obj.getId());

        if (registrationFinishDAO.getById(obj.getId()) != null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: FBS_REG_FINISH is not deleted.");
        }

        return res;
    }

    public RegistrationFinishModel getByCode(String code) throws IntegrationException {
        return registrationFinishDAO.getByCode(code);
    }
}

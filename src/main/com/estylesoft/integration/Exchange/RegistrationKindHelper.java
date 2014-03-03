package com.estylesoft.integration.Exchange;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.AdmTerritoryDAO;
import com.estylesoft.integration.Database.mybatis.Ptks.RegistrationKindDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.AdmTerritoryModel;
import com.estylesoft.integration.Model.Ptks.RegistrationKindModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 13:41
 * To change this template use File | Settings | File Templates.
 */
public class RegistrationKindHelper {

    private RegistrationKindDAO registrationKindDAO;

    public RegistrationKindHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.registrationKindDAO=new RegistrationKindDAO(RegistrationKindModel.class, sqlSessionFactory);
    }

    public CheckResult create(RegistrationKindModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        obj.setId(registrationKindDAO.insert(obj));
        if (obj.getId()==null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_REGISTER_KIND is not inserted.");
        }
        return res;
    }

    public void delete(RegistrationKindModel obj) throws IntegrationException {
        registrationKindDAO.delete(obj);
    }
}

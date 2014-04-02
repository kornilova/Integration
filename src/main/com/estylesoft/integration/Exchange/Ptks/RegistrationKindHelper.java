package com.estylesoft.integration.Exchange.Ptks;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.AdmTerritoryDAO;
import com.estylesoft.integration.Database.mybatis.Ptks.RegistrationKindDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.AdmTerritoryModel;
import com.estylesoft.integration.Model.Ptks.RegistrationKindModel;
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
public class RegistrationKindHelper {

    private RegistrationKindDAO registrationKindDAO;

    public RegistrationKindHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.registrationKindDAO=new RegistrationKindDAO(RegistrationKindModel.class, sqlSessionFactory);
    }

    public CheckResult create(RegistrationKindModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        registrationKindDAO.insert(obj);
        obj.setId(getByCode(obj.getCode(), obj.getPerson()).getId());
        if (obj.getId()==null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_REGISTER_KIND is not inserted.");
        }
        return res;
    }

    public CheckResult delete(RegistrationKindModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);

        if (obj.getId() == null)
            obj = getByCode(obj.getCode(), obj.getPerson());

        registrationKindDAO.delete(obj.getId());

        if ( registrationKindDAO.getById(obj.getId()) != null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_REGISTER_KIND is not deleted.");
        }

        return res;
    }


    public RegistrationKindModel getByCode(String code, Integer isPerson) throws IntegrationException {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("code", code);
        params.put("isPerson", isPerson);
        return code!=null?registrationKindDAO.getByCode(params):null;
    }
}

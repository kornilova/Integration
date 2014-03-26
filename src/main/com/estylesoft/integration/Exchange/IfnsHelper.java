package com.estylesoft.integration.Exchange;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.IfnsDAO;
import com.estylesoft.integration.Database.mybatis.Ptks.RegistrationDepartmentDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.IfnsModel;
import com.estylesoft.integration.Model.Ptks.RegistrationDepartmentModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 29.01.14
 * Time: 0:21
 * To change this template use File | Settings | File Templates.
 */
public class IfnsHelper {

    private IfnsDAO ifnsDAO;

    public IfnsHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.ifnsDAO=new IfnsDAO(IfnsModel.class, sqlSessionFactory);
    }

    public CheckResult create(IfnsModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        obj.setId(ifnsDAO.insert(obj));
        if (obj.getId()==null) {
                    res.setIsSuccess(false);
                    res.setMessageTest("ERROR: STH_TERRITORY_DPT_FNS is not inserted.");
                }
        return res;
    }

    public void delete(IfnsModel obj) throws IntegrationException {
        ifnsDAO.delete(obj);
    }

    public IfnsModel getByCode(String code) throws IntegrationException {
        return ifnsDAO.getByCode(code);
    }
}

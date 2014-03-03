package com.estylesoft.integration.Exchange;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.OkatoDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.OkatoModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 13:41
 * To change this template use File | Settings | File Templates.
 */
public class OkatoHelper {

    private OkatoDAO okatoDAO;

    public OkatoHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.okatoDAO=new OkatoDAO(OkatoModel.class, sqlSessionFactory);
    }

    public CheckResult create(OkatoModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        okatoDAO.insert(obj);
        obj.setId(okatoDAO.getByCode(obj.getCode()).getId());
        if (obj.getId()==null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_OKATO is not inserted.");
        }
        return res;
    }

    public void delete(OkatoModel obj) throws IntegrationException {
        okatoDAO.delete(obj);
    }

    public OkatoModel getByCode(String code) throws IntegrationException {
        return okatoDAO.getByCode(code);
    }
}

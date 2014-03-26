package com.estylesoft.integration.Exchange;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.InsurerDAO;
import com.estylesoft.integration.Database.mybatis.Ptks.OkatoDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.InsurerModel;
import com.estylesoft.integration.Model.Ptks.OkatoModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 13:41
 * To change this template use File | Settings | File Templates.
 */
public class InsurerHelper {

    private InsurerDAO insurerDAO;

    public InsurerHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.insurerDAO=new InsurerDAO(InsurerModel.class, sqlSessionFactory);
    }

    public CheckResult create(InsurerModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        insurerDAO.insert(obj);
        if (obj.getInsRegNum()==null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_INSURER is not inserted.");
        }
        return res;
    }

    public void delete(InsurerModel obj) throws IntegrationException {
        insurerDAO.delete(obj);
    }

    public InsurerModel getByCode(String code) throws IntegrationException {
        return insurerDAO.getByCode(code);
    }
}

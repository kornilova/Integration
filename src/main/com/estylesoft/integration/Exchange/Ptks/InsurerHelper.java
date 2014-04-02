package com.estylesoft.integration.Exchange.Ptks;

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
        if (insurerDAO.getById(obj.getInsRegNum())==null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_INSURER is not inserted.");
        }
        return res;
    }

    public CheckResult delete(InsurerModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);

        if (obj.getInsRegNum() == null)
            obj = getByRegNum(obj.getInsRegNum());

        insurerDAO.delete(obj.getInsRegNum());

        if (getByRegNum(obj.getInsRegNum()) != null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_INSURER is not deleted.");
        }

        return res;
    }

    public InsurerModel getByRegNum(Long regNum) throws IntegrationException {
        return insurerDAO.getById(regNum);
    }
}

package com.estylesoft.integration.Exchange.Ptks;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.BaseDepartmentDAO;
import com.estylesoft.integration.Database.mybatis.Ptks.OpfDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.BaseDepartmentModel;
import com.estylesoft.integration.Model.Ptks.OpfModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 29.01.14
 * Time: 0:21
 * To change this template use File | Settings | File Templates.
 */
public class OpfHelper {

    private OpfDAO opfDAO;

    public OpfHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.opfDAO=new OpfDAO(OpfModel.class, sqlSessionFactory);
    }

    public CheckResult create(OpfModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        opfDAO.insert(obj);
        obj.setId(opfDAO.getByCode(obj.getCode()).getId());
        if (obj.getId()==null) {
                    res.setIsSuccess(false);
                    res.setMessageTest("ERROR: STH_OPF is not inserted.");
                }
        return res;
    }

    public CheckResult delete(OpfModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);

        if (obj.getId() == null)
            obj = getByCode(obj.getCode());

        opfDAO.delete(obj.getId());

        if (opfDAO.getById(obj.getId()) != null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_OPF is not deleted.");
        }

        return res;
    }

    public OpfModel getByCode(String code) throws IntegrationException {
        return opfDAO.getByCode(code);
    }
}

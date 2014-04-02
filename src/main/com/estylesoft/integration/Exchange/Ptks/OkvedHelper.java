package com.estylesoft.integration.Exchange.Ptks;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.BaseDepartmentDAO;
import com.estylesoft.integration.Database.mybatis.Ptks.OkvedDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.BaseDepartmentModel;
import com.estylesoft.integration.Model.Ptks.OkvedModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 29.01.14
 * Time: 0:21
 * To change this template use File | Settings | File Templates.
 */
public class OkvedHelper {

    private OkvedDAO okvedDAO;

    public OkvedHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.okvedDAO=new OkvedDAO(OkvedModel.class, sqlSessionFactory);
    }

    public CheckResult create(OkvedModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        okvedDAO.insert(obj);
        obj.setId(okvedDAO.getByCode(obj.getCode()).getId());
        if (obj.getId()==null) {
                    res.setIsSuccess(false);
                    res.setMessageTest("ERROR: STH_OKVED is not inserted.");
                }
        return res;
    }

    public CheckResult delete(OkvedModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);

        if (obj.getId() == null)
            obj = getByCode(obj.getCode());

        okvedDAO.delete(obj.getId());

        if (okvedDAO.getById(obj.getId()) != null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_OKVED is not deleted.");
        }

        return res;
    }

    public OkvedModel getByCode(String code) throws IntegrationException {
        return okvedDAO.getByCode(code);
    }
}

package com.estylesoft.integration.Exchange;

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
        obj.setId(okvedDAO.insert(obj));
        if (obj.getCode()==null) {
                    res.setIsSuccess(false);
                    res.setMessageTest("ERROR: STH_OKVED is not inserted.");
                }
        return res;
    }

    public void delete(OkvedModel obj) throws IntegrationException {
        okvedDAO.delete(obj);
    }
}

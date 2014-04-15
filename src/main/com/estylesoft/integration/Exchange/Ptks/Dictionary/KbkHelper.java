package com.estylesoft.integration.Exchange.Ptks.Dictionary;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.Dictionary.KbkDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.Dictionary.KbkModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 29.01.14
 * Time: 0:21
 * To change this template use File | Settings | File Templates.
 */
public class KbkHelper {

    private KbkDAO kbkDAO;

    public KbkHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.kbkDAO=new KbkDAO(KbkModel.class, sqlSessionFactory);
    }

    public CheckResult create(KbkModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        kbkDAO.insert(obj);
        obj.setId(kbkDAO.getByCode(obj.getCode()).getId());
        if (obj.getId()==null) {
                    res.setIsSuccess(false);
                    res.setMessageTest("ERROR: STH_KBK is not inserted.");
                }
        return res;
    }

    public CheckResult delete(KbkModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);

        if (obj.getId() == null)
            obj = getByCode(obj.getCode());

        kbkDAO.delete(obj.getId());

        if (kbkDAO.getById(obj.getId()) != null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_KBK is not deleted.");
        }

        return res;
    }

    public KbkModel getByCode(String code) throws IntegrationException {
        return kbkDAO.getByCode(code);
    }

    public List<KbkModel> getAll() throws IntegrationException {
        return kbkDAO.getAll();
    }
}

package com.estylesoft.integration.Exchange.Fbs.Dictionary;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Fbs.Dictionary.InsurerTypeDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Fbs.Dictionary.InsurerTypeModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 29.01.14
 * Time: 0:21
 * To change this template use File | Settings | File Templates.
 */
public class InsurerTypeHelper {

    private InsurerTypeDAO insurerTypeDAO;

    public InsurerTypeHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.insurerTypeDAO=new InsurerTypeDAO(InsurerTypeModel.class, sqlSessionFactory);
    }

    public CheckResult create(InsurerTypeModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        insurerTypeDAO.insert(obj);
        obj.setId(getByName(obj.getName()).getId());
        if (obj.getId()==null) {
                    res.setIsSuccess(false);
                    res.setMessageTest("ERROR: FBS_CATEGORY is not inserted.");
                }
        return res;
    }

    public CheckResult delete(InsurerTypeModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);

        if (obj.getId() == null)
            obj = getByName(obj.getName());

        insurerTypeDAO.delete(obj.getId());

        if (insurerTypeDAO.getById(obj.getId()) != null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: FBS_CATEGORY is not deleted.");
        }

        return res;
    }

    public InsurerTypeModel getByName(String code) throws IntegrationException {
        return insurerTypeDAO.getByName(code);
    }
}

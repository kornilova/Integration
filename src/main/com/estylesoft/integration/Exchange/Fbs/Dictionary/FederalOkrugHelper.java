package com.estylesoft.integration.Exchange.Fbs.Dictionary;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Fbs.Dictionary.FederalOkrugDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Fbs.Dictionary.FederalOkrugModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 29.01.14
 * Time: 0:21
 * To change this template use File | Settings | File Templates.
 */
public class FederalOkrugHelper {

    private FederalOkrugDAO federalOkrugDAO;

    public FederalOkrugHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.federalOkrugDAO=new FederalOkrugDAO(FederalOkrugModel.class, sqlSessionFactory);
    }

    public CheckResult create(FederalOkrugModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        federalOkrugDAO.insert(obj);
        obj.setId(federalOkrugDAO.getByCode(obj.getCode()).getId());
        if (obj.getId()==null) {
                    res.setIsSuccess(false);
                    res.setMessageTest("ERROR: FBS_FO is not inserted.");
                }
        return res;
    }

    public CheckResult delete(FederalOkrugModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);

        if (obj.getId() == null)
            obj = getByCode(obj.getCode());

        federalOkrugDAO.delete(obj.getId());

        if (federalOkrugDAO.getById(obj.getId()) != null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: FBS_FO is not deleted.");
        }

        return res;
    }

    public FederalOkrugModel getByCode(String code) throws IntegrationException {
        return federalOkrugDAO.getByCode(code);
    }

    public List<FederalOkrugModel> getAll() throws IntegrationException {
        return federalOkrugDAO.getAll();
    }
}

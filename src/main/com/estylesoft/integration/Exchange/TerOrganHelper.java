package com.estylesoft.integration.Exchange;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.TerOrganDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.TerOrganModel;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 31.01.14
 * Time: 18:01
 * To change this template use File | Settings | File Templates.
 */
public class TerOrganHelper {

    private TerOrganDAO terOrganDAO;

    public TerOrganHelper(TerOrganDAO terOrganDAO)
    {
        this.terOrganDAO=terOrganDAO;
    }

    public CheckResult create(TerOrganModel obj
    ) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        if (terOrganDAO.insert(obj)==null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_TERRITORIAL_ORGAN is not inserted.");
        }
        return res;
    }
}

package com.estylesoft.integration.Exchange;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.AdmTerritoryDAO;
import com.estylesoft.integration.Database.mybatis.Ptks.StreetDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.AdmTerritoryModel;
import com.estylesoft.integration.Model.Ptks.StreetModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 13:41
 * To change this template use File | Settings | File Templates.
 */
public class StreetHelper {

    private StreetDAO streetDAO;

    public StreetHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.streetDAO=new StreetDAO(StreetModel.class, sqlSessionFactory);
    }

    public CheckResult create(StreetModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        obj.setId(streetDAO.insert(obj));
        if (obj.getId()==null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_STREET is not inserted.");
        }
        return res;
    }

    public void delete(StreetModel obj) throws IntegrationException {
        streetDAO.delete(obj);
    }

    public StreetModel getByCode(String code) throws IntegrationException {
        return streetDAO.getByCode(code);
    }
}

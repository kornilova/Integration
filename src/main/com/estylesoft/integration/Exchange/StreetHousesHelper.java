package com.estylesoft.integration.Exchange;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.StreetDepartmentDAO;
import com.estylesoft.integration.Database.mybatis.Ptks.StreetHousesDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.StreetDepartmentModel;
import com.estylesoft.integration.Model.Ptks.StreetHousesModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 13:41
 * To change this template use File | Settings | File Templates.
 */
public class StreetHousesHelper {

    private StreetHousesDAO streetHousesDAO;

    public StreetHousesHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.streetHousesDAO=new StreetHousesDAO(StreetHousesModel.class, sqlSessionFactory);
    }

    public CheckResult create(StreetHousesModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        obj.setId(streetHousesDAO.insert(obj));
        if (obj.getId()==null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_STREET_HOUSES is not inserted.");
        }
        return res;
    }

    public void delete(StreetHousesModel obj) throws IntegrationException {
        streetHousesDAO.delete(obj);
    }
}

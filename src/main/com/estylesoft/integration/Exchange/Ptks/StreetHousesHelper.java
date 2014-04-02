package com.estylesoft.integration.Exchange.Ptks;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.StreetDepartmentDAO;
import com.estylesoft.integration.Database.mybatis.Ptks.StreetHousesDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.StreetDepartmentModel;
import com.estylesoft.integration.Model.Ptks.StreetHousesModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.Map;

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

    public CheckResult delete(StreetHousesModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);

        if (obj.getId() == null)
            obj = getByHousesIdStreetDepId(
                    obj.getStreetDepartmentId(), obj.getHouses()
            );

        streetHousesDAO.delete(obj.getId());

        if ( streetHousesDAO.getById(obj.getId()) != null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_STREET_HOUSES is not deleted.");
        }

        return res;
    }

    public StreetHousesModel getByHousesIdStreetDepId( Long streetDepartmentId,
                                                       String houses) throws IntegrationException {
        Map<String, Object> params = new HashMap<String, Object>(2);
        params.put("streetDepartmentId", streetDepartmentId);
        params.put("houses", houses);

        return streetHousesDAO.getByHousesIdStreetDepId(params);
    }
}

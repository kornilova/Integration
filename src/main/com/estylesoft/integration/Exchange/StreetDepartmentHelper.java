package com.estylesoft.integration.Exchange;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.CityDAO;
import com.estylesoft.integration.Database.mybatis.Ptks.StreetDepartmentDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.CityModel;
import com.estylesoft.integration.Model.Ptks.StreetDepartmentModel;
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
public class StreetDepartmentHelper {

    private StreetDepartmentDAO streetDepartmentDAO;

    public StreetDepartmentHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.streetDepartmentDAO=new StreetDepartmentDAO(StreetDepartmentModel.class, sqlSessionFactory);
    }

    public CheckResult create(StreetDepartmentModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        obj.setId(streetDepartmentDAO.insert(obj));
        if (obj.getId()==null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_STREET_TDP is not inserted.");
        }
        return res;
    }

    public void delete(StreetDepartmentModel obj) throws IntegrationException {
        streetDepartmentDAO.delete(obj);
    }

    public StreetDepartmentModel getByStreetIdTerDepId(Long streetId, Long terDepartmentPFRId)
    {
        Map<String, Long> params = new HashMap<String, Long>(2);
        params.put("streetId", streetId);
        params.put("terDepartmentPFRId", terDepartmentPFRId);
      return   streetDepartmentDAO.getByStreetIdTerDepId(params);

    }
}

package com.estylesoft.integration.Exchange;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.CityDAO;
import com.estylesoft.integration.Database.mybatis.Ptks.TownDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.CityModel;
import com.estylesoft.integration.Model.Ptks.TownModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 13:41
 * To change this template use File | Settings | File Templates.
 */
public class TownHelper {

    private TownDAO townDAO;

    public TownHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.townDAO=new TownDAO(TownModel.class, sqlSessionFactory);
    }

    public CheckResult create(TownModel obj) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        obj.setId(townDAO.insert(obj));
        if (obj.getId()==null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_TOWN is not inserted.");
        }
        return res;
    }

    public void delete(TownModel obj) throws IntegrationException {
        townDAO.delete(obj);
    }

    public TownModel getByCode(String code) throws IntegrationException {
        return townDAO.getByCode(code);
    }
}

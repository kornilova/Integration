package com.estylesoft.integration.Exchange.Ptks;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.BaseDepartmentDAO;
import com.estylesoft.integration.Database.mybatis.Ptks.OpfrDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.BaseDepartmentModel;
import com.estylesoft.integration.Model.Ptks.OpfrModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 29.01.14
 * Time: 0:21
 * To change this template use File | Settings | File Templates.
 */
public class OpfrHelper {

    private OpfrDAO opfrDAO;

    public OpfrHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.opfrDAO=new OpfrDAO(OpfrModel.class, sqlSessionFactory);
    }

    public OpfrModel getByCode(String code) throws IntegrationException {
        return opfrDAO.getByCode(code);
    }

    public OpfrModel getPfrCurrent()
    {
        Map<String, Object> params = new HashMap<String, Object>(1);
        params.put("isCurrent", 1);
        return opfrDAO.getPfrCurrent(params);
    }

    public List<OpfrModel> getAll()
    {
        return opfrDAO.getAll();
    }
}

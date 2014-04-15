package com.estylesoft.integration.Exchange.Fbs;

import com.estylesoft.integration.Database.mybatis.Fbs.OpfrDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Fbs.OpfrModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;


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

    public List<OpfrModel> getAll()
    {
        return opfrDAO.getAll();
    }
}

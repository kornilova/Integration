package com.estylesoft.integration.Exchange.Fbs;


import com.estylesoft.integration.Database.mybatis.Fbs.TerOrganDAO;
import com.estylesoft.integration.Model.Fbs.TerOrganModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 29.01.14
 * Time: 0:21
 * To change this template use File | Settings | File Templates.
 */
public class TerOrganHelper {

    private TerOrganDAO terOrganDAO;

    public TerOrganHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.terOrganDAO=new TerOrganDAO(TerOrganModel.class, sqlSessionFactory);
    }

    public List<TerOrganModel> getAll()
    {
        return terOrganDAO.getAll();
    }
}

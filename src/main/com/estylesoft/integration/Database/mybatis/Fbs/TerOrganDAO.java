package com.estylesoft.integration.Database.mybatis.Fbs;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Fbs.TerOrganModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 28.01.14
 * Time: 23:43
 * To change this template use File | Settings | File Templates.
 */
public class TerOrganDAO extends DAOBase<TerOrganModel>{

    private final String namespace = "fbs.terOrgan";

    public TerOrganDAO(Class<TerOrganModel> type, SqlSessionFactory containerSessionFactory) {
        super(type,containerSessionFactory);
    }

    public List<TerOrganModel> getAll()
    {
        return super.getAll(namespace + "." + "getAll");
    }
}

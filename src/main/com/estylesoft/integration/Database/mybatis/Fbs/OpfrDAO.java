package com.estylesoft.integration.Database.mybatis.Fbs;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Fbs.OpfrModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 14:14
 * To change this template use File | Settings | File Templates.
 */
public class OpfrDAO extends DAOBase<OpfrModel> {

    private final String namespace = "fbs.opfr";

    public OpfrDAO(Class<OpfrModel> type, SqlSessionFactory containerSessionFactory) {
        super(type, containerSessionFactory);
    }

    public OpfrModel getByCode(String code)
    {
        return super.getByCode(namespace + "." + "getByCode", code);
    }

    public List<OpfrModel> getAll()
    {
        return super.getAll(namespace + "." + "getAll");
    }
}

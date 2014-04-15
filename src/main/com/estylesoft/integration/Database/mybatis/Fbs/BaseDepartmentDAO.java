package com.estylesoft.integration.Database.mybatis.Fbs;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Fbs.BaseDepartmentModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 28.01.14
 * Time: 23:43
 * To change this template use File | Settings | File Templates.
 */
public class BaseDepartmentDAO extends DAOBase<BaseDepartmentModel>{

    private final String namespace = "fbs.baseDepartment";

    public BaseDepartmentDAO(Class<BaseDepartmentModel> type, SqlSessionFactory containerSessionFactory) {
        super(type,containerSessionFactory);
    }

    public List<BaseDepartmentModel> getAll()
    {
        return super.getAll(namespace + "." + "getAll");
    }
}

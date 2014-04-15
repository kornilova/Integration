package com.estylesoft.integration.Database.mybatis.Ptks;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Ptks.BaseDepartmentModel;
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

    private final String namespace = "ptksBaseDepartment";

    public BaseDepartmentDAO(Class<BaseDepartmentModel> type,SqlSessionFactory containerSessionFactory) {
        super(type,containerSessionFactory);
    }

     public Long insert(BaseDepartmentModel obj)
     {
        return super.create(namespace + "." + "insert", obj).getId();
     }

    public void delete(Long id)
    {
        super.delete(namespace + "." + "delete", id);
    }

    public BaseDepartmentModel getByCodeOpfr(Map params)
    {
        return super.getByMap(namespace + "." + "getByCodeOpfr", params);
    }

    public BaseDepartmentModel getById(Long id)
    {
        return super.getById(namespace + "." + "getById", id);
    }

    public List<BaseDepartmentModel> getAll()
    {
        return super.getAll(namespace + "." + "getAll");
    }
}

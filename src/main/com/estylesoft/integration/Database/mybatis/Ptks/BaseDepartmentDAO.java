package com.estylesoft.integration.Database.mybatis.Ptks;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Ptks.BaseDepartmentModel;
import org.apache.ibatis.session.SqlSessionFactory;

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

    public void delete(BaseDepartmentModel obj)
    {
        super.delete(namespace + "." + "delete", obj.getId());
    }

    public BaseDepartmentModel getByCode(String code)
    {
        return super.getByCode(namespace + "." + "getByCode", code);
    }
}

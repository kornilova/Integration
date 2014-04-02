package com.estylesoft.integration.Database.mybatis.Ptks;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Ptks.StreetDepartmentModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 17:00
 * To change this template use File | Settings | File Templates.
 */
public class StreetDepartmentDAO extends DAOBase<StreetDepartmentModel> {

    private final String namespace = "streetDepartment";

    public StreetDepartmentDAO(Class<StreetDepartmentModel> type, SqlSessionFactory containerSessionFactory) {
        super(type,containerSessionFactory);
    }

    public Long insert(StreetDepartmentModel obj)
    {
        return super.create(namespace + "." + "insert", obj).getId();
    }

    public void delete(Long id)
    {
        super.delete(namespace + "." + "delete", id);
    }

    public StreetDepartmentModel getByStreetIdTerDepId(Map params)
    {
        return super.getByMap(namespace + "." + "getByStreetIdTerDepId", params);
    }

    public StreetDepartmentModel getById(Long id)
    {
        return super.getById(namespace + "." + "getById", id);
    }
}
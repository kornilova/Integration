package com.estylesoft.integration.Database.mybatis.Ptks;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Ptks.StreetHousesModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 17:00
 * To change this template use File | Settings | File Templates.
 */
public class StreetHousesDAO extends DAOBase<StreetHousesModel> {

    private final String namespace = "streetHouses";

    public StreetHousesDAO(Class<StreetHousesModel> type, SqlSessionFactory containerSessionFactory) {
        super(type,containerSessionFactory);
    }

    public Long insert(StreetHousesModel obj)
    {
        return super.create(namespace + "." + "insert", obj).getId();
    }

    public void delete(StreetHousesModel obj)
    {
        super.delete(namespace + "." + "delete", obj.getStreetDepartment().getId());
    }
}
package com.estylesoft.integration.Database.mybatis.Ptks;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Ptks.AdmTerritoryModel;
import com.estylesoft.integration.Model.Ptks.RegistrationKindModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 17:00
 * To change this template use File | Settings | File Templates.
 */
public class RegistrationKindDAO extends DAOBase<RegistrationKindModel> {

    private final String namespace = "registrationKind";

    public RegistrationKindDAO(Class<RegistrationKindModel> type, SqlSessionFactory containerSessionFactory) {
        super(type,containerSessionFactory);
    }

    public void insert(RegistrationKindModel obj)
    {
        super.create(namespace + "." + "insert", obj);
    }

    public void delete(Long id)
    {
        super.delete(namespace + "." + "delete", id);
    }

    public RegistrationKindModel getByCode(Map params)
    {
        return super.getByMap(namespace + "." + "getByCode", params);
    }

    public RegistrationKindModel getById(Long id)
    {
        return super.getById(namespace + "." + "getById", id);
    }
}
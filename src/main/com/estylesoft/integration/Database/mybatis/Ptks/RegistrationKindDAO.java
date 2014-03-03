package com.estylesoft.integration.Database.mybatis.Ptks;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Ptks.AdmTerritoryModel;
import com.estylesoft.integration.Model.Ptks.RegistrationKindModel;
import org.apache.ibatis.session.SqlSessionFactory;

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

    public Long insert(RegistrationKindModel obj)
    {
        return super.create(namespace + "." + "insert", obj).getId();
    }

    public void delete(RegistrationKindModel obj)
    {
        super.delete(namespace + "." + "delete", obj.getCode());
    }
}
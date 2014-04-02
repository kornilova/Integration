package com.estylesoft.integration.Database.mybatis.Fbs.Dictionary;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Fbs.Dictionary.RegistrationStartModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 14:14
 * To change this template use File | Settings | File Templates.
 */
public class RegistrationStartDAO extends DAOBase<RegistrationStartModel> {

    private final String namespace = "registrationStart";

    public RegistrationStartDAO(Class<RegistrationStartModel> type, SqlSessionFactory containerSessionFactory) {
        super(type, containerSessionFactory);
    }

    public Long insert(RegistrationStartModel obj) {
        return super.create(namespace + "." + "insert", obj).getId();
    }

    public void delete(Long id) {
        super.delete(namespace + "." + "delete", id);
    }

    public RegistrationStartModel getByCode(String code)
    {
        return super.getByCode(namespace + "." + "getByCode", code);
    }

    public RegistrationStartModel getById(Long id)
    {
        return super.getById(namespace + "." + "getById", id);
    }
}

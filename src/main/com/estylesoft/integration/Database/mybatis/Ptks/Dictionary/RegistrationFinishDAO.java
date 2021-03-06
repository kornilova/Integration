package com.estylesoft.integration.Database.mybatis.Ptks.Dictionary;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Ptks.Dictionary.RegistrationFinishModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 14:14
 * To change this template use File | Settings | File Templates.
 */
public class RegistrationFinishDAO extends DAOBase<RegistrationFinishModel> {

    private final String namespace = "ptks.registrationFinish";

    public RegistrationFinishDAO(Class<RegistrationFinishModel> type, SqlSessionFactory containerSessionFactory) {
        super(type, containerSessionFactory);
    }

    public Long insert(RegistrationFinishModel obj) {
        return super.create(namespace + "." + "insert", obj).getId();
    }

    public void delete(Long id) {
        super.delete(namespace + "." + "delete", id);
    }

    public RegistrationFinishModel getByCode(String code)
    {
        return super.getByCode(namespace + "." + "getByCode", code);
    }

    public RegistrationFinishModel getById(Long id)
    {
        return super.getById(namespace + "." + "getById", id);
    }

    public List<RegistrationFinishModel> getAll()
    {
        return super.getAll(namespace + "." + "getAll");
    }
}

package com.estylesoft.integration.Database.mybatis.Ptks;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Ptks.IfnsModel;
import com.estylesoft.integration.Model.Ptks.RegistrationDepartmentModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 13:38
 * To change this template use File | Settings | File Templates.
 */
public class IfnsDAO extends DAOBase<IfnsModel> {

    private final String namespace = "ifns";

    public IfnsDAO(Class<IfnsModel> type, SqlSessionFactory containerSessionFactory) {
        super(type,containerSessionFactory);
    }

    public Long insert(IfnsModel obj)
    {
        return super.create(namespace + "." + "insert", obj).getId();
    }

    public void delete(Long id)
    {
        super.delete(namespace + "." + "delete", id);
    }

    public IfnsModel getByCode(String code)
    {
        return super.getByCode(namespace + "." + "getByCode", code);
    }

    public IfnsModel getById(Long id)
    {
        return super.getById(namespace + "." + "getById", id);
    }
}

package com.estylesoft.integration.Database.mybatis.Ptks;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Ptks.RegionModel;
import com.estylesoft.integration.Model.Ptks.RegistrationDepartmentModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 13:38
 * To change this template use File | Settings | File Templates.
 */
public class RegistrationDepartmentDAO extends DAOBase<RegistrationDepartmentModel> {

    private final String namespace = "registrationDepartment";

    public RegistrationDepartmentDAO(Class<RegistrationDepartmentModel> type, SqlSessionFactory containerSessionFactory) {
        super(type,containerSessionFactory);
    }

    public Long insert(RegistrationDepartmentModel obj)
    {
        return super.create(namespace + "." + "insert", obj).getId();
    }

    public void delete(RegistrationDepartmentModel obj)
    {
        super.delete(namespace + "." + "delete", obj.getId());
    }
}

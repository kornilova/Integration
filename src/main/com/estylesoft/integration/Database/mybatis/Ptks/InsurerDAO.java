package com.estylesoft.integration.Database.mybatis.Ptks;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Ptks.InsurerModel;
import com.estylesoft.integration.Model.Ptks.OpfModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 14:14
 * To change this template use File | Settings | File Templates.
 */
public class InsurerDAO extends DAOBase<InsurerModel> {

    private final String namespace = "insurer";

    public InsurerDAO(Class<InsurerModel> type, SqlSessionFactory containerSessionFactory) {
        super(type, containerSessionFactory);
    }

    public void insert(InsurerModel obj) {
        super.create(namespace + "." + "insert", obj);
    }

    public void delete(InsurerModel obj) {
        super.delete(namespace + "." + "delete", obj.getId());
    }

    public InsurerModel getByCode(String regNum)
    {
        return super.getByCode(namespace + "." + "getByCode", regNum);
    }
}

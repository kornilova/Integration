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

    public void delete(Long id) {
        super.delete(namespace + "." + "delete", id);
    }

    public InsurerModel getById(Long regNum)
    {
        return super.getById(namespace + "." + "getByRegNum", regNum);
    }
}

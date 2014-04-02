package com.estylesoft.integration.Database.mybatis.Ptks;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Ptks.OkatoModel;
import com.estylesoft.integration.Model.Ptks.OpfModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 14:14
 * To change this template use File | Settings | File Templates.
 */
public class OpfDAO extends DAOBase<OpfModel> {

    private final String namespace = "opf";

    public OpfDAO(Class<OpfModel> type, SqlSessionFactory containerSessionFactory) {
        super(type, containerSessionFactory);
    }

    public Long insert(OpfModel obj) {
        return super.create(namespace + "." + "insert", obj).getId();
    }

    public void delete(Long id) {
        super.delete(namespace + "." + "delete", id);
    }

    public OpfModel getByCode(String code)
    {
        return super.getByCode(namespace + "." + "getByCode", code);
    }

    public OpfModel getById(Long id)
    {
        return super.getById(namespace + "." + "getById", id);
    }
}

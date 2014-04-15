package com.estylesoft.integration.Database.mybatis.Fbs.Dictionary;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Fbs.Dictionary.InsurerTypeModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 14:14
 * To change this template use File | Settings | File Templates.
 */
public class InsurerTypeDAO extends DAOBase<InsurerTypeModel> {

    private final String namespace = "fbs.insurerType";

    public InsurerTypeDAO(Class<InsurerTypeModel> type, SqlSessionFactory containerSessionFactory) {
        super(type, containerSessionFactory);
    }

    public Long insert(InsurerTypeModel obj) {
        return super.create(namespace + "." + "insert", obj).getId();
    }

    public void delete(Long id) {
        super.delete(namespace + "." + "delete", id);
    }

    public InsurerTypeModel getByName(String code)
    {
        return super.getByCode(namespace + "." + "getByName", code);
    }

    public InsurerTypeModel getById(Long id)
    {
        return super.getById(namespace + "." + "getById", id);
    }

    public List<InsurerTypeModel> getAll()
    {
        return super.getAll(namespace + "." + "getAll");
    }
}

package com.estylesoft.integration.Database.mybatis.Ptks.Dictionary;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Ptks.Dictionary.CategoryModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 14:14
 * To change this template use File | Settings | File Templates.
 */
public class CategoryDAO extends DAOBase<CategoryModel> {

    private final String namespace = "ptks.category";

    public CategoryDAO(Class<CategoryModel> type, SqlSessionFactory containerSessionFactory) {
        super(type, containerSessionFactory);
    }

    public Long insert(CategoryModel obj) {
        return super.create(namespace + "." + "insert", obj).getId();
    }

    public void delete(Long id) {
        super.delete(namespace + "." + "delete", id);
    }

    public CategoryModel getByCode(String code)
    {
        return super.getByCode(namespace + "." + "getByCode", code);
    }

    public CategoryModel getById(Long id)
    {
        return super.getById(namespace + "." + "getById", id);
    }

    public List<CategoryModel> getAll()
    {
        return super.getAll(namespace + "." + "getAll");
    }
}

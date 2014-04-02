package com.estylesoft.integration.Database.mybatis.Fbs.Dictionary;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Fbs.Dictionary.FederalOkrugModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 14:14
 * To change this template use File | Settings | File Templates.
 */
public class FederalOkrugDAO extends DAOBase<FederalOkrugModel> {

    private final String namespace = "fbs.federalOkrug";

    public FederalOkrugDAO(Class<FederalOkrugModel> type, SqlSessionFactory containerSessionFactory) {
        super(type, containerSessionFactory);
    }

    public Long insert(FederalOkrugModel obj) {
        return super.create(namespace + "." + "insert", obj).getId();
    }

    public void delete(Long id) {
        super.delete(namespace + "." + "delete", id);
    }

    public FederalOkrugModel getByCode(String code)
    {
        return super.getByCode(namespace + "." + "getByCode", code);
    }

    public FederalOkrugModel getById(Long id)
    {
        return super.getById(namespace + "." + "getById", id);
    }

    public List<FederalOkrugModel> getAll()
    {
        return super.getAll(namespace + "." + "getAll");
    }
}

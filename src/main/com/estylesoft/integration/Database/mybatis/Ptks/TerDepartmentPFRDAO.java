package com.estylesoft.integration.Database.mybatis.Ptks;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Ptks.TerDepartmentPFRModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 10:52
 * To change this template use File | Settings | File Templates.
 */
public class TerDepartmentPFRDAO extends DAOBase<TerDepartmentPFRModel>  {

    private final String namespace = "ptksTerDepartmentPFR";

    public TerDepartmentPFRDAO(Class<TerDepartmentPFRModel> type,SqlSessionFactory containerSessionFactory) {
        super(type,containerSessionFactory);
    }

    public Long insert(TerDepartmentPFRModel obj)
    {
        return super.create(namespace + "." + "insert", obj).getId();
    }

    public void delete(TerDepartmentPFRModel obj)
    {
        super.delete(namespace + "." + "delete", obj);
    }

    public TerDepartmentPFRModel getByCode(String code)
    {
      return super.getByCode(namespace + "." + "getByCode", code);
    }

    public TerDepartmentPFRModel getByCodeBaseDepTerOrgan(Map params)
    {
        return super.getByMap(namespace + "." + "getByCodeBaseDepTerOrgan", params);
    }
}

package com.estylesoft.integration.Database.mybatis.Ptks;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Ptks.OkatoModel;
import com.estylesoft.integration.Model.Ptks.RegionModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 13:38
 * To change this template use File | Settings | File Templates.
 */
public class RegionDAO extends DAOBase<RegionModel> {

    private final String namespace = "region";

    public RegionDAO(Class<RegionModel> type, SqlSessionFactory containerSessionFactory) {
        super(type,containerSessionFactory);
    }

    public Long insert(RegionModel obj)
    {
        return super.create(namespace + "." + "insert", obj).getId();
    }

    public void delete(RegionModel obj)
    {
        super.delete(namespace + "." + "delete", obj.getCode());
    }

    public RegionModel getByCode(String code)
    {
        return super.getByCode(namespace + "." + "getByCode", code);
    }
}

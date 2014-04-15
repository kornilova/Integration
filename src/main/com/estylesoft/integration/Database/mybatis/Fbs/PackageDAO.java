package com.estylesoft.integration.Database.mybatis.Fbs;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Fbs.PackageModel;
import com.estylesoft.integration.Model.Fbs.ProtocolModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 14:14
 * To change this template use File | Settings | File Templates.
 */
public class PackageDAO extends DAOBase<PackageModel> {

    private final String namespace = "fbs.package";

    public PackageDAO(Class<PackageModel> type, SqlSessionFactory containerSessionFactory) {
        super(type, containerSessionFactory);
    }


    public PackageModel getMaxNumberByOpfrId(Long opfrId)
    {
        return super.getById(namespace + "." + "getMaxNumberByOpfrId", opfrId);
    }

    public PackageModel getMaxNumberLikeOpfrCode(String code)
    {
        return super.getByCode(namespace + "." + "getMaxNumberByName", code);
    }
}

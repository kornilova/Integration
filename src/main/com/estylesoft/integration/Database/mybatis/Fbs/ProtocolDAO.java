package com.estylesoft.integration.Database.mybatis.Fbs;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Fbs.OpfrModel;
import com.estylesoft.integration.Model.Fbs.ProtocolModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 14:14
 * To change this template use File | Settings | File Templates.
 */
public class ProtocolDAO extends DAOBase<ProtocolModel> {

    private final String namespace = "fbs.protocol";

    public ProtocolDAO(Class<ProtocolModel> type, SqlSessionFactory containerSessionFactory) {
        super(type, containerSessionFactory);
    }


    public ProtocolModel getByPackageIdRecordId(Map params)
    {
        return super.getByMap(namespace + "." + "getByPackageIdRecordId", params);
    }

}

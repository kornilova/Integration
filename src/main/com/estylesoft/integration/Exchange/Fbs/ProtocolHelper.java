package com.estylesoft.integration.Exchange.Fbs;

import com.estylesoft.integration.Database.mybatis.Fbs.OpfrDAO;
import com.estylesoft.integration.Database.mybatis.Fbs.ProtocolDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Fbs.OpfrModel;
import com.estylesoft.integration.Model.Fbs.ProtocolModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 29.01.14
 * Time: 0:21
 * To change this template use File | Settings | File Templates.
 */
public class ProtocolHelper {

    private ProtocolDAO protocolDAO;

    public ProtocolHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.protocolDAO=new ProtocolDAO(ProtocolModel.class, sqlSessionFactory);
    }

    public ProtocolModel getByPackageIdRecordId(Long packageId, String recordId)
    {
        Map<String, Object> params = new HashMap<String, Object>(2);
        params.put("packageId", packageId);
        params.put("recordId", recordId);
        return protocolDAO.getByPackageIdRecordId(params);
    }
}

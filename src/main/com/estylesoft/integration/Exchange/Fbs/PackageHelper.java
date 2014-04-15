package com.estylesoft.integration.Exchange.Fbs;

import com.estylesoft.integration.Database.mybatis.Fbs.PackageDAO;
import com.estylesoft.integration.Database.mybatis.Fbs.ProtocolDAO;
import com.estylesoft.integration.Model.Fbs.PackageModel;
import com.estylesoft.integration.Model.Fbs.ProtocolModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 29.01.14
 * Time: 0:21
 * To change this template use File | Settings | File Templates.
 */
public class PackageHelper {

    private PackageDAO packageDAO;

    public PackageHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.packageDAO=new PackageDAO(PackageModel.class, sqlSessionFactory);
    }

    public PackageModel getMaxNumberByOpfrId(Long opfrId)
    {
         return packageDAO.getMaxNumberByOpfrId(opfrId);
    }

    public PackageModel getMaxNumberLikeOpfrCode(String code)
    {
        code = code + '%';
        return packageDAO.getMaxNumberLikeOpfrCode(code);
    }
}

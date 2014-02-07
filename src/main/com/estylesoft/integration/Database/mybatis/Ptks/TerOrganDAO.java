package com.estylesoft.integration.Database.mybatis.Ptks;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Ptks.TerOrganModel;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 31.01.14
 * Time: 18:02
 * To change this template use File | Settings | File Templates.
 */
public class TerOrganDAO extends DAOBase<TerOrganModel, Long> {

    private final String namespace = "terOrgan";

    public TerOrganDAO(Class<TerOrganModel> type, SqlSessionFactory containerSessionFactory) {
        super(type, containerSessionFactory);
    }

    public Long insert(TerOrganModel obj) {
        return super.create(namespace + "." + "insert", obj).getId();
    }
}

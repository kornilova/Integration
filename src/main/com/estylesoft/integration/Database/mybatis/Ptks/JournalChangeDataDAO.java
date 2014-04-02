package com.estylesoft.integration.Database.mybatis.Ptks;

import com.estylesoft.integration.Database.mybatis.DAOBase;
import com.estylesoft.integration.Model.Ptks.JournalChangeDataModel;
import com.estylesoft.integration.Model.Ptks.OpfrModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 14:14
 * To change this template use File | Settings | File Templates.
 */
public class JournalChangeDataDAO extends DAOBase<JournalChangeDataModel> {

    private final String namespace = "journalChangeData";

    public JournalChangeDataDAO(Class<JournalChangeDataModel> type, SqlSessionFactory containerSessionFactory) {
        super(type, containerSessionFactory);
    }

    public JournalChangeDataModel getByObjectIdDictTypeId(Map params)
    {
        return super.getByMap(namespace + "." + "getByObjectIdDictTypeId", params);
    }
}

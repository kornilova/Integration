package com.estylesoft.integration.Exchange.Ptks;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.JournalChangeDataDAO;
import com.estylesoft.integration.Database.mybatis.Ptks.OpfrDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.JournalChangeDataModel;
import com.estylesoft.integration.Model.Ptks.OpfrModel;
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
public class JournalChangeDataHelper {

    private JournalChangeDataDAO journalChangeDataDAO;

    public JournalChangeDataHelper(SqlSessionFactory sqlSessionFactory)
    {
        this.journalChangeDataDAO=new JournalChangeDataDAO(JournalChangeDataModel.class, sqlSessionFactory);
    }

    public JournalChangeDataModel getByObjectIdDictTypeId(Long objectId,
                                                          Integer dictionaryTypeId,
                                                          Integer operType)
            throws IntegrationException {
        Map<String, Object> params = new HashMap<String, Object>(3);
        params.put("objectId", objectId);
        params.put("dictionaryTypeId", dictionaryTypeId);
        params.put("operType", operType);
        return journalChangeDataDAO.getByObjectIdDictTypeId(params);
    }

    public CheckResult checkExistChangeData(Long objectId,
                                            Integer dictionaryTypeId,
                                            Integer operType) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        if (getByObjectIdDictTypeId(objectId, dictionaryTypeId,operType) == null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_JOURNAL_CHANGE_DATA is not inserted.");
        }
        return res;
    }

    public CheckResult checkNotExistChangeData(Long objectId,
                                               Integer dictionaryTypeId,
                                               Integer operType) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        if (getByObjectIdDictTypeId(objectId, dictionaryTypeId, operType) != null) {
            res.setIsSuccess(false);
            res.setMessageTest("ERROR: STH_JOURNAL_CHANGE_DATA is inserted in error.");
        }
        return res;
    }
}

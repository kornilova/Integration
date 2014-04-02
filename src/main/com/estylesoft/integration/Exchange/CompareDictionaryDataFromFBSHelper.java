package com.estylesoft.integration.Exchange;

import com.estylesoft.integration.CheckResult;

import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Fbs.Dictionary.FederalOkrugModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

import static com.estylesoft.integration.Util.Util.deleteZeroInCode;


/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 30.10.13
 * Time: 13:17
 * To change this template use File | Settings | File Templates.
 */
//Сравниваем актуализацию справочников
public class CompareDictionaryDataFromFBSHelper {

    private com.estylesoft.integration.Exchange.Fbs.Dictionary.FederalOkrugHelper federalOkrugHelperFbs;
    private com.estylesoft.integration.Exchange.Ptks.Dictionary.FederalOkrugHelper federalOkrugHelperPtks;

    public CompareDictionaryDataFromFBSHelper(SqlSessionFactory sessionPtks,
                                              SqlSessionFactory sessionFbs) {
        federalOkrugHelperFbs = new com.estylesoft.integration.Exchange.Fbs.Dictionary.FederalOkrugHelper(sessionFbs);
        federalOkrugHelperPtks = new com.estylesoft.integration.Exchange.Ptks.Dictionary.FederalOkrugHelper(sessionPtks);
    }

    public CheckResult compareActualFederalOkrug() throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        boolean isContains;
        List<com.estylesoft.integration.Model.Ptks.Dictionary.FederalOkrugModel> lPtks = federalOkrugHelperPtks.getAll();
        for (com.estylesoft.integration.Model.Fbs.Dictionary.FederalOkrugModel fbs : federalOkrugHelperFbs.getAll()) {
            isContains = false;
            for (com.estylesoft.integration.Model.Ptks.Dictionary.FederalOkrugModel ptks : lPtks) {
                if (deleteZeroInCode(fbs.getCode()).equals(ptks.getCode())) {
                    isContains = true;
                    if (String.CASE_INSENSITIVE_ORDER.compare(fbs.getName(), ptks.getName())>0
                          ||  ptks.getActualFbs() == null || ptks.getActualFbs() == 0
                            ) {
                        res.setIsSuccess(false);
                        res.setMessageTest("ERROR: FBS_FO -> STH_FED_OKRUG is not actual or different in PTKS database.Fbs code = " + fbs.getCode());
                        return res;
                    }
                    break;
                }
            }
            if (!isContains) {
                res.setIsSuccess(false);
                res.setMessageTest("ERROR: FBS_FO -> STH_FED_OKRUG is not contains in PTKS database.Fbs code = " + fbs.getCode());
                break;
            }

        }
        return res;
    }
}

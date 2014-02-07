package com.estylesoft.integration.Exchange;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.Column;
import com.estylesoft.integration.Database.Table;
import com.estylesoft.integration.Database.mybatis.DictionaryFbsDAO;
import com.estylesoft.integration.Database.mybatis.DictionaryPtksDAO;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.TbFbsModelBase;
import com.estylesoft.integration.Model.TbPtksModelBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 30.10.13
 * Time: 13:17
 * To change this template use File | Settings | File Templates.
 */
//Сравниваем актуализацию справочников
public class CompareDictionaryDataFromFBS {

    public CheckResult compareActualKbk() throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        for (TbFbsModelBase dictFbs : (new DictionaryFbsDAO()).getCodeKbk()) {
            for (TbPtksModelBase dictPtks : (new DictionaryPtksDAO()).getCodeFbsIsActualKbk()) {
                if (dictFbs.getCode().equals(dictPtks.getCode()) && dictPtks.getFbsActual() != 1) {
                    res.setIsSuccess(false);
                    res.setMessageTest("ERROR: Dictionary KBK is not actual in Ptks database.");
                    break;
                }
            }
        }
        return res;
    }

    public CheckResult compareActualInsurerType() throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        for (TbFbsModelBase dictFbs : (new DictionaryFbsDAO()).getNameInsurerType()) {
            for (TbPtksModelBase dictPtks : (new DictionaryPtksDAO().getNameFbsIsActualInsurerType())) {
                if (dictFbs.getName().equals(dictPtks.getName()) && dictPtks.getFbsActual() != 1) {
                    res.setIsSuccess(false);
                    res.setMessageTest("ERROR: Dictionary KBK is not actual in Ptks database.");
                    break;
                }
            }
        }
        return res;
    }

    private String deleteZeroInCode(String value)
    {
       return  (value.length() == 2 && value.matches("[0]{1}[\\d]{1}"))? value.substring(1, value.length()):value;
    }

}

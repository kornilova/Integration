package com.estylesoft.integration.Exchange;

import com.estylesoft.integration.CheckResult;

import com.estylesoft.integration.IntegrationException;
import org.apache.ibatis.session.SqlSessionFactory;
import org.testng.util.Strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
    private com.estylesoft.integration.Exchange.Fbs.Dictionary.RegistrationStartHelper registrationStartHelperFbs;
    private com.estylesoft.integration.Exchange.Ptks.Dictionary.RegistrationStartHelper registrationStartHelperPtks;
    private com.estylesoft.integration.Exchange.Fbs.Dictionary.RegistrationFinishHelper registrationFinishHelperFbs;
    private com.estylesoft.integration.Exchange.Ptks.Dictionary.RegistrationFinishHelper registrationFinishHelperPtks;
    private com.estylesoft.integration.Exchange.Fbs.Dictionary.KbkHelper kbkHelperFbs;
    private com.estylesoft.integration.Exchange.Ptks.Dictionary.KbkHelper kbkHelperPtks;
    private com.estylesoft.integration.Exchange.Fbs.Dictionary.CategoryHelper categoryHelperFbs;
    private com.estylesoft.integration.Exchange.Ptks.Dictionary.CategoryHelper categoryHelperPtks;
    private com.estylesoft.integration.Exchange.Fbs.Dictionary.InsurerTypeHelper insurerTypeHelperFbs;
    private com.estylesoft.integration.Exchange.Ptks.Dictionary.InsurerTypeHelper insurerTypeHelperPtks;


    public CompareDictionaryDataFromFBSHelper(SqlSessionFactory sessionPtks,
                                              SqlSessionFactory sessionFbs) {
        federalOkrugHelperFbs = new com.estylesoft.integration.Exchange.Fbs.Dictionary.FederalOkrugHelper(sessionFbs);
        federalOkrugHelperPtks = new com.estylesoft.integration.Exchange.Ptks.Dictionary.FederalOkrugHelper(sessionPtks);
        registrationStartHelperFbs = new com.estylesoft.integration.Exchange.Fbs.Dictionary.RegistrationStartHelper(sessionFbs);
        registrationStartHelperPtks = new com.estylesoft.integration.Exchange.Ptks.Dictionary.RegistrationStartHelper(sessionPtks);
        registrationFinishHelperFbs = new com.estylesoft.integration.Exchange.Fbs.Dictionary.RegistrationFinishHelper(sessionFbs);
        registrationFinishHelperPtks = new com.estylesoft.integration.Exchange.Ptks.Dictionary.RegistrationFinishHelper(sessionPtks);
        kbkHelperFbs = new com.estylesoft.integration.Exchange.Fbs.Dictionary.KbkHelper(sessionFbs);
        kbkHelperPtks = new com.estylesoft.integration.Exchange.Ptks.Dictionary.KbkHelper(sessionPtks);
        categoryHelperFbs = new com.estylesoft.integration.Exchange.Fbs.Dictionary.CategoryHelper(sessionFbs);
        categoryHelperPtks = new com.estylesoft.integration.Exchange.Ptks.Dictionary.CategoryHelper(sessionPtks);
        insurerTypeHelperFbs = new com.estylesoft.integration.Exchange.Fbs.Dictionary.InsurerTypeHelper(sessionFbs);
        insurerTypeHelperPtks = new com.estylesoft.integration.Exchange.Ptks.Dictionary.InsurerTypeHelper(sessionPtks);
    }

    public CheckResult compareActualFederalOkrug() throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        boolean isContains;
        Map<Long,Boolean> mapCheck = new HashMap<Long, Boolean>();
        List<com.estylesoft.integration.Model.Ptks.Dictionary.FederalOkrugModel> lPtks = federalOkrugHelperPtks.getAll();

        for (com.estylesoft.integration.Model.Fbs.Dictionary.FederalOkrugModel fbs : federalOkrugHelperFbs.getAll()) {
            isContains = false;
            for (com.estylesoft.integration.Model.Ptks.Dictionary.FederalOkrugModel ptks : lPtks) {
                if(!mapCheck.containsKey(ptks.getId())) mapCheck.put(ptks.getId(), false);
                if (deleteZeroInCode(fbs.getCode()).equals(ptks.getCode())) {
                    mapCheck.put(ptks.getId(), true);
                    isContains = true;
                    if (String.CASE_INSENSITIVE_ORDER.compare(fbs.getName(), ptks.getName())>0
                            ||  ptks.getActualFbs() == null || ptks.getActualFbs() == 0
                            ) {
                        res.setIsSuccess(false);
                        res.addToListMessage("FBS_FO -> STH_FED_OKRUG. In PTKS record is not actual or different. STH_FED_OKRUG.FDOK_ID = " + ptks.getId(), CheckResult.ResultType.ERROR);
                    }
                }
            }
            if (!isContains) {
                res.setIsSuccess(false);
                res.addToListMessage("FBS_FO -> STH_FED_OKRUG. In PTKS record is not contains. FBS_FO.FO_ID = " + fbs.getId(), CheckResult.ResultType.ERROR);
            }

        }

        Iterator it = mapCheck.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry i = (Map.Entry)it.next();
            if(i.getValue().equals(false))
            {
                res.setIsSuccess(false);
                res.addToListMessage("FBS_FO -> STH_FED_OKRUG. In PTKS record is not contained in FBS, but actual. STH_FED_OKRUG.FDOK_ID = " + i.getKey(), CheckResult.ResultType.ERROR);
            }
        }

        return res;
    }

    public CheckResult compareActualRegistrationStart() throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        boolean isContains;
        Map<Long,Boolean> mapCheck = new HashMap<Long, Boolean>();
        List<com.estylesoft.integration.Model.Ptks.Dictionary.RegistrationStartModel> lPtks = registrationStartHelperPtks.getAll();
        for (com.estylesoft.integration.Model.Fbs.Dictionary.RegistrationStartModel fbs : registrationStartHelperFbs.getAll()) {
            isContains = false;
            for (com.estylesoft.integration.Model.Ptks.Dictionary.RegistrationStartModel ptks : lPtks) {
                if(ptks.getActualFbs()!=null &&
                        ptks.getActualFbs()==1 &&
                        !mapCheck.containsKey(ptks.getId())) mapCheck.put(ptks.getId(), false);
                if (deleteZeroInCode(fbs.getCode()).equals(ptks.getCode())) {
                    mapCheck.put(ptks.getId(), true);
                    isContains = true;
                    if (String.CASE_INSENSITIVE_ORDER.compare(fbs.getName(), ptks.getName())>0
                            ||  ptks.getActualFbs() == null || ptks.getActualFbs() == 0
                            ) {
                        res.setIsSuccess(false);
                        res.addToListMessage("FBS_REG_START -> STH_ARRANGE_REG. In PTKS record is not actual or different. STH_ARRANGE_REG.AR_ID = " + ptks.getId(), CheckResult.ResultType.ERROR);
                    }
                }
            }
            if (!isContains) {
                res.setIsSuccess(false);
                res.addToListMessage("FBS_REG_START -> STH_ARRANGE_REG. In PTKS record is not contains. FBS_REG_START.REG_START_ID = " + fbs.getId(), CheckResult.ResultType.ERROR);
            }

        }

        Iterator it = mapCheck.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry i = (Map.Entry)it.next();
            if(i.getValue().equals(false))
            {
                res.setIsSuccess(false);
                res.addToListMessage("FBS_REG_START -> STH_ARRANGE_REG. In PTKS record is not contained in FBS, but actual. STH_ARRANGE_REG.AR_ID = " + i.getKey(), CheckResult.ResultType.ERROR);
            }
        }

        return res;
    }

    public CheckResult compareActualRegistrationFinish() throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        boolean isContains;
        Map<Long,Boolean> mapCheck = new HashMap<Long, Boolean>();
        List<com.estylesoft.integration.Model.Ptks.Dictionary.RegistrationFinishModel> lPtks = registrationFinishHelperPtks.getAll();
        for (com.estylesoft.integration.Model.Fbs.Dictionary.RegistrationFinishModel fbs : registrationFinishHelperFbs.getAll()) {
            isContains = false;
            for (com.estylesoft.integration.Model.Ptks.Dictionary.RegistrationFinishModel ptks : lPtks) {
                if(ptks.getActualFbs()!=null &&
                        ptks.getActualFbs()==1 &&
                        !mapCheck.containsKey(ptks.getId())) mapCheck.put(ptks.getId(), false);
                if (deleteZeroInCode(fbs.getCode()).equals(ptks.getCode())) {
                    mapCheck.put(ptks.getId(), true);
                    isContains = true;
                    if (String.CASE_INSENSITIVE_ORDER.compare(fbs.getName(), ptks.getName())>0
                            ||  ptks.getActualFbs() == null || ptks.getActualFbs() == 0
                            ) {
                        res.setIsSuccess(false);
                        res.addToListMessage("FBS_REG_FINISH -> STH_RELEASE_REG. In PTKS record is not actual or different. STH_RELEASE_REG.RR_ID = " + ptks.getId(), CheckResult.ResultType.ERROR);
                    }
                }
            }
            if (!isContains) {
                res.setIsSuccess(false);
                res.addToListMessage("FBS_REG_FINISH -> STH_RELEASE_REG. In PTKS record is not contains. FBS_REG_FINISH.REG_FINISH_ID = " + fbs.getId(), CheckResult.ResultType.ERROR);
            }

        }

        Iterator it = mapCheck.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry i = (Map.Entry)it.next();
            if(i.getValue().equals(false))
            {
                res.setIsSuccess(false);
                res.addToListMessage("FBS_REG_FINISH -> STH_RELEASE_REG. In PTKS record is not contained in FBS, but actual. STH_RELEASE_REG.RR_ID = " + i.getKey(), CheckResult.ResultType.ERROR);
            }
        }

        return res;
    }

    public CheckResult compareActualKbk() throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        boolean isContains;
        Map<Long,Boolean> mapCheck = new HashMap<Long, Boolean>();
        List<com.estylesoft.integration.Model.Ptks.Dictionary.KbkModel> lPtks = kbkHelperPtks.getAll();
        for (com.estylesoft.integration.Model.Fbs.Dictionary.KbkModel fbs : kbkHelperFbs.getAll()) {
            isContains = false;
            for (com.estylesoft.integration.Model.Ptks.Dictionary.KbkModel ptks : lPtks) {
                if(ptks.getActualFbs()!=null &&
                        ptks.getActualFbs()==1 &&
                        !mapCheck.containsKey(ptks.getId())) mapCheck.put(ptks.getId(), false);
                if (fbs.getCode().equals(ptks.getCode())) {
                    mapCheck.put(ptks.getId(), true);
                    isContains = true;
                    if ( String.CASE_INSENSITIVE_ORDER.compare(fbs.getFullName(), ptks.getFullName())>0
                            || String.CASE_INSENSITIVE_ORDER.compare(fbs.getShortName(), ptks.getShortName())>0
                            || String.CASE_INSENSITIVE_ORDER.compare(fbs.getTypeName(), ptks.getTypeName())>0
                            ||
                            (fbs.getEndYear()!=null && !fbs.getEndYear().equals(ptks.getEndYear()))
                            ||
                            fbs.getEndYear()==null&&ptks.getEndYear()!=null
                            || !fbs.getExported().equals(ptks.getExported())
                            || !fbs.getKbkAdminId().equals(ptks.getKbkAdmin())
                            || !fbs.getKbkTypeId().equals(ptks.getKbkTypeId())
                            || !fbs.getStartYear().equals(ptks.getStartYear())
                            ||  ptks.getActualFbs() == null || ptks.getActualFbs() == 0
                            ) {
                        res.setIsSuccess(false);
                        res.addToListMessage("FBS_KBK -> STH_KBK. In PTKS record is not actual or different. STH_KBK.KBK_ID = " + ptks.getId(), CheckResult.ResultType.ERROR);
                    }
                }
            }
            if (!isContains) {
                res.setIsSuccess(false);
                res.addToListMessage("FBS_KBK -> STH_KBK. In PTKS record is not contains. FBS_KBK.KBK_ID = " + fbs.getId(), CheckResult.ResultType.ERROR);
            }

        }

        Iterator it = mapCheck.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry i = (Map.Entry)it.next();
            if(i.getValue().equals(false))
            {
                res.setIsSuccess(false);
                res.addToListMessage("FBS_KBK -> STH_KBK. In PTKS record is not contained in FBS, but actual. STH_KBK.KBK_ID = " + i.getKey(), CheckResult.ResultType.ERROR);
            }
        }

        return res;
    }

    public CheckResult compareActualCategory() throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        boolean isContains;
        Map<Long,Boolean> mapCheck = new HashMap<Long, Boolean>();
        List<com.estylesoft.integration.Model.Ptks.Dictionary.CategoryModel> lPtks = categoryHelperPtks.getAll();
        for (com.estylesoft.integration.Model.Fbs.Dictionary.CategoryModel fbs : categoryHelperFbs.getAll()) {
            isContains = false;
            for (com.estylesoft.integration.Model.Ptks.Dictionary.CategoryModel ptks : lPtks) {
                if(ptks.getActualFbs()!=null &&
                        ptks.getActualFbs()==1 &&
                        !mapCheck.containsKey(ptks.getId())) mapCheck.put(ptks.getId(), false);
                if (fbs.getCode().equals(ptks.getCode())) {
                    mapCheck.put(ptks.getId(), true);
                    isContains = true;
                    if ( String.CASE_INSENSITIVE_ORDER.compare(fbs.getName(), ptks.getName())>0
                            || !fbs.getEmployer().equals(ptks.getEmployer())
                            || !fbs.getFoms().equals(ptks.getFoms())
                            || !fbs.getPfr().equals(ptks.getPfr())
                            || !fbs.getOneWindow().equals(ptks.getOneWindow())
                            ||  ptks.getActualFbs() == null || ptks.getActualFbs() == 0
                            ) {
                        res.setIsSuccess(false);
                        res.addToListMessage("FBS_CATEGORY -> STH_CATEGORY. In PTKS record is not actual or different. STH_CATEGORY.CATEGORY_ID = " + ptks.getId(), CheckResult.ResultType.ERROR);
                    }
                }
            }
            if (!isContains) {
                res.setIsSuccess(false);
                res.addToListMessage("FBS_CATEGORY -> STH_CATEGORY. In PTKS record is not contains. FBS_CATEGORY.KBK_ID = " + fbs.getId(), CheckResult.ResultType.ERROR);
            }

        }

        Iterator it = mapCheck.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry i = (Map.Entry)it.next();
            if(i.getValue().equals(false))
            {
                res.setIsSuccess(false);
                res.addToListMessage("FBS_CATEGORY -> STH_CATEGORY. In PTKS record is not contained in FBS, but actual. STH_CATEGORY.CT_ID = " + i.getKey(), CheckResult.ResultType.ERROR);
            }
        }

        return res;
    }

    public CheckResult compareActualInsurerType() throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        boolean isContains;
        Map<Long,Boolean> mapCheck = new HashMap<Long, Boolean>();
        List<com.estylesoft.integration.Model.Ptks.Dictionary.InsurerTypeModel> lPtks = insurerTypeHelperPtks.getAll();
        for (com.estylesoft.integration.Model.Fbs.Dictionary.InsurerTypeModel fbs : insurerTypeHelperFbs.getAll()) {
            isContains = false;
            for (com.estylesoft.integration.Model.Ptks.Dictionary.InsurerTypeModel ptks : lPtks) {
                if(ptks.getActualFbs()!=null &&
                        ptks.getActualFbs()==1 &&
                        !mapCheck.containsKey(ptks.getId())) mapCheck.put(ptks.getId(), false);
                if (String.CASE_INSENSITIVE_ORDER.compare(fbs.getName(), ptks.getName())==0) {
                    mapCheck.put(ptks.getId(), true);
                    isContains = true;
                    if (!fbs.getPerson().equals(ptks.getPerson())
                            ||  ptks.getActualFbs() == null || ptks.getActualFbs() == 0
                            ) {
                        res.setIsSuccess(false);
                        res.addToListMessage("FBS_INSURER_TYPE -> STH_TYPE. In PTKS record is not actual or different. STH_TYPE.TP_ID = " + ptks.getId(), CheckResult.ResultType.ERROR);
                    }
                }
            }
            if (!isContains) {
                res.setIsSuccess(false);
                res.addToListMessage("FBS_INSURER_TYPE -> STH_TYPE. In PTKS record is not contains. FBS_INSURER_TYPE.INSURER_TYPE_ID = " + fbs.getId(), CheckResult.ResultType.ERROR);
            }

        }

        Iterator it = mapCheck.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry i = (Map.Entry)it.next();
            if(i.getValue().equals(false))
            {
                res.setIsSuccess(false);
                res.addToListMessage("FBS_INSURER_TYPE -> STH_TYPE. In PTKS record is not contained in FBS, but actual. STH_TYPE.TP_ID = " + i.getKey(), CheckResult.ResultType.ERROR);
            }
        }

        return res;
    }
}

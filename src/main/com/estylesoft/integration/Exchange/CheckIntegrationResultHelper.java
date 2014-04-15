package com.estylesoft.integration.Exchange;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Exchange.Fbs.PackageHelper;
import com.estylesoft.integration.Exchange.Fbs.ProtocolHelper;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Fbs.ProtocolModel;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Date;
import java.util.List;

import static com.estylesoft.integration.Exchange.EqualModelHelper.IsEqualsBaseDepartment;
import static com.estylesoft.integration.Exchange.EqualModelHelper.IsEqualsOpfr;
import static com.estylesoft.integration.Exchange.EqualModelHelper.IsEqualsTerOrgan;
import static com.estylesoft.integration.Util.Util.deleteZeroInCode;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 04.04.14
 * Time: 17:08
 * To change this template use File | Settings | File Templates.
 */
public class CheckIntegrationResultHelper {

    private com.estylesoft.integration.Exchange.Fbs.OpfrHelper opfrHelperFbs;
    private com.estylesoft.integration.Exchange.Ptks.OpfrHelper opfrHelperPtks;
    private com.estylesoft.integration.Exchange.Fbs.BaseDepartmentHelper boHelperFbs;
    private com.estylesoft.integration.Exchange.Ptks.BaseDepartmentHelper boHelperPtks;
    private com.estylesoft.integration.Exchange.Fbs.TerOrganHelper terOrganHelperFbs;
    private com.estylesoft.integration.Exchange.Ptks.TerOrganHelper terOrganHelperPtks;
    private PackageHelper packageHelperFbs;
    private ProtocolHelper protocolHelperFbs;

    public CheckIntegrationResultHelper(SqlSessionFactory sessionPtks,
                                        SqlSessionFactory sessionFbs) {

        opfrHelperFbs = new com.estylesoft.integration.Exchange.Fbs.OpfrHelper(sessionFbs);
        opfrHelperPtks = new com.estylesoft.integration.Exchange.Ptks.OpfrHelper(sessionPtks);

        boHelperFbs = new com.estylesoft.integration.Exchange.Fbs.BaseDepartmentHelper(sessionFbs);
        boHelperPtks = new com.estylesoft.integration.Exchange.Ptks.BaseDepartmentHelper(sessionPtks);

        terOrganHelperFbs = new com.estylesoft.integration.Exchange.Fbs.TerOrganHelper(sessionFbs);
        terOrganHelperPtks = new com.estylesoft.integration.Exchange.Ptks.TerOrganHelper(sessionPtks);

        packageHelperFbs = new PackageHelper(sessionFbs);
        protocolHelperFbs = new ProtocolHelper(sessionFbs);
    }

    private Long getPackageByOpfrId(Long opfrId)
    {
       return packageHelperFbs.getMaxNumberByOpfrId(opfrId).getId();
    }

    private ProtocolModel getProtocolRecord(Long opfrIdFbs, String recordId)
    {
        return   protocolHelperFbs.getByPackageIdRecordId(getPackageByOpfrId(opfrIdFbs), recordId);
    }

    private boolean isNotExportMarkedRecord(Integer isExported)
    {
       return isExported != null && isExported == 0 || isExported == null;
    }

    private boolean isChangedOtherRecords(Integer isExported, Date deflectDate)
    {
       return deflectDate != null || isExported != null && isExported == 1;
    }

    public Long getFbsOpfrId() throws IntegrationException {
        com.estylesoft.integration.Model.Ptks.OpfrModel opfrPtks = opfrHelperPtks.getPfrCurrent();
        com.estylesoft.integration.Model.Fbs.OpfrModel opfrFbs = null;
        if(opfrPtks!=null)  opfrFbs = opfrHelperFbs.getByCode(opfrPtks.getCode());
        return opfrFbs!=null?opfrFbs.getId():null;
    }

    public CheckResult CheckIntegrationOpfr() throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        boolean isContains;
        List<com.estylesoft.integration.Model.Fbs.OpfrModel> lOpfrFbs = opfrHelperFbs.getAll();
        for (com.estylesoft.integration.Model.Ptks.OpfrModel opfrPtks : opfrHelperPtks.getAll()) {
            isContains = false;
            for (com.estylesoft.integration.Model.Fbs.OpfrModel opfrFbs : lOpfrFbs) {
                //Проверка, что данные для выгрузки верно обработаны
                if (opfrPtks.getCurrent() != null && opfrPtks.getCurrent() == 1) {
                    if (opfrPtks.getCode().equals(opfrFbs.getCode())) {
                        isContains = true;
                        if (!IsEqualsOpfr(opfrFbs, opfrPtks)) {
                            res.setIsSuccess(false);
                            res.addToListMessage("STH_MAIN_REG_DIV_PFR -> FBS_OPFR. There is different record in Source.PTKS and Target.FBS. STH_MAIN_REG_DIV_PFR.MRDV_ID = " + opfrPtks.getId() + ", FBS_OPFR.OPFR_ID = " + opfrFbs.getId(), CheckResult.ResultType.ERROR);
                        }

                        if (isNotExportMarkedRecord(opfrPtks.getExported())) {
                            res.setIsSuccess(false);
                            res.addToListMessage("STH_MAIN_REG_DIV_PFR -> FBS_OPFR. Target.FBS is imported, but Source.PTKS is not marked [IsExported = 1]. STH_MAIN_REG_DIV_PFR.MRDV_ID = " + opfrPtks.getId() + ", FBS_OPFR.OPFR_ID = " + opfrFbs.getId(), CheckResult.ResultType.ERROR);
                        }
                    }
                }
            }

            if (opfrPtks.getCurrent() != null && opfrPtks.getCurrent() == 1) {
                //Если нет в ФБС, то должна быть проставлена дата в ПТКС
                if (!isContains && opfrPtks.getDefectFbsDate() == null) {
                    res.setIsSuccess(false);
                    res.addToListMessage("STH_MAIN_REG_DIV_PFR -> FBS_OPFR. Target.FBS is not inserted, but Source.PTKS is not updated [IsDeflectDate = CURRENT_DATE]. STH_MAIN_REG_DIV_PFR.MRDV_ID = " + opfrPtks.getId(), CheckResult.ResultType.ERROR);
                }

                //Если нет в ФБС записей, предназначенных для выгрузки, то о них должна быть инфорамция в протоколе
                if(!isContains &&
                        packageHelperFbs.getMaxNumberLikeOpfrCode(opfrPtks.getCode()).getErrorCode()==null)
                        //getProtocolRecord(opfrPtks.getId(), opfrPtks.getId().toString())==null)
                {
                    res.setIsSuccess(false);
                    res.addToListMessage("STH_MAIN_REG_DIV_PFR -> FBS_OPFR. Target.FBS is not inserted, but not in pfr_protocol. STH_MAIN_REG_DIV_PFR.MRDV_ID = " + opfrPtks.getId(), CheckResult.ResultType.ERROR);
                }
            } else {
                //В ФБС не должны быть записи, не предназначенные для выгрузки
                if (isContains) {
                    res.setIsSuccess(false);
                    res.addToListMessage("STH_MAIN_REG_DIV_PFR -> FBS_OPFR. Target.FBS is contained Source.PTKS must not exported record", CheckResult.ResultType.ERROR);
                }

                //В ПТКС записи, не предназначенные для выгрузки, не должны быть изменены.
                if (isChangedOtherRecords(opfrPtks.getExported(), opfrPtks.getDefectFbsDate())) {
                    res.setIsSuccess(false);
                    res.addToListMessage("STH_MAIN_REG_DIV_PFR -> FBS_OPFR. Source.PTKS record is marked [IsExported = 1] or updated [IsDeflectDate = CURRENT_DATE], but Source.PTKS must not exported", CheckResult.ResultType.ERROR);
                }

            }

        }
        return res;
    }

    public CheckResult CheckIntegrationBaseDepartment(Long opfrIdFbs) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        boolean isContains;
        List<com.estylesoft.integration.Model.Fbs.BaseDepartmentModel> lBoFbs = boHelperFbs.getAll();
        for (com.estylesoft.integration.Model.Ptks.BaseDepartmentModel boPtks : boHelperPtks.getAll()) {
            isContains = false;
            for (com.estylesoft.integration.Model.Fbs.BaseDepartmentModel boFbs : lBoFbs) {
                //Проверка, что данные для выгрузки верно обработаны
                if (boPtks.getOpfrCurrent()!= null && boPtks.getOpfrCurrent() == 1) {
                    if (boPtks.getCode().equals(deleteZeroInCode(boFbs.getCode())) && opfrIdFbs.equals(boFbs.getOpfrId())) {
                        isContains = true;
                        if (!IsEqualsBaseDepartment(boFbs, boPtks)) {
                            res.setIsSuccess(false);
                            res.addToListMessage("STH_REG_DIV_PFR -> FBS_BO. There is different record in Source.PTKS and Target.FBS. STH_REG_DIV_PFR.RDV_ID = " + boPtks.getId() + ", FBS_BO.BO_ID = " + boFbs.getId(), CheckResult.ResultType.ERROR);
                        }

                        if (isNotExportMarkedRecord(boPtks.getExported())) {
                            res.setIsSuccess(false);
                            res.addToListMessage("STH_REG_DIV_PFR -> FBS_BO. Target.FBS is imported, but Source.PTKS is not marked [IsExported = 1]. STH_REG_DIV_PFR.RDV_ID = " + boPtks.getId() + ", FBS_BO.BO_ID = " + boFbs.getId(), CheckResult.ResultType.ERROR);
                        }
                    }
                }
            }

            if (boPtks.getOpfrCurrent() != null && boPtks.getOpfrCurrent() == 1) {
                //Если нет в ФБС, то должна быть проставлена дата в ПТКС
                if (!isContains && boPtks.getDefectFbsDate() == null) {
                    res.setIsSuccess(false);
                    res.addToListMessage("STH_REG_DIV_PFR -> FBS_BO. Target.FBS is not inserted, but Source.PTKS is not updated [IsDeflectDate = CURRENT_DATE]. STH_REG_DIV_PFR.RDV_ID = " + boPtks.getId(), CheckResult.ResultType.ERROR);
                }

                //Если нет в ФБС записей, предназначенных для выгрузки, то о них должна быть инфорамция в протоколе
                if(!isContains && getProtocolRecord(opfrIdFbs, boPtks.getId().toString())==null)
                {
                    res.setIsSuccess(false);
                    res.addToListMessage("STH_REG_DIV_PFR -> FBS_BO. Target.FBS is not inserted, but not in pfr_protocol. STH_REG_DIV_PFR.RDV_ID = " + boPtks.getId(), CheckResult.ResultType.ERROR);
                }
            } else {
                //В ФБС не должны быть записи, не предназначенные для выгрузки
                if (isContains) {
                    res.setIsSuccess(false);
                    res.addToListMessage("STH_REG_DIV_PFR -> FBS_BO. Target.FBS is contained Source.PTKS must not exported record", CheckResult.ResultType.ERROR);
                }

                //В ПТКС записи, не предназначенные для выгрузки, не должны быть изменены.
                if (isChangedOtherRecords(boPtks.getExported(), boPtks.getDefectFbsDate())) {
                    res.setIsSuccess(false);
                    res.addToListMessage("STH_REG_DIV_PFR -> FBS_BO. Source.PTKS record is marked [IsExported = 1] or updated [IsDeflectDate = CURRENT_DATE], but Source.PTKS must not exported", CheckResult.ResultType.ERROR);
                }

            }

        }
        return res;
    }

    public CheckResult CheckIntegrationTerOrgan(Long opfrIdFbs) throws IntegrationException {
        CheckResult res = new CheckResult();
        res.setIsSuccess(true);
        boolean isContains;
        List<com.estylesoft.integration.Model.Fbs.TerOrganModel> lTerOrganFbs = terOrganHelperFbs.getAll();
        for (com.estylesoft.integration.Model.Ptks.TerOrganModel terOrganPtks : terOrganHelperPtks.getAll()) {
            isContains = false;
            for (com.estylesoft.integration.Model.Fbs.TerOrganModel terOrganFbs : lTerOrganFbs) {
                //Проверка, что данные для выгрузки верно обработаны
                if (terOrganPtks.getOpfrCurrent()!= null && terOrganPtks.getOpfrCurrent() == 1) {
                    if (terOrganPtks.getCode().equals(deleteZeroInCode(terOrganFbs.getCode())) && opfrIdFbs.equals(terOrganFbs.getOpfrId())) {
                        isContains = true;
                        if (!IsEqualsTerOrgan(terOrganFbs, terOrganPtks)) {
                            res.setIsSuccess(false);
                            res.addToListMessage("STH_TERRITORIAL_ORGAN -> FBS_TO. There is different record in Source.PTKS and Target.FBS. STH_TERRITORIAL_ORGAN.TER_ORGAN_ID = " + terOrganPtks.getId() + ", FBS_TO.TO_ID = " + terOrganFbs.getId(), CheckResult.ResultType.ERROR);
                        }

                        if (isNotExportMarkedRecord(terOrganPtks.getExported())) {
                            res.setIsSuccess(false);
                            res.addToListMessage("STH_TERRITORIAL_ORGAN -> FBS_TO. Target.FBS is imported, but Source.PTKS is not marked [IsExported = 1]. STH_TERRITORIAL_ORGAN.TER_ORGAN_ID = " + terOrganPtks.getId() + ", FBS_TO.TO_ID = " + terOrganFbs.getId(), CheckResult.ResultType.ERROR);
                        }
                    }
                }
            }

            if (terOrganPtks.getOpfrCurrent() != null && terOrganPtks.getOpfrCurrent() == 1) {
                //Если нет в ФБС, то должна быть проставлена дата в ПТКС
                if (!isContains && terOrganPtks.getDefectFbsDate() == null) {
                    res.setIsSuccess(false);
                    res.addToListMessage("STH_TERRITORIAL_ORGAN -> FBS_TO. Target.FBS is not inserted, but Source.PTKS is not updated [IsDeflectDate = CURRENT_DATE]. STH_TERRITORIAL_ORGAN.TER_ORGAN_ID = " + terOrganPtks.getId(), CheckResult.ResultType.ERROR);
                }

                //Если нет в ФБС записей, предназначенных для выгрузки, то о них должна быть инфорамция в протоколе
                if(!isContains && getProtocolRecord(opfrIdFbs, terOrganPtks.getId().toString())==null)
                {
                    res.setIsSuccess(false);
                    res.addToListMessage("STH_TERRITORIAL_ORGAN -> FBS_TO. Target.FBS is not inserted, but not in pfr_protocol. STH_TERRITORIAL_ORGAN.TER_ORGAN_ID = " + terOrganPtks.getId(), CheckResult.ResultType.ERROR);
                }
            } else {
                //В ФБС не должны быть записи, не предназначенные для выгрузки
                if (isContains) {
                    res.setIsSuccess(false);
                    res.addToListMessage("STH_TERRITORIAL_ORGAN -> FBS_TO. Target.FBS is contained Source.PTKS must not exported record", CheckResult.ResultType.ERROR);
                }

                //В ПТКС записи, не предназначенные для выгрузки, не должны быть изменены.
                if (isChangedOtherRecords(terOrganPtks.getExported(), terOrganPtks.getDefectFbsDate())) {
                    res.setIsSuccess(false);
                    res.addToListMessage("STH_TERRITORIAL_ORGAN -> FBS_TO. Source.PTKS record is marked [IsExported = 1] or updated [IsDeflectDate = CURRENT_DATE], but Source.PTKS must not exported", CheckResult.ResultType.ERROR);
                }

            }

        }
        return res;
    }
}

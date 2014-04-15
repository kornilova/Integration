package com.estylesoft.integration.Exchange;

import static com.estylesoft.integration.Util.Util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 09.04.14
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
public class EqualModelHelper {

    public static boolean IsEqualsOpfr(com.estylesoft.integration.Model.Fbs.OpfrModel fbs,
                                       com.estylesoft.integration.Model.Ptks.OpfrModel ptks) {
        return (fbs == null && ptks == null ||
                String.CASE_INSENSITIVE_ORDER.compare(ptks.getName(), fbs.getName()) == 0
                        && String.CASE_INSENSITIVE_ORDER.compare(ptks.getAddress(), fbs.getAddress()) == 0
                        && String.CASE_INSENSITIVE_ORDER.compare(ptks.getFullName(), fbs.getFullName()) == 0
                        && String.CASE_INSENSITIVE_ORDER.compare(ptks.getPhone(), fbs.getPhone()) == 0
                        && String.CASE_INSENSITIVE_ORDER.compare(ptks.getShortName(), fbs.getShortName()) == 0
                        && (ptks.getInn() != null && ptks.getInn().toString().equals(fbs.getInn()) ||
                        ptks.getInn() == null && fbs.getInn() == null)
                        && (ptks.getKpp() != null && ptks.getKpp().toString().equals(fbs.getKpp()) ||
                        ptks.getKpp() == null && fbs.getKpp() == null)
                        && (ptks.getFederalOkrugCode() != null && ptks.getFederalOkrugCode().equals(deleteZeroInCode(fbs.getFederalOkrugCode())) ||
                        ptks.getFederalOkrugCode() == fbs.getFederalOkrugCode())
                        && ptks.getCode().equals(fbs.getCode())
        );
    }

    public static boolean IsEqualsBaseDepartment(com.estylesoft.integration.Model.Fbs.BaseDepartmentModel fbs,
                                                 com.estylesoft.integration.Model.Ptks.BaseDepartmentModel ptks) {
        return (fbs == null && ptks == null ||
                String.CASE_INSENSITIVE_ORDER.compare(ptks.getName(), fbs.getName()) == 0
                        && ptks.getCode().equals(deleteZeroInCode(fbs.getCode()))
                        && ptks.getOpfrCode().equals(fbs.getOpfrCode())
        );
    }

    public static boolean IsEqualsTerOrgan(com.estylesoft.integration.Model.Fbs.TerOrganModel fbs,
                                           com.estylesoft.integration.Model.Ptks.TerOrganModel ptks) {
        return (fbs == null && ptks == null ||
                String.CASE_INSENSITIVE_ORDER.compare(ptks.getName(), fbs.getName()) == 0
                        && ptks.getCode().equals(deleteZeroInCode(fbs.getCode()))
                        && ptks.getOpfrCode().equals(deleteZeroInCode(fbs.getOpfrCode()))
                        && isEqualsInsensitiveCaseTrimString(ptks.getCompanyName(), fbs.getCompanyName())
                        && isEqualsInsensitiveCaseTrimString(ptks.getShortName(), fbs.getShortName())
                        && isEqualsInsensitiveCaseTrimString(ptks.getAddress(), fbs.getAddress())
                        && isEqualsInsensitiveCaseTrimString(ptks.getPhone(), fbs.getPhone())
                        && isEqualsObject(ptks.getInn() != null ? ptks.getInn().toString() : null, deleteZeroInCode(fbs.getInn()))
                        && isEqualsObject(ptks.getKpp() != null ? ptks.getKpp().toString() : null, deleteZeroInCode(fbs.getKpp()))
                        && isEqualsInsensitiveCaseTrimString(ptks.getHeadName(), fbs.getHeadName())
                        && isEqualsObject(ptks.getOkato() != null ? ptks.getOkato().toString() : null, deleteZeroInCode(fbs.getOkato()))
                        && isEqualsObject(ptks.getOgrn() != null ? ptks.getOgrn().toString() : null, deleteZeroInCode(fbs.getOgrn()))
                        && isEqualsInsensitiveCaseTrimString(ptks.getComment(), fbs.getInfo())
        );
    }
}

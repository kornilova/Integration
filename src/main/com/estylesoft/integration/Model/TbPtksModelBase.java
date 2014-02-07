package com.estylesoft.integration.Model;

import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 31.10.13
 * Time: 12:12
 * To change this template use File | Settings | File Templates.
 */
public class TbPtksModelBase extends TbModelBase {

    private int isFbsActual;
    private Date defectFbsDate;
    private int isFbsExported;

    public int getFbsActual() {
        return isFbsActual;
    }

    public void setFbsActual(int fbsActual) {
        isFbsActual = fbsActual;
    }

    public int getFbsExported() {
        return isFbsExported;
    }

    public void setFbsExported(int fbsExported) {
        isFbsExported = fbsExported;
    }

    public Date getDefectFbsDate() {
        return defectFbsDate;
    }

    public void setDefectFbsDate(Date defectFbsDate) {
        this.defectFbsDate = defectFbsDate;
    }
}

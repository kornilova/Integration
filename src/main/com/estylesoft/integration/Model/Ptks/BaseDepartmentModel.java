package com.estylesoft.integration.Model.Ptks;

import com.estylesoft.integration.Model.ModelBase;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 28.01.14
 * Time: 18:41
 * To change this template use File | Settings | File Templates.
 */
/*STH_REG_DIV_PFR
Базовое отделение*/
public class BaseDepartmentModel extends ModelBase {

    private String code;
    private String name;
    private String opfrCode;
    private Long opfrId;
    private Integer isExported;
    private Date defectFbsDate;
    private Integer isOpfrCurrent;

    public Integer getExported() {
        return isExported;
    }

    public void setExported(Integer exported) {
        isExported = exported;
    }

    public Integer getOpfrCurrent() {
        return isOpfrCurrent;
    }

    public void setOpfrCurrent(Integer opfrCurrent) {
        isOpfrCurrent = opfrCurrent;
    }

    public Date getDefectFbsDate() {
        return defectFbsDate;
    }

    public void setDefectFbsDate(Date defectFbsDate) {
        this.defectFbsDate = defectFbsDate;
    }

    public Long getOpfrId() {
        return opfrId;
    }

    public void setOpfrId(Long opfrId) {
        this.opfrId = opfrId;
    }

    public String getOpfrCode() {
        return opfrCode;
    }

    public void setOpfrCode(String opfrCode) {
        this.opfrCode = opfrCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

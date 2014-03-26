package com.estylesoft.integration.Model.Ptks;

import com.estylesoft.integration.Model.ModelBase;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 13:39
 * To change this template use File | Settings | File Templates.
 */
public class OkatoModel extends ModelBase {

    private String code;
    private String terDepartmentPFRCode;
    private TerDepartmentPFRModel terDepartmentPFR;
    private String baseDepartmentCode;
    private BaseDepartmentModel baseDepartment;

    public BaseDepartmentModel getBaseDepartment() {
        return baseDepartment;
    }

    public void setBaseDepartment(BaseDepartmentModel baseDepartment) {
        this.baseDepartment = baseDepartment;
    }

    private String opfrCode;
    private String terOrganCode;

    public String getTerOrganCode() {
        return terOrganCode;
    }

    public void setTerOrganCode(String terOrganCode) {
        this.terOrganCode = terOrganCode;
    }

    public String getTerDepartmentPFRCode() {
        return terDepartmentPFRCode;
    }

    public void setTerDepartmentPFRCode(String terDepartmentPFRCode) {
        this.terDepartmentPFRCode = terDepartmentPFRCode;
    }

     public TerDepartmentPFRModel getTerDepartmentPFR() {
        return terDepartmentPFR;
    }

    public void setTerDepartmentPFR(TerDepartmentPFRModel terDepartmentPFR) {
        this.terDepartmentPFR = terDepartmentPFR;
    }

    public String getOpfrCode() {
        return opfrCode;
    }

    public void setOpfrCode(String opfrCode) {
        this.opfrCode = opfrCode;
    }


    public String getBaseDepartmentCode() {
        return baseDepartmentCode;
    }

    public void setBaseDepartmentCode(String baseDepartmentCode) {
        this.baseDepartmentCode = baseDepartmentCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

package com.estylesoft.integration.Model.Ptks;

import com.estylesoft.integration.Model.ModelBase;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 13:39
 * To change this template use File | Settings | File Templates.
 */
public class AdmTerritoryModel extends ModelBase {

    private String code;
    private String name;

    private String opfrCode;
    private Long opfrId;

    private String baseDepartmentCode;
    private Long baseDepartmentId;

    private String terDepartmentPFRCode;
    private Long terDepartmentPFRId;

    private String regionCode;
    private Long regionId;

    private String terOrganCode;
    private Long terOrganId;

    public String getTerOrganCode() {
        return terOrganCode;
    }

    public void setTerOrganCode(String terOrganCode) {
        this.terOrganCode = terOrganCode;
    }

    public Long getTerOrganId() {
        return terOrganId;
    }

    public void setTerOrganId(Long terOrganId) {
        this.terOrganId = terOrganId;
    }

    public String getOpfrCode() {
        return opfrCode;
    }

    public void setOpfrCode(String opfrCode) {
        this.opfrCode = opfrCode;
    }

    public Long getOpfrId() {
        return opfrId;
    }

    public void setOpfrId(Long opfrId) {
        this.opfrId = opfrId;
    }

    public Long getBaseDepartmentId() {
        return baseDepartmentId;
    }

    public void setBaseDepartmentId(Long baseDepartmentId) {
        this.baseDepartmentId = baseDepartmentId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long region) {
        this.regionId = region;
    }

    public Long getTerDepartmentPFRId() {
        return terDepartmentPFRId;
    }

    public void setTerDepartmentPFRId(Long terDepartmentPFRId) {
        this.terDepartmentPFRId = terDepartmentPFRId;
    }

    public String getBaseDepartmentCode() {
        return baseDepartmentCode;
    }

    public void setBaseDepartmentCode(String baseDepartmentCode) {
        this.baseDepartmentCode = baseDepartmentCode;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getTerDepartmentPFRCode() {
        return terDepartmentPFRCode;
    }

    public void setTerDepartmentPFRCode(String terDepartmentPFRCode) {
        this.terDepartmentPFRCode = terDepartmentPFRCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

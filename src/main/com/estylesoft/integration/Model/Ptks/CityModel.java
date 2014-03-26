package com.estylesoft.integration.Model.Ptks;

import com.estylesoft.integration.Model.ModelBase;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 13:39
 * To change this template use File | Settings | File Templates.
 */
public class CityModel extends ModelBase {

    private String code;
    private String name;

    private String opfrCode;
    private OpfrModel opfr;

    private String baseDepartmentCode;
    private BaseDepartmentModel baseDepartment;

    private String terDepartmentPFRCode;
    private TerDepartmentPFRModel terDepartmentPFR;

    private String regionCode;
    private RegionModel region;

    private String terOrganCode;
    private TerOrganModel terOrgan;

    private String admTerritoryCode;
    private AdmTerritoryModel admTerritory;

    public AdmTerritoryModel getAdmTerritory() {
        return admTerritory;
    }

    public void setAdmTerritory(AdmTerritoryModel admTerritory) {
        this.admTerritory = admTerritory;
    }

    public String getOpfrCode() {
        return opfrCode;
    }

    public void setOpfrCode(String opfrCode) {
        this.opfrCode = opfrCode;
    }

    public OpfrModel getOpfr() {
        return opfr;
    }

    public void setOpfr(OpfrModel opfr) {
        this.opfr = opfr;
    }

    public BaseDepartmentModel getBaseDepartment() {
        return baseDepartment;
    }

    public void setBaseDepartment(BaseDepartmentModel baseDepartment) {
        this.baseDepartment = baseDepartment;
    }

    public TerDepartmentPFRModel getTerDepartmentPFR() {
        return terDepartmentPFR;
    }

    public void setTerDepartmentPFR(TerDepartmentPFRModel terDepartmentPFR) {
        this.terDepartmentPFR = terDepartmentPFR;
    }

    public RegionModel getRegion() {
        return region;
    }

    public void setRegion(RegionModel region) {
        this.region = region;
    }

    public String getTerOrganCode() {
        return terOrganCode;
    }

    public void setTerOrganCode(String terOrganCode) {
        this.terOrganCode = terOrganCode;
    }

    public TerOrganModel getTerOrgan() {
        return terOrgan;
    }

    public void setTerOrgan(TerOrganModel terOrgan) {
        this.terOrgan = terOrgan;
    }

    public String getAdmTerritoryCode() {
        return admTerritoryCode;
    }

    public void setAdmTerritoryCode(String admTerritoryCode) {
        this.admTerritoryCode = admTerritoryCode;
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

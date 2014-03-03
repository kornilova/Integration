package com.estylesoft.integration.Model.Ptks;

import com.estylesoft.integration.Model.ModelBase;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 13:39
 * To change this template use File | Settings | File Templates.
 */
public class StreetModel extends ModelBase {

    private String code;
    private String name;

    private String baseDepartmentCode;
    private String townCode;
    private String cityCode;
    private String regionCode;
    private String admTerritoryCode;

    private Long baseDepartmentId;
    private Long townId;
    private Long cityId;
    private Long regionId;
    private Long admTerritoryId;

    public Long getBaseDepartmentId() {
        return baseDepartmentId;
    }

    public void setBaseDepartmentId(Long baseDepartmentId) {
        this.baseDepartmentId = baseDepartmentId;
    }

    public Long getAdmTerritoryId() {
        return admTerritoryId;
    }

    public void setAdmTerritoryId(Long admTerritoryId) {
        this.admTerritoryId = admTerritoryId;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getTownId() {
        return townId;
    }

    public void setTownId(Long townId) {
        this.townId = townId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getTownCode() {
        return townCode;
    }

    public void setTownCode(String townCode) {
        this.townCode = townCode;
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

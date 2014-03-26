package com.estylesoft.integration.Model.Ptks;

import com.estylesoft.integration.Model.ModelBase;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 13:39
 * To change this template use File | Settings | File Templates.
 */
public class StreetHousesModel extends ModelBase {

    private String houses;
    private String townCode;
    private TownModel town;

    private String cityCode;
    private CityModel city;

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

    private String streetCode;
    private StreetModel street;

    private StreetDepartmentModel streetDepartment;

    public StreetDepartmentModel getStreetDepartment() {
        return streetDepartment;
    }

    public void setStreetDepartment(StreetDepartmentModel streetDepartment) {
        this.streetDepartment = streetDepartment;
    }

    public String getHouses() {
        return houses;
    }

    public void setHouses(String houses) {
        this.houses = houses;
    }

    public String getTownCode() {
        return townCode;
    }

    public void setTownCode(String townCode) {
        this.townCode = townCode;
    }

    public TownModel getTown() {
        return town;
    }

    public void setTown(TownModel town) {
        this.town = town!=null? town: new TownModel();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public CityModel getCity() {
        return city;
    }

    public void setCity(CityModel city) {
        this.city = city!=null? city: new CityModel();
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

    public String getBaseDepartmentCode() {
        return baseDepartmentCode;
    }

    public void setBaseDepartmentCode(String baseDepartmentCode) {
        this.baseDepartmentCode = baseDepartmentCode;
    }

    public BaseDepartmentModel getBaseDepartment() {
        return baseDepartment;
    }

    public void setBaseDepartment(BaseDepartmentModel baseDepartment) {
        this.baseDepartment = baseDepartment;
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

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public RegionModel getRegion() {
        return region;
    }

    public void setRegion(RegionModel region) {
        this.region = region!=null? region: new RegionModel();
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

    public AdmTerritoryModel getAdmTerritory() {
        return admTerritory;
    }

    public void setAdmTerritory(AdmTerritoryModel admTerritory) {
        this.admTerritory = admTerritory!=null? admTerritory: new AdmTerritoryModel();
    }

    public String getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(String streetCode) {
        this.streetCode = streetCode;
    }

    public StreetModel getStreet() {
        return street;
    }

    public void setStreet(StreetModel street) {
        this.street = street;
    }
}

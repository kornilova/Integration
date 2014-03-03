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
    private String terDepartmentPFRCode;
    private String streetCode;
    private String baseDepartmentCode;

    private Long streetTerDepartmentId;

    public Long getStreetTerDepartmentId() {
        return streetTerDepartmentId;
    }

    public void setStreetTerDepartmentId(Long streetTerDepartmentId) {
        this.streetTerDepartmentId = streetTerDepartmentId;
    }

    public String getBaseDepartmentCode() {
        return baseDepartmentCode;
    }

    public void setBaseDepartmentCode(String baseDepartmentCode) {
        this.baseDepartmentCode = baseDepartmentCode;
    }


    public String getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(String streetCode) {
        this.streetCode = streetCode;
    }

    public String getTerDepartmentPFRCode() {
        return terDepartmentPFRCode;
    }

    public void setTerDepartmentPFRCode(String terDepartmentPFRCode) {
        this.terDepartmentPFRCode = terDepartmentPFRCode;
    }

    public String getHouses() {
        return houses;
    }

    public void setHouses(String houses) {
        this.houses = houses;
    }

}

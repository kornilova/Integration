package com.estylesoft.integration.Model.Ptks;

import com.estylesoft.integration.Model.ModelBase;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 13:39
 * To change this template use File | Settings | File Templates.
 */
public class StreetDepartmentModel extends ModelBase {

    private String terDepartmentPFRCode;
    private String streetCode;
    private String baseDepartmentCode;

    private Long terDepartmentPFRId;
    private Long streetId;
    private Long baseDepartmentId;

    private Integer hFrom;
    private Integer hTo;
    private Integer hEven;

    public String getBaseDepartmentCode() {
        return baseDepartmentCode;
    }

    public void setBaseDepartmentCode(String baseDepartmentCode) {
        this.baseDepartmentCode = baseDepartmentCode;
    }

    public Long getBaseDepartmentId() {
        return baseDepartmentId;
    }

    public void setBaseDepartmentId(Long baseDepartmentId) {
        this.baseDepartmentId = baseDepartmentId;
    }

    public Long getTerDepartmentPFRId() {
        return terDepartmentPFRId;
    }

    public void setTerDepartmentPFRId(Long terDepartmentPFRId) {
        this.terDepartmentPFRId = terDepartmentPFRId;
    }

    public Long getStreetId() {
        return streetId;
    }

    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }

    public String getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(String streetCode) {
        this.streetCode = streetCode;
    }

    public Integer gethFrom() {
        return hFrom;
    }

    public void sethFrom(Integer hFrom) {
        this.hFrom = hFrom;
    }

    public Integer gethTo() {
        return hTo;
    }

    public void sethTo(Integer hTo) {
        this.hTo = hTo;
    }

    public Integer gethEven() {
        return hEven;
    }

    public void sethEven(Integer hEven) {
        this.hEven = hEven;
    }

    public String getTerDepartmentPFRCode() {
        return terDepartmentPFRCode;
    }

    public void setTerDepartmentPFRCode(String terDepartmentPFRCode) {
        this.terDepartmentPFRCode = terDepartmentPFRCode;
    }

}

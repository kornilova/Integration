package com.estylesoft.integration.Model.Ptks;

import com.estylesoft.integration.Model.ModelBase;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 09.02.14
 * Time: 23:53
 * To change this template use File | Settings | File Templates.
 */
/*Районный орган
STH_TERRITORY_DPT_PFR*/
public class TerDepartmentPFRModel extends ModelBase {

    private String code;
    private String name;
    private String address;
    private String phone;
    private Integer isCurrent;
    private String regNum;
    private String regNumStart;
    private String regNumEnd;
    private String head;

    private String terOgranCode;
    private Long terOrganId;

    private String baseDepartmentCode;
    private Long baseDepartmentId;

    public Long getTerOrganId() {
        return terOrganId;
    }

    public void setTerOrganId(Long terOrganId) {
        this.terOrganId = terOrganId;
    }

    public Long getBaseDepartmentId() {
        return baseDepartmentId;
    }

    public void setBaseDepartmentId(Long baseDepartmentId) {
        this.baseDepartmentId = baseDepartmentId;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCurrent() {
        return isCurrent;
    }

    public void setCurrent(Integer current) {
        isCurrent = current;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getRegNumStart() {
        return regNumStart;
    }

    public void setRegNumStart(String regNumStart) {
        this.regNumStart = regNumStart;
    }

    public String getRegNumEnd() {
        return regNumEnd;
    }

    public void setRegNumEnd(String regNumEnd) {
        this.regNumEnd = regNumEnd;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getTerOgranCode() {
        return terOgranCode;
    }

    public void setTerOgranCode(String terOgranCode) {
        this.terOgranCode = terOgranCode;
    }

    public String getBaseDepartmentCode() {
        return baseDepartmentCode;
    }

    public void setBaseDepartmentCode(String baseDepartmentCode) {
        this.baseDepartmentCode = baseDepartmentCode;
    }
}

package com.estylesoft.integration.Model.Ptks;

import com.estylesoft.integration.Model.ModelBase;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 13:39
 * To change this template use File | Settings | File Templates.
 */
public class OpfrModel extends ModelBase {

    private String code;
    private Long federalOkrugId;
    private String federalOkrugCode;
    private String name;
    private String fullName;
    private String shortName;
    private String address;
    private Long inn;
    private Long kpp;
    private String phone;
    private Integer isExported;
    private Date defectFbsDate;
    private Integer isCurrent;

    public Integer getCurrent() {
        return isCurrent;
    }

    public void setCurrent(Integer current) {
        isCurrent = current;
    }

    public Integer getExported() {
        return isExported;
    }

    public void setExported(Integer exported) {
        isExported = exported;
    }

    public Date getDefectFbsDate() {
        return defectFbsDate;
    }

    public void setDefectFbsDate(Date defectFbsDate) {
        this.defectFbsDate = defectFbsDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getFederalOkrugId() {
        return federalOkrugId;
    }

    public void setFederalOkrugId(Long federalOkrugId) {
        this.federalOkrugId = federalOkrugId;
    }

    public String getFederalOkrugCode() {
        return federalOkrugCode;
    }

    public void setFederalOkrugCode(String federalOkrugCode) {
        this.federalOkrugCode = federalOkrugCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }

    public Long getKpp() {
        return kpp;
    }

    public void setKpp(Long kpp) {
        this.kpp = kpp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

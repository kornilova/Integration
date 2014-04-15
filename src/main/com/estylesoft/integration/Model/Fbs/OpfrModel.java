package com.estylesoft.integration.Model.Fbs;

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
    private String inn;
    private String kpp;
    private String phone;

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

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

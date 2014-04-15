package com.estylesoft.integration.Model.Ptks;

import com.estylesoft.integration.Model.ModelBase;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 31.01.14
 * Time: 17:40
 * To change this template use File | Settings | File Templates.
 */
/*STH_TERRITORIAL_ORGAN
Территориальный орган*/
public class TerOrganModel extends ModelBase {

    private String code;
    private String name;
    private Long opfrId;
    private String opfrCode;
    private Integer isOpfrCurrent;
    private String shortName;
    private String companyName;
    private String address;
    private String headName;
    private String phone;
    private Long okato;
    private Long inn;
    private Long kpp;
    private Long ogrn;
    private String comment;

    private Integer isExported;
    private Date defectFbsDate;
    private Integer isCurrent;

    public Integer getOpfrCurrent() {
        return isOpfrCurrent;
    }

    public void setOpfrCurrent(Integer opfrCurrent) {
        isOpfrCurrent = opfrCurrent;
    }

    public Integer getCurrent() {
        return isCurrent;
    }

    public void setCurrent(Integer current) {
        isCurrent = current;
    }

    public Date getDefectFbsDate() {
        return defectFbsDate;
    }

    public void setDefectFbsDate(Date defectFbsDate) {
        this.defectFbsDate = defectFbsDate;
    }

    public Integer getExported() {
        return isExported;
    }

    public void setExported(Integer exported) {
        isExported = exported;
    }

    public Long getOpfrId() {
        return opfrId;
    }

    public void setOpfrId(Long opfrId) {
        this.opfrId = opfrId;
    }

    public String getOpfrCode() {
        return opfrCode;
    }

    public void setOpfrCode(String opfrCode) {
        this.opfrCode = opfrCode;
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHeadName() {
        return headName;
    }

    public void setHeadName(String headName) {
        this.headName = headName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getOkato() {
        return okato;
    }

    public void setOkato(Long okato) {
        this.okato = okato;
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

    public Long getOgrn() {
        return ogrn;
    }

    public void setOgrn(Long ogrn) {
        this.ogrn = ogrn;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

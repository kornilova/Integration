package com.estylesoft.integration.Model.Ptks.Dictionary;

import com.estylesoft.integration.Model.ModelBase;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 02.04.14
 * Time: 14:27
 * To change this template use File | Settings | File Templates.
 */
public class KbkModel extends ModelBase {

    private String code;
    private String fullName;
    private String shortName;
    private String typeName;
    private String adminName;
    private Integer startYear;
    private Integer endYear;
    private Integer exported;
    private Long kbkAdmin;
    private Long kbkTypeId;

    private Integer isActualFbs;

    public Integer getActualFbs() {
        return isActualFbs;
    }

    public void setActualFbs(Integer actualFbs) {
        isActualFbs = actualFbs;
    }

    public Long getKbkTypeId() {
        return kbkTypeId;
    }

    public void setKbkTypeId(Long kbkTypeId) {
        this.kbkTypeId = kbkTypeId;
    }

    public Long getKbkAdmin() {
        return kbkAdmin;
    }

    public void setKbkAdmin(Long kbkAdmin) {
        this.kbkAdmin = kbkAdmin;
    }

    public Integer getExported() {
        return exported;
    }

    public void setExported(Integer exported) {
        this.exported = exported;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }
}

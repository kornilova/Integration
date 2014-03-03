package com.estylesoft.integration.Model.Ptks;

import com.estylesoft.integration.Model.ModelBase;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 13:39
 * To change this template use File | Settings | File Templates.
 */
public class OkatoModel extends ModelBase {

    private String code;
    private String terDepartmentCode;
    private String baseDepartmentCode;
    private Long baseDepartmentId;

    public Long getBaseDepartmentId() {
        return baseDepartmentId;
    }

    public void setBaseDepartmentId(Long baseDepartmentId) {
        this.baseDepartmentId = baseDepartmentId;
    }

    public String getTerDepartmentCode() {
        return terDepartmentCode;
    }

    public void setTerDepartmentCode(String terDepartmentCode) {
        this.terDepartmentCode = terDepartmentCode;
    }

    public String getBaseDepartmentCode() {
        return baseDepartmentCode;
    }

    public void setBaseDepartmentCode(String baseDepartmentCode) {
        this.baseDepartmentCode = baseDepartmentCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

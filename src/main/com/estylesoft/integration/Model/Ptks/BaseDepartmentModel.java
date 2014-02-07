package com.estylesoft.integration.Model.Ptks;

import com.estylesoft.integration.Model.ModelBase;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 28.01.14
 * Time: 18:41
 * To change this template use File | Settings | File Templates.
 */
/*STH_REG_DIV_PFR
Базовое отделение*/
public class BaseDepartmentModel extends ModelBase {

    private String code;
    private String name;
    private Long opfrId;

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

    public Long getOpfrId() {
        return opfrId;
    }

    public void setOpfrId(Long opfrId) {
        this.opfrId = opfrId;
    }
}

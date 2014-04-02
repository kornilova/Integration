package com.estylesoft.integration.Model.Ptks.Dictionary;

import com.estylesoft.integration.Model.ModelBase;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 13:39
 * To change this template use File | Settings | File Templates.
 */
public class FederalOkrugModel extends ModelBase {

    private String code;
    private String name;
    private Integer isActualFbs;

    public Integer getActualFbs() {
        return isActualFbs;
    }

    public void setActualFbs(Integer actualFbs) {
        isActualFbs = actualFbs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

package com.estylesoft.integration.Model.Ptks;

import com.estylesoft.integration.Model.ModelBase;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 13:39
 * To change this template use File | Settings | File Templates.
 */
public class RegionModel extends ModelBase {

    private String code;
    private String name;
    private String kladrCode;
    private Integer isCity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKladrCode() {
        return kladrCode;
    }

    public void setKladrCode(String kladrCode) {
        this.kladrCode = kladrCode;
    }

    public Integer getCity() {
        return isCity;
    }

    public void setCity(Integer city) {
        isCity = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

package com.estylesoft.integration.Model.Ptks;

import com.estylesoft.integration.Model.ModelBase;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 11.02.14
 * Time: 11:21
 * To change this template use File | Settings | File Templates.
 */
public class RegistrationKindModel extends ModelBase {

    private String code;
    private String name;
    private Integer isPerson;

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

    public Integer getPerson() {
        return isPerson;
    }

    public void setPerson(Integer person) {
        isPerson = person;
    }
}

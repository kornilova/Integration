package com.estylesoft.integration.Model.Ptks.Dictionary;

import com.estylesoft.integration.Model.ModelBase;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 02.04.14
 * Time: 14:27
 * To change this template use File | Settings | File Templates.
 */
public class InsurerTypeModel extends ModelBase {

    private String name;
    private Integer isPerson;
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

    public Integer getPerson() {
        return isPerson;
    }

    public void setPerson(Integer person) {
        isPerson = person;
    }
}

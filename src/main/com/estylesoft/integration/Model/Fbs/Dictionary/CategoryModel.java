package com.estylesoft.integration.Model.Fbs.Dictionary;

import com.estylesoft.integration.Model.ModelBase;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 02.04.14
 * Time: 14:27
 * To change this template use File | Settings | File Templates.
 */
public class CategoryModel extends ModelBase {

    private String code;
    private String name;
    private Integer oneWindow;
    private Integer employer;
    private Integer foms;
    private Integer isPfr;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPfr() {
        return isPfr;
    }

    public void setPfr(Integer pfr) {
        isPfr = pfr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOneWindow() {
        return oneWindow;
    }

    public void setOneWindow(Integer oneWindow) {
        this.oneWindow = oneWindow;
    }

    public Integer getEmployer() {
        return employer;
    }

    public void setEmployer(Integer employer) {
        this.employer = employer;
    }

    public Integer getFoms() {
        return foms;
    }

    public void setFoms(Integer foms) {
        this.foms = foms;
    }
}

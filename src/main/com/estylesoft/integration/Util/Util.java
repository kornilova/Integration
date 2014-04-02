package com.estylesoft.integration.Util;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 02.04.14
 * Time: 17:34
 * To change this template use File | Settings | File Templates.
 */
public class Util {


    public static String deleteZeroInCode(String value)
    {
        return  (value.length() == 2 && value.matches("[0]{1}[\\d]{1}"))? value.substring(1, value.length()):value;
    }
}

package com.estylesoft.integration.Util;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 02.04.14
 * Time: 17:34
 * To change this template use File | Settings | File Templates.
 */
public class Util {
    public static String deleteZeroInCode(String value) {

        if(value == null) return null;

        int j = -1;
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c == '0') {
                j = i;
            } else {
                break;
            }
        }

        return value.substring(j+1, value.length());
    }

    public static Boolean isEqualsObject(Object obj1, Object obj2)
    {
       return  obj1!= null && obj1.equals(obj2) || obj1 == null && obj2 == null;
    }

    public static Boolean isEqualsInsensitiveCaseTrimString(String str1, String str2)
    {
       return str1!= null && str2!=null && String.CASE_INSENSITIVE_ORDER.compare(str1.trim(), str2.trim()) == 0
               || str1 == null && str2 == null;
    }
}

package com.estylesoft.integration.Database;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 30.10.13
 * Time: 13:10
 * To change this template use File | Settings | File Templates.
 */
public class Column {
        private String name;
        public String dataType;
        public int length;
        public int isNull;
        public int precision;
        public int scale;

    public Column(String name)
    {
       this.name=name;
    }

    public String getName()
    {
        return name;
    }
}

package com.estylesoft.integration.Database;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 30.10.13
 * Time: 13:10
 * To change this template use File | Settings | File Templates.
 */
public class Table {
    private String name;
    private int columnCount;
    public int recordCount;
    private List<Column> listColumns;
    public List<List<String>> listRows;

    public Table(String name)
    {
        this.name = name;
        listColumns = new ArrayList<Column>();
        listRows = new ArrayList<List<String>>();
    }

    public String getName()
    {
        return name;
    }

    public void addColumn(Column column)
    {
        listColumns.add(column);
    }

    public List<Column> getColumns()
    {
        return listColumns;
    }

    public void deleteColumn(Column column)
    {
        if(listColumns.contains(column)) listColumns.remove(column);
    }

    public void setRecordCount(int count)
    {
        columnCount = count;
    }

    public int getRecordCount()
    {
        return recordCount;
    }

    public Column getColumnByName(String name)
    {
        for(Column col: listColumns)
        {
            if(col.getName().equals(name)) return col;
        }
        return null;
    }

    public Column getColumnByIndex(int index)
    {
       return listColumns.get(index);
    }

    public void addRow(List<String> row)
    {
        listRows.add(row);
    }

}

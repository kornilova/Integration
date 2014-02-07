package com.estylesoft.integration.DataLoader;

import com.aspose.cells.*;
import com.estylesoft.integration.Model.ModelBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 30.01.14
 * Time: 12:27
 * To change this template use File | Settings | File Templates.
 */
public class ExcelHelper<T extends ModelBase> {

    private String fileName;
    private String tabName;
    private String testDataDir;
    private String testTableName;

    private final String TEST_TABLE_PREFIX_NAME = "TEST:";
    private final String TEST_TABLE_PREFIX_ID = "TD";
    private final String XLS_NULL_MARKER = "NULL";
    private final String XLS_EMPTY_MARKER = "\"\"";

    private FindOptions stFindOptions;
    private int countDataRows;
    private int countDataColumns;
    private int firstIndexDataRow;
    private int firstIndexDataColumn;

    private Cells workSheetCells;

    public ExcelHelper(String testDataDir, String fileName, String tabName, String testTableName) {
        this.testDataDir = testDataDir;
        this.fileName = fileName;
        this.tabName = tabName;
        this.testTableName = TEST_TABLE_PREFIX_NAME + testTableName;
        stFindOptions = new FindOptions();
        stFindOptions.setLookInType(LookInType.VALUES);
        stFindOptions.setLookAtType(LookAtType.START_WITH);

    }

    public <T extends ModelBase> List<T> getDataFromTestTable(Class<T> tClass) throws Exception {
        getWorkSheet();
        return getModelData(tClass);
    }

    private void getWorkSheet() throws Exception {
        LoadOptions loadOptions = new LoadOptions(FileFormatType.EXCEL_97_TO_2003);
        Workbook wb = new Workbook(testDataDir + fileName, loadOptions);
        this.workSheetCells = wb.getWorksheets().get(tabName).getCells();
    }

    private Cell getTestHeaderCell(Cells cells) {

        return cells.find(testTableName, null, stFindOptions);
    }

    private String[] convertToStringArray(Object[] objects) {
        String[] res = new String[objects.length];
        for (int i = 0; i < objects.length; i++) {
            res[i] = "" + objects[i];
        }
        return res;
    }

    private String[] getHeaderRow() {
        Object[] objects = workSheetCells.exportArray(firstIndexDataRow - 1, firstIndexDataColumn, 1, countDataColumns)[0];
        return convertToStringArray(objects);
    }

    private void setFirstIndexDataColumn(Cell cell) {
        this.firstIndexDataColumn = cell.getColumn();
    }

    private void setCountDataColumns() {
        this.countDataColumns = workSheetCells.getRows().get(firstIndexDataRow).getLastCell().getColumn() + 1;
    }

    private void setFirstIndexDataRow(Cell cell) {
        this.firstIndexDataRow = cell.getRow() + 2;
    }


    private void setCountTetDataRows() {
        countDataRows = 0;
        Cell nextCell = workSheetCells.get(firstIndexDataRow - 1, firstIndexDataColumn);
        while ((nextCell = workSheetCells.find(TEST_TABLE_PREFIX_ID, nextCell, stFindOptions)) != null &&
                (countDataRows + firstIndexDataRow == nextCell.getRow())) {
            countDataRows++;
        }
    }

    private String convertEmptyCellValues(String str) {
        if (str.toUpperCase().equals(XLS_NULL_MARKER)) {
            return null;
        } else if (str.equals(XLS_EMPTY_MARKER)) {
            return "";
        } else return str;
    }

    private String[][] convertToArrayOfStringArray(Object[][] objects) {
        String[][] result = new String[objects.length][];
        for (int i = 0; i < objects.length; i++) {
            result[i] = convertToStringArray(objects[i]);
        }
        return result;
    }

    private String[][] getDataRows() {
        Object objects[][] = workSheetCells.exportArray(firstIndexDataRow, firstIndexDataColumn, countDataRows, countDataColumns);
        return convertToArrayOfStringArray(objects);

    }

    private <T extends ModelBase> List<T> getDataListFromTable(String[] fieldNames, String[][] fieldValues, Class<T> tClass) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        List<T> result = new ArrayList<T>();
        Map<String, String> fieldData = new HashMap<String, String>();
        for (int iValue = 0; iValue < fieldValues.length; iValue++) {
            for (int iName = 0; iName < fieldNames.length; iName++) {
                fieldData.put(fieldNames[iName], convertEmptyCellValues(fieldValues[iValue][iName]));
            }
            T obj = tClass.newInstance();
            obj.setFields(fieldData);
            result.add(obj);
            fieldData.clear();
        }
        return result;
    }

    private <T extends ModelBase> List<T> getModelData(Class<T> tClass) throws Exception {
        Cell headerCell = getTestHeaderCell(workSheetCells);
        setFirstIndexDataColumn(headerCell);
        setFirstIndexDataRow(headerCell);
        setCountDataColumns();
        setCountTetDataRows();
        String[] headerRow = getHeaderRow();
        String[][] dataRows = getDataRows();
        return getDataListFromTable(headerRow, dataRows, tClass);
    }
}

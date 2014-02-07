package com.estylesoft.integration.test;

import Util.DataProviderHelper;
import com.estylesoft.integration.DataLoader.ExcelHelper;
import com.estylesoft.integration.Model.ModelBase;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 30.01.14
 * Time: 12:02
 * To change this template use File | Settings | File Templates.
 */
public class TestBase {

    private static String TEST_DATA_DIR="D:\\FBS-2\\trunk\\Testing\\Test Data\\";

    protected static<T extends ModelBase> List<Object[]> wrapDataListFromProvider(List<T> dataList) {
        List<Object[]> result = new ArrayList<Object[]>();
        for (T loadData : dataList){
            result.add(new Object[]{loadData});
        }
        return result;
    }

    @DataProvider
    public static Iterator<Object[]> getDataFromExcel(Method method) throws Exception {
        Map<String, String> params = DataProviderHelper.getDataProviderParams(method);
        if(params ==null || params.isEmpty()
                || !params.containsKey("fileName")
                || !params.containsKey("tabName")
                || !params.containsKey("testTableName")
                || !params.containsKey("class")
                ) throw new IllegalArgumentException("There are not all arguments to get data from Excel file.");
        ExcelHelper excelHelper = new ExcelHelper(TEST_DATA_DIR,params.get("fileName"), params.get("tabName"),params.get("testTableName"));

        return wrapDataListFromProvider(
                excelHelper.getDataFromTestTable(Class.forName("com.estylesoft.integration.Model.Ptks." + params.get("class")))
        ).iterator();
    }

  }

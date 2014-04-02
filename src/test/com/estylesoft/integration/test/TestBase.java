package com.estylesoft.integration.test;

import Util.DataProviderHelper;
import com.estylesoft.integration.DataLoader.ExcelHelper;
import com.estylesoft.integration.Model.ModelBase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 30.01.14
 * Time: 12:02
 * To change this template use File | Settings | File Templates.
 */
public class TestBase {

    private static SqlSessionFactory sqlSessionFactoryPtks;
    private static SqlSessionFactory sqlSessionFactoryFbs;

    public SqlSessionFactory getSqlConnectionPtks() throws IOException {
        if(sqlSessionFactoryPtks==null)
        {
        Reader reader = Resources.getResourceAsReader("mybatis/mybatis.xml");

        Properties props = new Properties();
        props.setProperty("resource", "mybatis/databasePtks.properties");

            sqlSessionFactoryPtks =  new SqlSessionFactoryBuilder().build(reader, props);}
        return  sqlSessionFactoryPtks;
    }

    public SqlSessionFactory getSqlConnectionFbs() throws IOException {
        if(sqlSessionFactoryFbs==null)
        {
            Reader reader = Resources.getResourceAsReader("mybatis/mybatis.xml");

            Properties props = new Properties();
            props.setProperty("resource", "mybatis/databaseFbs.properties");

            sqlSessionFactoryFbs =  new SqlSessionFactoryBuilder().build(reader, props);}
        return  sqlSessionFactoryFbs;
    }

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
                || !params.containsKey("source")
                ) throw new IllegalArgumentException("There are not all arguments to get data from Excel file.");
        ExcelHelper excelHelper = new ExcelHelper(TEST_DATA_DIR,params.get("fileName"), params.get("tabName"),params.get("testTableName"));

        return wrapDataListFromProvider(
                excelHelper.getDataFromTestTable(Class.forName("com.estylesoft.integration.Model." + params.get("source") + "." + params.get("class")))
        ).iterator();
    }

  }

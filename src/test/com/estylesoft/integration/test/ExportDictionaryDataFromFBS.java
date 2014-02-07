package com.estylesoft.integration.test;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.DB2Connection;
import com.estylesoft.integration.Database.mybatis.DictionaryFbsDAO;
import com.estylesoft.integration.Database.mybatis.DictionaryPtksDAO;
import com.estylesoft.integration.Exchange.CompareDictionaryDataFromFBS;
import com.estylesoft.integration.IntegrationException;
import org.testng.annotations.*;

import java.sql.Connection;
import java.sql.SQLException;

import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 30.10.13
 * Time: 11:59
 * To change this template use File | Settings | File Templates.
 */
public class ExportDictionaryDataFromFBS {

    CompareDictionaryDataFromFBS compare;

    @BeforeSuite
    public void BeforeSuiteCheck() throws SQLException, ClassNotFoundException {
        compare = new CompareDictionaryDataFromFBS();
    }

    @BeforeTest
    public void BeforeCheck()
    {

    }

    @Test(description = "КБК")
    public void CheckImportDictionaryKBK() throws SQLException, IntegrationException {

       CheckResult res = compare.compareActualKbk();
       assertTrue(res.getIsSuccess(), res.getMessageTest());

    }

    @Test(description = "Типы плательщика")
    public void CheckImportDictionaryInsurerType() throws SQLException, IntegrationException {



    }

    @Test(description = "Коды постановки на учёт плательщика")
    public void CheckImportDictionaryStartInsurer() throws SQLException, IntegrationException {



    }

    @Test(description = "Категории плательщика")
    public void CheckImportDictionaryInsurerCategory() throws SQLException, IntegrationException {



    }

    @Test(description = "Федеральные округа")
    public void CheckImportDictionaryFederalOkrug() throws SQLException, IntegrationException {



    }

    @Test(description = "Коды снятия с учета плательщика")
    public void CheckImportDictionaryFinishInsurer() throws SQLException, IntegrationException {



    }

    @Test(description = "Статусы плательщика")
    public void CheckImportDictionaryInsurerStatus() throws SQLException, IntegrationException {



    }


    @AfterTest
    public void AfterCheck()
    {

    }

    @AfterSuite
    public void AfterSuiteCheck() throws SQLException {

    }
}

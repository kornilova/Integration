package com.estylesoft.integration.test.Fbs;

import Util.DataProviderParams;
import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Exchange.Fbs.Dictionary.*;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Fbs.Dictionary.*;
import com.estylesoft.integration.test.TestBase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Properties;

import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 02.04.14
 * Time: 13:43
 * To change this template use File | Settings | File Templates.
 */
public class CreateExportedDictionaryInFbs extends TestBase {

    private static SqlSessionFactory sqlSessionFactory;

    private final String fileName="Integration\\TableData_Integration.xls";
    private final String tabName="ACTUAL_DICTIONARY";
    private FederalOkrugHelper federalOkrugHelper;
    private RegistrationStartHelper registrationStartHelper;
    private RegistrationFinishHelper registrationFinishHelper;
    private KbkHelper kbkHelper;
    private CategoryHelper categoryHelper;
    private InsurerTypeHelper insurerTypeHelper;

    @BeforeSuite
    public void BeforeSuite() throws IOException {

        Reader reader = Resources.getResourceAsReader("mybatis/mybatis.xml");

        Properties props = new Properties();
        props.setProperty("resource", "mybatis/databaseFbs.properties");

        sqlSessionFactory =  new SqlSessionFactoryBuilder().build(reader, props);

        federalOkrugHelper = new FederalOkrugHelper(sqlSessionFactory);
        registrationStartHelper = new RegistrationStartHelper(sqlSessionFactory);
        registrationFinishHelper = new RegistrationFinishHelper(sqlSessionFactory);
        kbkHelper = new KbkHelper(sqlSessionFactory);
        categoryHelper = new CategoryHelper(sqlSessionFactory);
        insurerTypeHelper = new InsurerTypeHelper(sqlSessionFactory);
    }

    @Test(description = "Создать Федеральный округ",dataProvider = "getDataFromExcel")
    @DataProviderParams("source=" + "Fbs.Dictionary" + ";fileName="+ fileName +";tabName="+ tabName +";class="+"FederalOkrugModel"+";testTableName="+ "CreateDictionaryDataInFbs.CreateFederalOkrug")
    public void CreateFederalOkrug(FederalOkrugModel fo) throws SQLException, IntegrationException {
        CheckResult res = federalOkrugHelper.create(fo);
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }

    @Test(description = "Создать Признак постановки на учет",dataProvider = "getDataFromExcel")
    @DataProviderParams("source=" + "Fbs.Dictionary" + ";fileName="+ fileName +";tabName="+ tabName +";class="+"RegistrationStartModel"+";testTableName="+ "CreateDictionaryDataInFbs.CreateRegistrationStart")
    public void CreateRegistrationStart(RegistrationStartModel regStart) throws SQLException, IntegrationException {
        CheckResult res = registrationStartHelper.create(regStart);
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }

    @Test(description = "Создать Признак сняия с учета",dataProvider = "getDataFromExcel")
    @DataProviderParams("source=" + "Fbs.Dictionary" + ";fileName="+ fileName +";tabName="+ tabName +";class="+"RegistrationFinishModel"+";testTableName="+ "CreateDictionaryDataInFbs.CreateRegistrationFinish")
    public void CreateRegistrationFinish(RegistrationFinishModel regFinish) throws SQLException, IntegrationException {
        CheckResult res = registrationFinishHelper.create(regFinish);
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }

    @Test(description = "Создать Код бюджетной классификации",dataProvider = "getDataFromExcel")
    @DataProviderParams("source=" + "Fbs.Dictionary" + ";fileName="+ fileName +";tabName="+ tabName +";class="+"KbkModel"+";testTableName="+ "CreateDictionaryDataInFbs.CreateKbk")
    public void CreateKbk(KbkModel kbk) throws SQLException, IntegrationException {
        CheckResult res = kbkHelper.create(kbk);
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }

    @Test(description = "Создать Категории плательщика",dataProvider = "getDataFromExcel")
    @DataProviderParams("source=" + "Fbs.Dictionary" + ";fileName="+ fileName +";tabName="+ tabName +";class="+"CategoryModel"+";testTableName="+ "CreateDictionaryDataInFbs.CreateCategory")
    public void CreateCategory(CategoryModel category) throws SQLException, IntegrationException {
        CheckResult res = categoryHelper.create(category);
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }

    @Test(description = "Создать Тип плательщика",dataProvider = "getDataFromExcel")
    @DataProviderParams("source=" + "Fbs.Dictionary" + ";fileName="+ fileName +";tabName="+ tabName +";class="+"InsurerTypeModel"+";testTableName="+ "CreateDictionaryDataInFbs.CreateInsurerType")
    public void CreateInsurerType(InsurerTypeModel insurerType) throws SQLException, IntegrationException {
        CheckResult res = insurerTypeHelper.create(insurerType);
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }
}

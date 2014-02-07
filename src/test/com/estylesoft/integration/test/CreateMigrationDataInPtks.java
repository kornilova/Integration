package com.estylesoft.integration.test;

import Util.DataProviderParams;
import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Database.mybatis.Ptks.BaseDepartmentDAO;
import com.estylesoft.integration.Database.mybatis.Ptks.TerOrganDAO;
import com.estylesoft.integration.Exchange.BaseDepartmentHelper;
import com.estylesoft.integration.Exchange.TerOrganHelper;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.BaseDepartmentModel;
import com.estylesoft.integration.Model.Ptks.TerOrganModel;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.TestNGAntTask;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Properties;

import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 29.01.14
 * Time: 0:57
 * To change this template use File | Settings | File Templates.
 */
public class CreateMigrationDataInPtks extends TestBase {

    private static SqlSessionFactory sqlSessionFactory;
    private static BaseDepartmentDAO boDAO;
    private static TerOrganDAO terOrganDAO;
    private BaseDepartmentHelper boHelper;
    private TerOrganHelper terOrganHelper;

    private final String fileName="Integration\\TableData_Integration.xls";
    private final String tabName="CREATE_TEST_DATA";

    @BeforeSuite
    public void BeforeSuite() throws IOException {

        Reader reader = Resources.getResourceAsReader("mybatis/mybatis.xml");

        Properties props = new Properties();
        props.setProperty("resource", "mybatis/databasePtks.properties");

        sqlSessionFactory =  new SqlSessionFactoryBuilder().build(reader, props);

        boDAO = new BaseDepartmentDAO(BaseDepartmentModel.class,sqlSessionFactory);
        boHelper = new BaseDepartmentHelper(boDAO);

        terOrganDAO = new TerOrganDAO(TerOrganModel.class,sqlSessionFactory);
        terOrganHelper = new TerOrganHelper(terOrganDAO);
    }

    @Test(description = "Создать Базовое отделение",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+"BaseDepartmentModel"+";testTableName="+ "CreateMigrationDataInPtks.CreateBaseDepartment")
    public void CreateBaseDepartment(BaseDepartmentModel bo) throws SQLException, IntegrationException {
        CheckResult res = boHelper.create(bo);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        boHelper.delete(bo);
    }

    @Test(description = "Создать Территориальный орган",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "TerOrganModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateTerOrgan")
    public void CreateTerOrgan(TerOrganModel terOrgan) throws SQLException, IntegrationException {
        CheckResult res = terOrganHelper.create(terOrgan);
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }
}

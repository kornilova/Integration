package com.estylesoft.integration.test;

import Util.DataProviderParams;
import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Exchange.*;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.*;
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
 * Date: 29.01.14
 * Time: 0:57
 * To change this template use File | Settings | File Templates.
 */
public class CreateMigrationDataInPtks extends TestBase {

    private static SqlSessionFactory sqlSessionFactory;

    private BaseDepartmentHelper boHelper;
    private TerOrganHelper terOrganHelper;
    private TerDepartmentPFRHelper terDepartmentPFRHelper;
    private OkatoHelper okatoHelper;
    private OpfHelper opfHelper;
    private OkvedHelper okvedHelper;
    private RegionHelper regionHelper;
    private AdmTerritoryHelper admTerritoryHelper;
    private CityHelper cityHelper;
    private TownHelper townHelper;
    private StreetHelper streetHelper;
    private StreetDepartmentHelper streetDepartmentHelper;
    private StreetHousesHelper streetHousesHelper;
    private RegistrationKindHelper registrationKindHelper;
    private RegistrationDepartmentHelper registrationDepartmentHelper;
    private IfnsHelper ifnsHelper;
    private OpfrHelper opfrHelper;

    private final String fileName="Integration\\TableData_Integration.xls";
    private final String tabName="CREATE_TEST_DATA";

    @BeforeSuite
    public void BeforeSuite() throws IOException {

        Reader reader = Resources.getResourceAsReader("mybatis/mybatis.xml");

        Properties props = new Properties();
        props.setProperty("resource", "mybatis/databasePtks.properties");

        sqlSessionFactory =  new SqlSessionFactoryBuilder().build(reader, props);

        boHelper = new BaseDepartmentHelper(sqlSessionFactory);
        terOrganHelper = new TerOrganHelper(sqlSessionFactory);
        terDepartmentPFRHelper = new TerDepartmentPFRHelper(sqlSessionFactory);
        okatoHelper = new OkatoHelper(sqlSessionFactory);
        opfHelper = new OpfHelper(sqlSessionFactory);
        okvedHelper = new OkvedHelper(sqlSessionFactory);
        regionHelper = new RegionHelper(sqlSessionFactory);
        admTerritoryHelper = new AdmTerritoryHelper(sqlSessionFactory);
        cityHelper = new CityHelper(sqlSessionFactory);
        townHelper = new TownHelper(sqlSessionFactory);
        streetHelper = new StreetHelper(sqlSessionFactory);
        streetDepartmentHelper = new StreetDepartmentHelper(sqlSessionFactory);
        streetHousesHelper = new StreetHousesHelper(sqlSessionFactory);
        registrationKindHelper = new RegistrationKindHelper(sqlSessionFactory);
        registrationDepartmentHelper = new RegistrationDepartmentHelper(sqlSessionFactory);
        ifnsHelper = new IfnsHelper(sqlSessionFactory);
        opfrHelper = new OpfrHelper(sqlSessionFactory);
    }

    @Test(description = "Создать Базовое отделение",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+"BaseDepartmentModel"+";testTableName="+ "CreateMigrationDataInPtks.CreateBaseDepartment")
    public void CreateBaseDepartment(BaseDepartmentModel bo) throws SQLException, IntegrationException {
        bo.setOpfrId(opfrHelper.getByCode(bo.getOpfrCode()).getId());
        CheckResult res = boHelper.create(bo);
        assertTrue(res.getIsSuccess(), res.getMessageTest());
        //boHelper.delete(bo);
    }

    @Test(description = "Создать Территориальный орган",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "TerOrganModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateTerOrgan")
    public void CreateTerOrgan(TerOrganModel terOrgan) throws SQLException, IntegrationException {
        terOrgan.setOpfrId(opfrHelper.getByCode(terOrgan.getOpfrCode()).getId());
        CheckResult res = terOrganHelper.create(terOrgan);
        assertTrue(res.getIsSuccess(), res.getMessageTest());
        //terOrganHelper.delete(terOrgan);
    }

    @Test(description = "Создать Районный орган",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "TerDepartmentPFRModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateTerDepartmentPFR")
    public void CreateTerDepartmentPFR(TerDepartmentPFRModel terDepartment) throws SQLException, IntegrationException {
        terDepartment.setTerOrganId(terOrganHelper.getByCode(terDepartment.getTerOgranCode()).getId());
        terDepartment.setBaseDepartmentId(boHelper.getByCode(terDepartment.getBaseDepartmentCode()).getId());
        CheckResult res = terDepartmentPFRHelper.create(terDepartment);
        assertTrue(res.getIsSuccess(), res.getMessageTest());
        //terDepartmentPFRHelper.delete(terDepartment);
    }

    @Test(description = "Создать ОКАТО",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "OkatoModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateOkato")
    public void CreateOkato(OkatoModel okato) throws SQLException, IntegrationException {
        okato.setBaseDepartmentId(boHelper.getByCode(okato.getBaseDepartmentCode()).getId());
        CheckResult res = okatoHelper.create(okato);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //okatoHelper.delete(okato);
    }

    @Test(description = "Создать ОПФ",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "OpfModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateOpf")
    public void CreateOpf(OpfModel opf) throws SQLException, IntegrationException {
        CheckResult res = opfHelper.create(opf);
        assertTrue(res.getIsSuccess(), res.getMessageTest());
        //opfHelper.delete(opf);
    }

    @Test(description = "Создать ОКВЭД",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "OkvedModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateOkved")
    public void CreateOkved(OkvedModel okved) throws SQLException, IntegrationException {
        CheckResult res = okvedHelper.create(okved);
        assertTrue(res.getIsSuccess(), res.getMessageTest());
        //okvedHelper.delete(okved);
    }

    @Test(description = "Создать КЛАДР.Субъект РФ",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "RegionModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateRegion")
    public void CreateKladrRegion(RegionModel region) throws SQLException, IntegrationException {
        CheckResult res = regionHelper.create(region);
        assertTrue(res.getIsSuccess(), res.getMessageTest());
        //regionHelper.delete(region);
    }

    @Test(description = "Создать КЛАДР.Административный район",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "AdmTerritoryModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateAdmTerritory")
    public void CreateKladrAdmTerritory(AdmTerritoryModel admTerritory) throws SQLException, IntegrationException {
        admTerritory.setRegionId(regionHelper.getByCode(admTerritory.getRegionCode()).getId());
        admTerritory.setBaseDepartmentId(boHelper.getByCode(admTerritory.getBaseDepartmentCode()).getId());
        admTerritory.setTerDepartmentPFRId(terDepartmentPFRHelper.getByBaseDepCode(admTerritory.getTerDepartmentPFRCode(), admTerritory.getBaseDepartmentId()).getId());

        CheckResult res = admTerritoryHelper.create(admTerritory);
        assertTrue(res.getIsSuccess(), res.getMessageTest());
        //admTerritoryHelper.delete(admTerritory);
    }

    @Test(description = "Создать КЛАДР.Населенный пункт",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "CityModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateCity")
    public void CreateKladrCity(CityModel city) throws SQLException, IntegrationException {
        city.setRegionId(regionHelper.getByCode(city.getRegionCode()).getId());
        city.setBaseDepartmentId(boHelper.getByCode(city.getBaseDepartmentCode()).getId());
        city.setTerDepartmentPFRId(terDepartmentPFRHelper.getByBaseDepCode(city.getTerDepartmentPFRCode(), city.getBaseDepartmentId()).getId());
        city.setAdmTerritoryId(admTerritoryHelper.getByCode(city.getAdmTerritoryCode()).getId());

        CheckResult res = cityHelper.create(city);
        assertTrue(res.getIsSuccess(), res.getMessageTest());
        //cityHelper.delete(city);
    }

    @Test(description = "Создать КЛАДР.Город",dataProvider = "getDataFromExcel")
      @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "TownModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateTown")
      public void CreateKladrTown(TownModel town) throws SQLException, IntegrationException {
        town.setRegionId(regionHelper.getByCode(town.getRegionCode()).getId());
        town.setBaseDepartmentId(boHelper.getByCode(town.getBaseDepartmentCode()).getId());
        town.setTerDepartmentPFRId(terDepartmentPFRHelper.getByBaseDepCode(town.getTerDepartmentPFRCode(), town.getBaseDepartmentId()).getId());
        town.setAdmTerritoryId(admTerritoryHelper.getByCode(town.getAdmTerritoryCode()).getId());
        town.setCityId(cityHelper.getByCode(town.getCityCode()).getId());

        CheckResult res = townHelper.create(town);
        assertTrue(res.getIsSuccess(), res.getMessageTest());
        //townHelper.delete(town);
    }

    @Test(description = "Создать КЛАДР.Улица",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "StreetModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateStreet")
    public void CreateKladrStreet(StreetModel street) throws SQLException, IntegrationException {
        street.setRegionId(regionHelper.getByCode(street.getRegionCode()).getId());
        street.setBaseDepartmentId(boHelper.getByCode(street.getBaseDepartmentCode()).getId());
        street.setAdmTerritoryId(admTerritoryHelper.getByCode(street.getAdmTerritoryCode()).getId());
        street.setCityId(cityHelper.getByCode(street.getCityCode()).getId());
        street.setTownId(townHelper.getByCode(street.getTownCode()).getId());

        CheckResult res = streetHelper.create(street);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //streetHelper.delete(street);

    }

    @Test(description = "Создать КЛАДР.Улица.Список диапазонов",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "StreetDepartmentModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateStreetDepartment")
    public void CreateKladrStreetDepartment(StreetDepartmentModel streetDepartment) throws SQLException, IntegrationException {
        streetDepartment.setStreetId(streetHelper.getByCode(streetDepartment.getStreetCode()).getId());
        streetDepartment.setBaseDepartmentId(boHelper.getByCode(streetDepartment.getBaseDepartmentCode()).getId());
        streetDepartment.setTerDepartmentPFRId(terDepartmentPFRHelper.getByBaseDepCode(streetDepartment.getTerDepartmentPFRCode(), streetDepartment.getBaseDepartmentId()).getId());

        CheckResult res = streetDepartmentHelper.create(streetDepartment);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //streetDepartmentHelper.delete(streetDepartment);
    }

    @Test(description = "Создать КЛАДР.Улица.Список диапазонов.Список домов",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "StreetHousesModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateStreetHouses")
    public void CreateKladrStreetHouses(StreetHousesModel streetHouses) throws SQLException, IntegrationException {
        streetHouses.setStreetTerDepartmentId(
                streetDepartmentHelper.getByStreetIdTerDepId(streetHelper.
                        getByCode(streetHouses.getStreetCode()).getId(),
                        (terDepartmentPFRHelper.getByBaseDepCode(streetHouses.getTerDepartmentPFRCode(),  boHelper.getByCode(streetHouses.getBaseDepartmentCode()).getId())).getId()
                ).getId());

        CheckResult res = streetHousesHelper.create(streetHouses);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //streetHousesHelper.delete(streetHouses);
    }

    @Test(description = "Создать Вид регистрации",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "RegistrationKindModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateRegistrationKind")
    public void CreateRegistrationKind(RegistrationKindModel registrationKind) throws SQLException, IntegrationException {
        //registrationKindHelper.delete(registrationKind);
       CheckResult res = registrationKindHelper.create(registrationKind);
       assertTrue(res.getIsSuccess(), res.getMessageTest());
    }

    @Test(description = "Создать Регистрирующий орган",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "RegistrationDepartmentModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateRegistrationDepartment")
    public void CreateRegistrationDepartment(RegistrationDepartmentModel registrationDepartment) throws SQLException, IntegrationException {
        //registrationDepartmentHelper.delete(registrationDepartment);
        CheckResult res = registrationDepartmentHelper.create(registrationDepartment);
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }

    @Test(description = "Создать ИФНС",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "IfnsModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateIfns")
    public void CreateIfns(IfnsModel ifns) throws SQLException, IntegrationException {
        ifnsHelper.delete(ifns);
        CheckResult res = ifnsHelper.create(ifns);
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }
}

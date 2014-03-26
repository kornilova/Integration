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
    private InsurerHelper insurerHelper;

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
        insurerHelper = new InsurerHelper(sqlSessionFactory);
    }

    @Test(description = "Создать Базовое отделение",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+"BaseDepartmentModel"+";testTableName="+ "CreateMigrationDataInPtks.CreateBaseDepartment")
    public void CreateBaseDepartment(BaseDepartmentModel bo) throws SQLException, IntegrationException {
        bo.setOpfr(opfrHelper.getByCode(bo.getOpfrCode()));
        CheckResult res = boHelper.create(bo);
        assertTrue(res.getIsSuccess(), res.getMessageTest());
        //boHelper.delete(bo);
    }

    @Test(description = "Создать Территориальный орган",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "TerOrganModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateTerOrgan")
    public void CreateTerOrgan(TerOrganModel terOrgan) throws SQLException, IntegrationException {
        terOrgan.setOpfr(opfrHelper.getByCode(terOrgan.getOpfrCode()));
        CheckResult res = terOrganHelper.create(terOrgan);
        assertTrue(res.getIsSuccess(), res.getMessageTest());
        //terOrganHelper.delete(terOrgan);
    }

    @Test(description = "Создать Районный орган",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "TerDepartmentPFRModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateTerDepartmentPFR")
    public void CreateTerDepartmentPFR(TerDepartmentPFRModel terDepartment) throws SQLException, IntegrationException {
        terDepartment.setTerOrgan(terOrganHelper.getByCodeOpfr(   terDepartment.getTerOrganCode(),
                                                opfrHelper.getByCode(terDepartment.getOpfrCode()).getId()));
        terDepartment.setBaseDepartment(boHelper.getByCode(terDepartment.getBaseDepartmentCode()));
        CheckResult res = terDepartmentPFRHelper.create(terDepartment);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //terDepartmentPFRHelper.delete(terDepartment);
    }

    @Test(description = "Создать ОКАТО",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "OkatoModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateOkato")
    public void CreateOkato(OkatoModel okato) throws SQLException, IntegrationException {
        okato.setTerDepartmentPFR(terDepartmentPFRHelper.getByCodeBaseDepTerOrgan(
                okato.getTerDepartmentPFRCode(),
                boHelper.getByCode(okato.getBaseDepartmentCode()).getId(),
                terOrganHelper.getByCodeOpfr(okato.getTerOrganCode(),
                        opfrHelper.getByCode(okato.getOpfrCode()).getId()).getId()));

        okato.setBaseDepartment(boHelper.getByCode(okato.getBaseDepartmentCode()));

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
        admTerritory.setOpfr(opfrHelper.getByCode(admTerritory.getOpfrCode()));
        admTerritory.setBaseDepartment(boHelper.getByCode(admTerritory.getBaseDepartmentCode()));
        admTerritory.setRegion(regionHelper.getByCode(admTerritory.getRegionCode()));
        admTerritory.setTerOrgan(terOrganHelper.getByCodeOpfr(admTerritory.getTerOrganCode(), admTerritory.getOpfr().getId()));
        admTerritory.setTerDepartmentPFR(
                terDepartmentPFRHelper.getByCodeBaseDepTerOrgan(
                        admTerritory.getTerDepartmentPFRCode(),
                        admTerritory.getBaseDepartment().getId(),
                        admTerritory.getTerOrgan().getId()
                        ));

        CheckResult res = admTerritoryHelper.create(admTerritory);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //admTerritoryHelper.delete(admTerritory);
    }

    @Test(description = "Создать КЛАДР.Населенный пункт",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "CityModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateCity")
    public void CreateKladrCity(CityModel city) throws SQLException, IntegrationException {
        city.setOpfr(opfrHelper.getByCode(city.getOpfrCode()));
        city.setBaseDepartment(boHelper.getByCode(city.getBaseDepartmentCode()));
        city.setRegion(regionHelper.getByCode(city.getRegionCode()));
        city.setTerOrgan(terOrganHelper.getByCodeOpfr(city.getTerOrganCode(), city.getOpfr().getId()));
        city.setTerDepartmentPFR(
                terDepartmentPFRHelper.getByCodeBaseDepTerOrgan(
                        city.getTerDepartmentPFRCode(),
                        city.getBaseDepartment().getId(),
                        city.getTerOrgan().getId()
                ));
        city.setAdmTerritory(admTerritoryHelper.getByCodeRegionIdTerDepIdBaseDepId(
                city.getAdmTerritoryCode(),
                city.getRegion() != null ? city.getRegion().getId() : null,
                city.getTerDepartmentPFR().getId(),
                city.getBaseDepartment().getId()
        ));

        CheckResult res = cityHelper.create(city);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //cityHelper.delete(city);
    }

    @Test(description = "Создать КЛАДР.Город",dataProvider = "getDataFromExcel")
      @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "TownModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateTown")
      public void CreateKladrTown(TownModel town) throws SQLException, IntegrationException {
        town.setOpfr(opfrHelper.getByCode(town.getOpfrCode()));
        town.setBaseDepartment(boHelper.getByCode(town.getBaseDepartmentCode()));
        town.setRegion(regionHelper.getByCode(town.getRegionCode()));
        town.setTerOrgan(terOrganHelper.getByCodeOpfr(town.getTerOrganCode(), town.getOpfr().getId()));
        town.setTerDepartmentPFR(
                terDepartmentPFRHelper.getByCodeBaseDepTerOrgan(
                        town.getTerDepartmentPFRCode(),
                        town.getBaseDepartment().getId(),
                        town.getTerOrgan().getId()
                ));
        town.setAdmTerritory(admTerritoryHelper.getByCodeRegionIdTerDepIdBaseDepId(
                town.getAdmTerritoryCode(),
                town.getRegion().getId(),
                town.getTerDepartmentPFR().getId(),
                town.getBaseDepartment().getId()
        ));

        town.setCity(cityHelper.getByCodeAdmTerrIdRegionIdTerDepIdBaseDepId(town.getCityCode(),
                town.getAdmTerritory().getId(),
                town.getRegion().getId(),
                town.getTerDepartmentPFR().getId(),
                town.getBaseDepartment().getId()));

        CheckResult res = townHelper.create(town);
        assertTrue(res.getIsSuccess(), res.getMessageTest());
        //townHelper.delete(town);
    }

    @Test(description = "Создать КЛАДР.Улица",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "StreetModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateStreet")
    public void CreateKladrStreet(StreetModel street) throws SQLException, IntegrationException {
        street.setOpfr(opfrHelper.getByCode(street.getOpfrCode()));
        street.setBaseDepartment(boHelper.getByCode(street.getBaseDepartmentCode()));
        street.setRegion(regionHelper.getByCode(street.getRegionCode()));
        street.setTerOrgan(terOrganHelper.getByCodeOpfr(street.getTerOrganCode(), street.getOpfr().getId()));
        street.setTerDepartmentPFR(
                terDepartmentPFRHelper.getByCodeBaseDepTerOrgan(
                        street.getTerDepartmentPFRCode(),
                        street.getBaseDepartment().getId(),
                        street.getTerOrgan().getId()
                ));
        street.setAdmTerritory(admTerritoryHelper.getByCodeRegionIdTerDepIdBaseDepId(
                street.getAdmTerritoryCode(),
                street.getRegion().getId(),
                street.getTerDepartmentPFR().getId(),
                street.getBaseDepartment().getId()
        ));

        street.setCity(cityHelper.getByCodeAdmTerrIdRegionIdTerDepIdBaseDepId(street.getCityCode(),
                street.getAdmTerritory().getId(),
                street.getRegion().getId(),
                street.getTerDepartmentPFR().getId(),
                street.getBaseDepartment().getId()));

        street.setTown(townHelper.getByCodeCityIdAdmTerritoryIdRegionIdTerDepIdBaseDepId(street.getTownCode(),
                street.getCity().getId(),
                street.getAdmTerritory().getId(),
                street.getRegion().getId(),
                street.getTerDepartmentPFR().getId(),
                street.getBaseDepartment().getId()));

        CheckResult res = streetHelper.create(street);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //streetHelper.delete(street);

    }

    @Test(description = "Создать КЛАДР.Улица.Список диапазонов",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "StreetDepartmentModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateStreetDepartment")
    public void CreateKladrStreetDepartment(StreetDepartmentModel streetDepartment) throws SQLException, IntegrationException {
        streetDepartment.setOpfr(opfrHelper.getByCode(streetDepartment.getOpfrCode()));
        streetDepartment.setBaseDepartment(boHelper.getByCode(streetDepartment.getBaseDepartmentCode()));
        streetDepartment.setRegion(regionHelper.getByCode(streetDepartment.getRegionCode()));
        streetDepartment.setTerOrgan(terOrganHelper.getByCodeOpfr(streetDepartment.getTerOrganCode(), streetDepartment.getOpfr().getId()));
        streetDepartment.setTerDepartmentPFR(
                terDepartmentPFRHelper.getByCodeBaseDepTerOrgan(
                        streetDepartment.getTerDepartmentPFRCode(),
                        streetDepartment.getBaseDepartment().getId(),
                        streetDepartment.getTerOrgan().getId()
                ));
        streetDepartment.setAdmTerritory(admTerritoryHelper.getByCodeRegionIdTerDepIdBaseDepId(
                streetDepartment.getAdmTerritoryCode(),
                streetDepartment.getRegion().getId(),
                streetDepartment.getTerDepartmentPFR().getId(),
                streetDepartment.getBaseDepartment().getId()
        ));

        streetDepartment.setCity(cityHelper.getByCodeAdmTerrIdRegionIdTerDepIdBaseDepId(streetDepartment.getCityCode(),
                streetDepartment.getAdmTerritory().getId(),
                streetDepartment.getRegion().getId(),
                streetDepartment.getTerDepartmentPFR().getId(),
                streetDepartment.getBaseDepartment().getId()));

        streetDepartment.setTown(townHelper.getByCodeCityIdAdmTerritoryIdRegionIdTerDepIdBaseDepId(streetDepartment.getTownCode(),
                streetDepartment.getCity().getId(),
                streetDepartment.getAdmTerritory().getId(),
                streetDepartment.getRegion().getId(),
                streetDepartment.getTerDepartmentPFR().getId(),
                streetDepartment.getBaseDepartment().getId()));

        streetDepartment.setStreet(streetHelper.getByCodeCityIdTownIdAdmTerIdRegionIdBaseDepId(
                streetDepartment.getStreetCode(),
                streetDepartment.getCity().getId(),
                streetDepartment.getTown().getId(),
                streetDepartment.getAdmTerritory().getId(),
                streetDepartment.getRegion().getId(),
                streetDepartment.getBaseDepartment().getId()
        ));

        CheckResult res = streetDepartmentHelper.create(streetDepartment);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //streetDepartmentHelper.delete(streetDepartment);
    }

    @Test(description = "Создать КЛАДР.Улица.Список диапазонов.Список домов",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "StreetHousesModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateStreetHouses")
    public void CreateKladrStreetHouses(StreetHousesModel streetHouses) throws SQLException, IntegrationException {
        streetHouses.setOpfr(opfrHelper.getByCode(streetHouses.getOpfrCode()));
        streetHouses.setBaseDepartment(boHelper.getByCode(streetHouses.getBaseDepartmentCode()));
        streetHouses.setRegion(regionHelper.getByCode(streetHouses.getRegionCode()));
        streetHouses.setTerOrgan(terOrganHelper.getByCodeOpfr(streetHouses.getTerOrganCode(), streetHouses.getOpfr().getId()));
        streetHouses.setTerDepartmentPFR(
                terDepartmentPFRHelper.getByCodeBaseDepTerOrgan(
                        streetHouses.getTerDepartmentPFRCode(),
                        streetHouses.getBaseDepartment().getId(),
                        streetHouses.getTerOrgan().getId()
                ));
        streetHouses.setAdmTerritory(admTerritoryHelper.getByCodeRegionIdTerDepIdBaseDepId(
                streetHouses.getAdmTerritoryCode(),
                streetHouses.getRegion().getId(),
                streetHouses.getTerDepartmentPFR().getId(),
                streetHouses.getBaseDepartment().getId()
        ));

        streetHouses.setCity(cityHelper.getByCodeAdmTerrIdRegionIdTerDepIdBaseDepId(streetHouses.getCityCode(),
                streetHouses.getAdmTerritory().getId(),
                streetHouses.getRegion().getId(),
                streetHouses.getTerDepartmentPFR().getId(),
                streetHouses.getBaseDepartment().getId()));

        streetHouses.setTown(townHelper.getByCodeCityIdAdmTerritoryIdRegionIdTerDepIdBaseDepId(streetHouses.getTownCode(),
                streetHouses.getCity().getId(),
                streetHouses.getAdmTerritory().getId(),
                streetHouses.getRegion().getId(),
                streetHouses.getTerDepartmentPFR().getId(),
                streetHouses.getBaseDepartment().getId()));

        streetHouses.setStreet(streetHelper.getByCodeCityIdTownIdAdmTerIdRegionIdBaseDepId(
                streetHouses.getStreetCode(),
                streetHouses.getCity().getId(),
                streetHouses.getTown().getId(),
                streetHouses.getAdmTerritory().getId(),
                streetHouses.getRegion().getId(),
                streetHouses.getBaseDepartment().getId()
        ));

        streetHouses.setStreetDepartment(streetDepartmentHelper.getByStreetIdTerDepId(
                streetHouses.getStreet().getId(),
                streetHouses.getTerDepartmentPFR().getId()));

        CheckResult res = streetHousesHelper.create(streetHouses);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //streetHousesHelper.delete(streetHouses);
    }

    @Test(description = "Создать Вид регистрации",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "RegistrationKindModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateRegistrationKind")
    public void CreateRegistrationKind(RegistrationKindModel registrationKind) throws SQLException, IntegrationException {

       CheckResult res = registrationKindHelper.create(registrationKind);
       assertTrue(res.getIsSuccess(), res.getMessageTest());
        //registrationKindHelper.delete(registrationKind);
    }

    @Test(description = "Создать Регистрирующий орган",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "RegistrationDepartmentModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateRegistrationDepartment")
    public void CreateRegistrationDepartment(RegistrationDepartmentModel registrationDepartment) throws SQLException, IntegrationException {

        CheckResult res = registrationDepartmentHelper.create(registrationDepartment);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //registrationDepartmentHelper.delete(registrationDepartment);
    }

    @Test(description = "Создать ИФНС",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "IfnsModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateIfns")
    public void CreateIfns(IfnsModel ifns) throws SQLException, IntegrationException {
        CheckResult res = ifnsHelper.create(ifns);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //ifnsHelper.delete(ifns);
    }

    @Test(description = "Создать Плательщика",dataProvider = "getDataFromExcel")
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "InsurerModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateInsurer")
    public void CreateInsurer(InsurerModel insurer) throws SQLException, IntegrationException {

        insurer.setOpfr(opfrHelper.getByCode(insurer.getOpfrCode()));
        insurer.setBaseDepartment(boHelper.getByCode(insurer.getBaseDepartmentCode()));
        insurer.setRegion(regionHelper.getByCode(insurer.getRegionCode()));
        insurer.setTerOrgan(terOrganHelper.getByCodeOpfr(insurer.getTerOrganCode(), insurer.getOpfr().getId()));
        insurer.setTerDepartmentPFR(
                terDepartmentPFRHelper.getByCodeBaseDepTerOrgan(
                        insurer.getTerDepartmentPFRCode(),
                        insurer.getBaseDepartment().getId(),
                        insurer.getTerOrgan().getId()
                ));
        insurer.setAdmTerritory(admTerritoryHelper.getByCodeRegionIdTerDepIdBaseDepId(
                insurer.getAdmTerritoryCode(),
                insurer.getRegion().getId(),
                insurer.getTerDepartmentPFR().getId(),
                insurer.getBaseDepartment().getId()
        ));

        insurer.setCity(cityHelper.getByCodeAdmTerrIdRegionIdTerDepIdBaseDepId(insurer.getCityCode(),
                insurer.getAdmTerritory().getId(),
                insurer.getRegion().getId(),
                insurer.getTerDepartmentPFR().getId(),
                insurer.getBaseDepartment().getId()));

        insurer.setTown(townHelper.getByCodeCityIdAdmTerritoryIdRegionIdTerDepIdBaseDepId(insurer.getTownCode(),
                insurer.getCity().getId(),
                insurer.getAdmTerritory().getId(),
                insurer.getRegion().getId(),
                insurer.getTerDepartmentPFR().getId(),
                insurer.getBaseDepartment().getId()));

        insurer.setStreet(streetHelper.getByCodeCityIdTownIdAdmTerIdRegionIdBaseDepId(
                insurer.getStreetCode(),
                insurer.getCity().getId(),
                insurer.getTown().getId(),
                insurer.getAdmTerritory().getId(),
                insurer.getRegion().getId(),
                insurer.getBaseDepartment().getId()
        ));

        insurer.setIfns(ifnsHelper.getByCode(insurer.getIfnsCode()));
        insurer.setOkved(okvedHelper.getByCode(insurer.getOkvedCode()));
        insurer.setOpf(opfHelper.getByCode(insurer.getOpfCode()));
        insurer.setRegistrationDepartment(registrationDepartmentHelper.getByCode(insurer.getRegistrationDepCode()));

        insurer.setStartRegistrationKind(registrationKindHelper.getByCode(insurer.getStartRegistrationKindCode(), insurer.getStartRegistrationKindIsPerson()));
        insurer.setFinishRegistrationKind(registrationKindHelper.getByCode(insurer.getFinishRegistrationKindCode(), insurer.getFinishRegistrationKindIsPerson()));

        CheckResult res = insurerHelper.create(insurer);
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }
}

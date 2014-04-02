package com.estylesoft.integration.test.Ptks;

import Util.DataProviderParams;
import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Exchange.Ptks.*;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.Model.Ptks.*;
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
    private JournalChangeDataHelper journalChangeDataHelper;

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
        journalChangeDataHelper = new JournalChangeDataHelper(sqlSessionFactory);

    }

    @Test(description = "Создать Базовое отделение",dataProvider = "getDataFromExcel", priority=1)
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+"BaseDepartmentModel"+";testTableName="+ "CreateMigrationDataInPtks.CreateBaseDepartment")
    public void CreateBaseDepartment(BaseDepartmentModel bo) throws SQLException, IntegrationException {
        bo.setOpfrId(opfrHelper.getByCode(bo.getOpfrCode()).getId());
        CheckResult res = boHelper.create(bo);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //Проверить, что изменения отражены в журнале изменений STH_JOURNAL_CHANGE_DATA
        res = journalChangeDataHelper.checkExistChangeData(bo.getId(),
                PtksEnumeration.JournalChangeDataDictionaryType.BASE_DEPARTMENT.getValue(),
                PtksEnumeration.JournalChangeDataOperationType.INSERT.getValue());
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }

    @Test(description = "Создать Территориальный орган",dataProvider = "getDataFromExcel", priority=1)
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "TerOrganModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateTerOrgan")
    public void CreateTerOrgan(TerOrganModel terOrgan) throws SQLException, IntegrationException {
        terOrgan.setOpfrId(opfrHelper.getByCode(terOrgan.getOpfrCode()).getId());
        CheckResult res = terOrganHelper.create(terOrgan);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //Проверить, что изменения отражены в журнале изменений STH_JOURNAL_CHANGE_DATA
        res = journalChangeDataHelper.checkExistChangeData(terOrgan.getId(),
                PtksEnumeration.JournalChangeDataDictionaryType.TER_ORGAN.getValue(),
                PtksEnumeration.JournalChangeDataOperationType.INSERT.getValue());
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }

    @Test(description = "Создать Районный орган",dataProvider = "getDataFromExcel", priority=2)
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "TerDepartmentPFRModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateTerDepartmentPFR")
    public void CreateTerDepartmentPFR(TerDepartmentPFRModel terDepartment) throws SQLException, IntegrationException {
        terDepartment.setOpfrId(opfrHelper.getByCode(terDepartment.getOpfrCode()).getId());
        terDepartment.setTerOrganId(terOrganHelper.getByCodeOpfr(terDepartment.getTerOrganCode(),
                terDepartment.getOpfrId()).getId());
        terDepartment.setBaseDepartmentId(
                boHelper.getByCodeOpfr(
                        terDepartment.getBaseDepartmentCode(), terDepartment.getOpfrId()
                ).getId()
        );

        CheckResult res = terDepartmentPFRHelper.create(terDepartment);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //Проверить, что изменения отражены в журнале изменений STH_JOURNAL_CHANGE_DATA
        res = journalChangeDataHelper.checkExistChangeData(terDepartment.getId(),
                PtksEnumeration.JournalChangeDataDictionaryType.TER_DEPARTMENT_PFR.getValue(),
                PtksEnumeration.JournalChangeDataOperationType.INSERT.getValue());
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }

    @Test(description = "Создать ОКАТО",dataProvider = "getDataFromExcel", priority=3)
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "OkatoModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateOkato")
    public void CreateOkato(OkatoModel okato) throws SQLException, IntegrationException {
        okato.setOpfrId(opfrHelper.getByCode(okato.getOpfrCode()).getId());
        okato.setBaseDepartmentId(boHelper.getByCodeOpfr(okato.getBaseDepartmentCode(), okato.getOpfrId()).getId());
        okato.setTerOrganId(terOrganHelper.getByCodeOpfr(okato.getTerOrganCode(), okato.getOpfrId()).getId());
        okato.setTerDepartmentPFRId(terDepartmentPFRHelper.getByCodeBaseDepTerOrgan(
                okato.getTerDepartmentPFRCode(),
                okato.getBaseDepartmentId(),
                okato.getTerOrganId()).getId());

        CheckResult res = okatoHelper.create(okato);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //Проверить, что изменения отражены в журнале изменений STH_JOURNAL_CHANGE_DATA
        res = journalChangeDataHelper.checkExistChangeData(okato.getId(),
                PtksEnumeration.JournalChangeDataDictionaryType.OKATO.getValue(),
                PtksEnumeration.JournalChangeDataOperationType.INSERT.getValue());
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }

    @Test(description = "Создать ОПФ",dataProvider = "getDataFromExcel", priority=1)
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "OpfModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateOpf")
    public void CreateOpf(OpfModel opf) throws SQLException, IntegrationException {
        CheckResult res = opfHelper.create(opf);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //Проверить, что изменения отражены в журнале изменений STH_JOURNAL_CHANGE_DATA
        res = journalChangeDataHelper.checkExistChangeData(opf.getId(),
                PtksEnumeration.JournalChangeDataDictionaryType.OPF.getValue(),
                PtksEnumeration.JournalChangeDataOperationType.INSERT.getValue());
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }

    @Test(description = "Создать ОКВЭД",dataProvider = "getDataFromExcel", priority=1)
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "OkvedModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateOkved")
    public void CreateOkved(OkvedModel okved) throws SQLException, IntegrationException {
        CheckResult res = okvedHelper.create(okved);

        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //Проверить, что изменения отражены в журнале изменений STH_JOURNAL_CHANGE_DATA
        res = journalChangeDataHelper.checkExistChangeData(okved.getId(),
                PtksEnumeration.JournalChangeDataDictionaryType.OKVED.getValue(),
                PtksEnumeration.JournalChangeDataOperationType.INSERT.getValue());
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }

    @Test(description = "Создать КЛАДР.Субъект РФ",dataProvider = "getDataFromExcel", priority=1)
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "RegionModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateRegion")
    public void CreateKladrRegion(RegionModel region) throws SQLException, IntegrationException {
        CheckResult res = regionHelper.create(region);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //Проверить, что изменения отражены в журнале изменений STH_JOURNAL_CHANGE_DATA
        res = journalChangeDataHelper.checkExistChangeData(region.getId(),
                PtksEnumeration.JournalChangeDataDictionaryType.REGION.getValue(),
                PtksEnumeration.JournalChangeDataOperationType.INSERT.getValue());
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }

    @Test(description = "Создать КЛАДР.Административный район",dataProvider = "getDataFromExcel", priority=4)
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "AdmTerritoryModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateAdmTerritory")
    public void CreateKladrAdmTerritory(AdmTerritoryModel admTerritory) throws SQLException, IntegrationException {
        admTerritory.setOpfrId(opfrHelper.getByCode(admTerritory.getOpfrCode()).getId());
        admTerritory.setBaseDepartmentId(boHelper.getByCodeOpfr(admTerritory.getBaseDepartmentCode(), admTerritory.getOpfrId()).getId());
        admTerritory.setRegionId(regionHelper.getByCode(admTerritory.getRegionCode()).getId());
        admTerritory.setTerOrganId(terOrganHelper.getByCodeOpfr(admTerritory.getTerOrganCode(), admTerritory.getOpfrId()).getId());
        admTerritory.setTerDepartmentPFRId(
                terDepartmentPFRHelper.getByCodeBaseDepTerOrgan(
                        admTerritory.getTerDepartmentPFRCode(),
                        admTerritory.getBaseDepartmentId(),
                        admTerritory.getTerOrganId()
                ).getId());

        CheckResult res = admTerritoryHelper.create(admTerritory);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //Проверить, что изменения отражены в журнале изменений STH_JOURNAL_CHANGE_DATA
        res = journalChangeDataHelper.checkExistChangeData(admTerritory.getId(),
                PtksEnumeration.JournalChangeDataDictionaryType.ADM_TERRITORY.getValue(),
                PtksEnumeration.JournalChangeDataOperationType.INSERT.getValue());
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }

    @Test(description = "Создать КЛАДР.Населенный пункт",dataProvider = "getDataFromExcel", priority=5)
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "CityModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateCity")
    public void CreateKladrCity(CityModel city) throws SQLException, IntegrationException {
        city.setOpfrId(opfrHelper.getByCode(city.getOpfrCode()).getId());
        city.setBaseDepartmentId(boHelper.getByCodeOpfr(city.getBaseDepartmentCode(), city.getOpfrId()).getId());

        RegionModel region = regionHelper.getByCode(city.getRegionCode());
        city.setRegionId(region != null ? region.getId() : null);

        city.setTerOrganId(terOrganHelper.getByCodeOpfr(city.getTerOrganCode(), city.getOpfrId()).getId());
        city.setTerDepartmentPFRId(
                terDepartmentPFRHelper.getByCodeBaseDepTerOrgan(
                        city.getTerDepartmentPFRCode(),
                        city.getBaseDepartmentId(),
                        city.getTerOrganId()
                ).getId());
        AdmTerritoryModel admTerritory =  admTerritoryHelper.getByCodeRegionIdTerDepIdBaseDepId(
                city.getAdmTerritoryCode(),
                city.getRegionId(),
                city.getTerDepartmentPFRId(),
                city.getBaseDepartmentId()
        );
        city.setAdmTerritoryId(admTerritory != null ? admTerritory.getId() : null);

        CheckResult res = cityHelper.create(city);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //Проверить, что изменения отражены в журнале изменений STH_JOURNAL_CHANGE_DATA
        res = journalChangeDataHelper.checkExistChangeData(city.getId(),
                PtksEnumeration.JournalChangeDataDictionaryType.CITY.getValue(),
                PtksEnumeration.JournalChangeDataOperationType.INSERT.getValue());
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }

    @Test(description = "Создать КЛАДР.Город",dataProvider = "getDataFromExcel", priority=6)
      @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "TownModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateTown")
      public void CreateKladrTown(TownModel town) throws SQLException, IntegrationException {
        town.setOpfrId(opfrHelper.getByCode(town.getOpfrCode()).getId());
        town.setBaseDepartmentId(boHelper.getByCodeOpfr(town.getBaseDepartmentCode(), town.getOpfrId()).getId());

        RegionModel region = regionHelper.getByCode(town.getRegionCode());
        town.setRegionId(region!=null?region.getId():null);

        town.setTerOrganId(terOrganHelper.getByCodeOpfr(town.getTerOrganCode(), town.getOpfrId()).getId());
        town.setTerDepartmentPFRId(
                terDepartmentPFRHelper.getByCodeBaseDepTerOrgan(
                        town.getTerDepartmentPFRCode(),
                        town.getBaseDepartmentId(),
                        town.getTerOrganId()
                ).getId());
        AdmTerritoryModel admTerritory =  admTerritoryHelper.getByCodeRegionIdTerDepIdBaseDepId(
                town.getAdmTerritoryCode(),
                town.getRegionId(),
                town.getTerDepartmentPFRId(),
                town.getBaseDepartmentId()
        );
        town.setAdmTerritoryId(admTerritory != null ? admTerritory.getId() : null);

        CityModel city = cityHelper.getByCodeAdmTerrIdRegionIdTerDepIdBaseDepId(town.getCityCode(),
                town.getAdmTerritoryId(),
                town.getRegionId(),
                town.getTerDepartmentPFRId(),
                town.getBaseDepartmentId());
        town.setCityId(city != null ? city.getId() : null);

        CheckResult res = townHelper.create(town);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //Проверить, что изменения отражены в журнале изменений STH_JOURNAL_CHANGE_DATA
        res = journalChangeDataHelper.checkExistChangeData(town.getId(),
                PtksEnumeration.JournalChangeDataDictionaryType.TOWN.getValue(),
                PtksEnumeration.JournalChangeDataOperationType.INSERT.getValue());
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }

    @Test(description = "Создать КЛАДР.Улица",dataProvider = "getDataFromExcel", priority=7)
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "StreetModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateStreet")
    public void CreateKladrStreet(StreetModel street) throws SQLException, IntegrationException {
        street.setOpfrId(opfrHelper.getByCode(street.getOpfrCode()).getId());
        street.setBaseDepartmentId(boHelper.getByCodeOpfr(street.getBaseDepartmentCode(), street.getOpfrId()).getId());

        RegionModel region = regionHelper.getByCode(street.getRegionCode());
        street.setRegionId(region!=null?region.getId():null);

        street.setTerOrganId(terOrganHelper.getByCodeOpfr(street.getTerOrganCode(), street.getOpfrId()).getId());
        street.setTerDepartmentPFRId(
                terDepartmentPFRHelper.getByCodeBaseDepTerOrgan(
                        street.getTerDepartmentPFRCode(),
                        street.getBaseDepartmentId(),
                        street.getTerOrganId()
                ).getId());
        AdmTerritoryModel admTerritory = admTerritoryHelper.getByCodeRegionIdTerDepIdBaseDepId(
                street.getAdmTerritoryCode(),
                street.getRegionId(),
                street.getTerDepartmentPFRId(),
                street.getBaseDepartmentId()
        );
        street.setAdmTerritoryId(admTerritory != null ? admTerritory.getId() : null);

        CityModel city = cityHelper.getByCodeAdmTerrIdRegionIdTerDepIdBaseDepId(street.getCityCode(),
                street.getAdmTerritoryId(),
                street.getRegionId(),
                street.getTerDepartmentPFRId(),
                street.getBaseDepartmentId());
        street.setCityId(city != null ? city.getId() : null);

        TownModel town = townHelper.getByCodeCityIdAdmTerritoryIdRegionIdTerDepIdBaseDepId(street.getTownCode(),
                street.getCityId(),
                street.getAdmTerritoryId(),
                street.getRegionId(),
                street.getTerDepartmentPFRId(),
                street.getBaseDepartmentId());
        street.setTownId(town != null ? town.getId() : null);

        CheckResult res = streetHelper.create(street);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //Проверить, что изменения отражены в журнале изменений STH_JOURNAL_CHANGE_DATA
        res = journalChangeDataHelper.checkExistChangeData(street.getId(),
                PtksEnumeration.JournalChangeDataDictionaryType.STREET.getValue(),
                PtksEnumeration.JournalChangeDataOperationType.INSERT.getValue());
        assertTrue(res.getIsSuccess(), res.getMessageTest());

    }

    @Test(description = "Создать КЛАДР.Улица.Список диапазонов",dataProvider = "getDataFromExcel", priority=8)
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "StreetDepartmentModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateStreetDepartment")
    public void CreateKladrStreetDepartment(StreetDepartmentModel streetDepartment) throws SQLException, IntegrationException {
        streetDepartment.setOpfrId(opfrHelper.getByCode(streetDepartment.getOpfrCode()).getId());
        streetDepartment.setBaseDepartmentId(boHelper.getByCodeOpfr(streetDepartment.getBaseDepartmentCode(), streetDepartment.getOpfrId()).getId());

        RegionModel region = regionHelper.getByCode(streetDepartment.getRegionCode());
        streetDepartment.setRegionId(region!=null?region.getId():null);

        streetDepartment.setTerOrganId(terOrganHelper.getByCodeOpfr(streetDepartment.getTerOrganCode(), streetDepartment.getOpfrId()).getId());
        streetDepartment.setTerDepartmentPFRId(
                terDepartmentPFRHelper.getByCodeBaseDepTerOrgan(
                        streetDepartment.getTerDepartmentPFRCode(),
                        streetDepartment.getBaseDepartmentId(),
                        streetDepartment.getTerOrganId()
                ).getId());

        AdmTerritoryModel admTerritory =  admTerritoryHelper.getByCodeRegionIdTerDepIdBaseDepId(
                streetDepartment.getAdmTerritoryCode(),
                streetDepartment.getRegionId(),
                streetDepartment.getTerDepartmentPFRId(),
                streetDepartment.getBaseDepartmentId()
        );
        streetDepartment.setAdmTerritoryId(admTerritory != null ? admTerritory.getId() : null);

        CityModel city = cityHelper.getByCodeAdmTerrIdRegionIdTerDepIdBaseDepId(streetDepartment.getCityCode(),
                streetDepartment.getAdmTerritoryId(),
                streetDepartment.getRegionId(),
                streetDepartment.getTerDepartmentPFRId(),
                streetDepartment.getBaseDepartmentId());

        streetDepartment.setCityId(city != null ? city.getId() : null);

        TownModel town = townHelper.getByCodeCityIdAdmTerritoryIdRegionIdTerDepIdBaseDepId(streetDepartment.getTownCode(),
                streetDepartment.getCityId(),
                streetDepartment.getAdmTerritoryId(),
                streetDepartment.getRegionId(),
                streetDepartment.getTerDepartmentPFRId(),
                streetDepartment.getBaseDepartmentId());

        streetDepartment.setTownId(town != null ? town.getId() : null);

        streetDepartment.setStreetId(streetHelper.getByCodeCityIdTownIdAdmTerIdRegionIdBaseDepId(
                streetDepartment.getStreetCode(),
                streetDepartment.getCityId(),
                streetDepartment.getTownId(),
                streetDepartment.getAdmTerritoryId(),
                streetDepartment.getRegionId(),
                streetDepartment.getBaseDepartmentId()
        ).getId());

        CheckResult res = streetDepartmentHelper.create(streetDepartment);
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }

    @Test(description = "Создать КЛАДР.Улица.Список диапазонов.Список домов",dataProvider = "getDataFromExcel", priority=9)
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "StreetHousesModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateStreetHouses")
    public void CreateKladrStreetHouses(StreetHousesModel streetHouses) throws SQLException, IntegrationException {
        streetHouses.setOpfrId(opfrHelper.getByCode(streetHouses.getOpfrCode()).getId());
        streetHouses.setBaseDepartmentId(boHelper.getByCodeOpfr(streetHouses.getBaseDepartmentCode(), streetHouses.getOpfrId()).getId());

        RegionModel region = regionHelper.getByCode(streetHouses.getRegionCode());
        streetHouses.setRegionId(region != null ? region.getId() : null);
        streetHouses.setTerOrganId(terOrganHelper.getByCodeOpfr(streetHouses.getTerOrganCode(), streetHouses.getOpfrId()).getId());
        streetHouses.setTerDepartmentPFRId(
                terDepartmentPFRHelper.getByCodeBaseDepTerOrgan(
                        streetHouses.getTerDepartmentPFRCode(),
                        streetHouses.getBaseDepartmentId(),
                        streetHouses.getTerOrganId()
                ).getId());

        AdmTerritoryModel admTerritory = admTerritoryHelper.getByCodeRegionIdTerDepIdBaseDepId(
                streetHouses.getAdmTerritoryCode(),
                streetHouses.getRegionId(),
                streetHouses.getTerDepartmentPFRId(),
                streetHouses.getBaseDepartmentId()
        );
        streetHouses.setAdmTerritoryId(admTerritory != null ? admTerritory.getId() : null);

        CityModel city  = cityHelper.getByCodeAdmTerrIdRegionIdTerDepIdBaseDepId(streetHouses.getCityCode(),
                streetHouses.getAdmTerritoryId(),
                streetHouses.getRegionId(),
                streetHouses.getTerDepartmentPFRId(),
                streetHouses.getBaseDepartmentId());
        streetHouses.setCityId(city != null ? city.getId() : null);

        TownModel town = townHelper.getByCodeCityIdAdmTerritoryIdRegionIdTerDepIdBaseDepId(streetHouses.getTownCode(),
                streetHouses.getCityId(),
                streetHouses.getAdmTerritoryId(),
                streetHouses.getRegionId(),
                streetHouses.getTerDepartmentPFRId(),
                streetHouses.getBaseDepartmentId());
        streetHouses.setTownId(town != null ? town.getId() : null);

        streetHouses.setStreetId(streetHelper.getByCodeCityIdTownIdAdmTerIdRegionIdBaseDepId(
                streetHouses.getStreetCode(),
                streetHouses.getCityId(),
                streetHouses.getTownId(),
                streetHouses.getAdmTerritoryId(),
                streetHouses.getRegionId(),
                streetHouses.getBaseDepartmentId()
        ).getId());

        streetHouses.setStreetDepartmentId(streetDepartmentHelper.getByStreetIdTerDepId(
                streetHouses.getStreetId(),
                streetHouses.getTerDepartmentPFRId()).getId());

        CheckResult res = streetHousesHelper.create(streetHouses);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //streetHousesHelper.delete(streetHouses);
    }

    @Test(description = "Создать Вид регистрации",dataProvider = "getDataFromExcel", priority=1)
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "RegistrationKindModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateRegistrationKind")
    public void CreateRegistrationKind(RegistrationKindModel registrationKind) throws SQLException, IntegrationException {

       CheckResult res = registrationKindHelper.create(registrationKind);
       assertTrue(res.getIsSuccess(), res.getMessageTest());

        //Проверить, что изменения отражены в журнале изменений STH_JOURNAL_CHANGE_DATA
        res = journalChangeDataHelper.checkExistChangeData(registrationKind.getId(),
                PtksEnumeration.JournalChangeDataDictionaryType.REGISTRATION_TYPE.getValue(),
                PtksEnumeration.JournalChangeDataOperationType.INSERT.getValue());
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }

    @Test(description = "Создать Регистрирующий орган",dataProvider = "getDataFromExcel", priority=1)
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "RegistrationDepartmentModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateRegistrationDepartment")
    public void CreateRegistrationDepartment(RegistrationDepartmentModel registrationDepartment) throws SQLException, IntegrationException {

        CheckResult res = registrationDepartmentHelper.create(registrationDepartment);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //Проверить, что изменения отражены в журнале изменений STH_JOURNAL_CHANGE_DATA
        res = journalChangeDataHelper.checkExistChangeData(registrationDepartment.getId(),
                PtksEnumeration.JournalChangeDataDictionaryType.REGISTRATION_ORGAN.getValue(),
                PtksEnumeration.JournalChangeDataOperationType.INSERT.getValue());
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }

    @Test(description = "Создать ИФНС",dataProvider = "getDataFromExcel", priority=1)
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "IfnsModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateIfns")
    public void CreateIfns(IfnsModel ifns) throws SQLException, IntegrationException {
        CheckResult res = ifnsHelper.create(ifns);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //Проверить, что изменения отражены в журнале изменений STH_JOURNAL_CHANGE_DATA
        res = journalChangeDataHelper.checkExistChangeData(ifns.getId(),
                PtksEnumeration.JournalChangeDataDictionaryType.IFNS.getValue(),
                PtksEnumeration.JournalChangeDataOperationType.INSERT.getValue());
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }

    @Test(description = "Создать Плательщика",dataProvider = "getDataFromExcel", priority=10)
    @DataProviderParams("fileName="+ fileName +";tabName="+ tabName +";class="+ "InsurerModel" +";testTableName="+ "CreateMigrationDataInPtks.CreateInsurer")
    public void CreateInsurer(InsurerModel insurer) throws SQLException, IntegrationException {

        insurer.setOpfrId(opfrHelper.getByCode(insurer.getOpfrCode()).getId());
        insurer.setBaseDepartmentId(boHelper.getByCodeOpfr(insurer.getBaseDepartmentCode(), insurer.getOpfrId()).getId());

        RegionModel region =  regionHelper.getByCode(insurer.getRegionCode());
        insurer.setRegionId(region != null ? region.getId() : null);

        insurer.setTerOrganId(terOrganHelper.getByCodeOpfr(insurer.getTerOrganCode(), insurer.getOpfrId()).getId());
        insurer.setTerDepartmentPFRId(
                terDepartmentPFRHelper.getByCodeBaseDepTerOrgan(
                        insurer.getTerDepartmentPFRCode(),
                        insurer.getBaseDepartmentId(),
                        insurer.getTerOrganId()
                ).getId());

        AdmTerritoryModel admTerritory =  admTerritoryHelper.getByCodeRegionIdTerDepIdBaseDepId(
                insurer.getAdmTerritoryCode(),
                insurer.getRegionId(),
                insurer.getTerDepartmentPFRId(),
                insurer.getBaseDepartmentId()
        );
        insurer.setAdmTerritoryId(admTerritory != null ? admTerritory.getId() : null);

        CityModel city =  cityHelper.getByCodeAdmTerrIdRegionIdTerDepIdBaseDepId(insurer.getCityCode(),
                insurer.getAdmTerritoryId(),
                insurer.getRegionId(),
                insurer.getTerDepartmentPFRId(),
                insurer.getBaseDepartmentId());
        insurer.setCityId(city != null ? city.getId() : null);

        TownModel town = townHelper.getByCodeCityIdAdmTerritoryIdRegionIdTerDepIdBaseDepId(insurer.getTownCode(),
                insurer.getCityId(),
                insurer.getAdmTerritoryId(),
                insurer.getRegionId(),
                insurer.getTerDepartmentPFRId(),
                insurer.getBaseDepartmentId());
        insurer.setTownId(town != null ? town.getId() : null);

        StreetModel street =  streetHelper.getByCodeCityIdTownIdAdmTerIdRegionIdBaseDepId(
                insurer.getStreetCode(),
                insurer.getCityId(),
                insurer.getTownId(),
                insurer.getAdmTerritoryId(),
                insurer.getRegionId(),
                insurer.getBaseDepartmentId()
        );
        insurer.setStreetId(street != null ? street.getId() : null);

        insurer.setIfnsId(ifnsHelper.getByCode(insurer.getIfnsCode()).getId());
        insurer.setOkvedId(okvedHelper.getByCode(insurer.getOkvedCode()).getId());
        insurer.setOpfId(opfHelper.getByCode(insurer.getOpfCode()).getId());
        insurer.setRegistrationDepartmentId(registrationDepartmentHelper.getByCode(insurer.getRegistrationDepCode()).getId());

        insurer.setStartRegistrationKindId(registrationKindHelper.getByCode(insurer.getStartRegistrationKindCode(), insurer.getStartRegistrationKindIsPerson()).getId());
        insurer.setFinishRegistrationKindId(registrationKindHelper.getByCode(insurer.getFinishRegistrationKindCode(), insurer.getFinishRegistrationKindIsPerson()).getId());

        CheckResult res = insurerHelper.create(insurer);
        assertTrue(res.getIsSuccess(), res.getMessageTest());

        //Проверить, что изменения отражены в журнале изменений STH_JOURNAL_CHANGE_DATA
        res = journalChangeDataHelper.checkExistChangeData(insurer.getInsRegNum(),
                PtksEnumeration.JournalChangeDataDictionaryType.INSURER.getValue(),
                PtksEnumeration.JournalChangeDataOperationType.INSERT.getValue());
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }
}
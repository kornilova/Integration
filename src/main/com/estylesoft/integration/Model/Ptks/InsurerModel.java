package com.estylesoft.integration.Model.Ptks;

import com.estylesoft.integration.Model.ModelBase;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 10.02.14
 * Time: 13:39
 * To change this template use File | Settings | File Templates.
 */
public class InsurerModel extends ModelBase {


    private String opfrCode;
    private Long opfrId;

    private String terDepartmentPFRCode;
    private Long terDepartmentPFRId;

    private Long insRegNum;
    private String insTypeName;

    private String ifnsCode;
    private Long ifnsId;

    private String baseDepartmentCode;
    private Long baseDepartmentId;

    private String terOrganCode;
    private Long terOrganId;

    private String registrationDepCode;
    private Long registrationDepartmentId;

    private String cityCode;
    private String cityName;
    private Long cityId;

    private String streetCode;
    private String streetName;
    private Long streetId;

    private String insCategoryCode;

    private String okvedCode;
    private Long okvedId;

    private String opfCode;
    private Long opfId;

    private String insStartTypeCode;
    private String insFinishTypeCode;
    private String insStatusCode;

    private String townCode;
    private String townName;
    private Long townId;

    private String startRegistrationKindCode;
    private Integer startRegistrationKindIsPerson;
    private Long startRegistrationKindId;

    private String finishRegistrationKindCode;
    private Integer finishRegistrationKindIsPerson;
    private Long finishRegistrationKindId;

    private String  userLogin;
    private Long ogrn;
    private Long inn;
    private Date statusChangeDate;
    private Date registrationFnsDate;
    private Date unRegistrationFnsDate;
    private Date startRegistartionPfrDate;
    private Date finishRegistartionPfrDate;
    private Date registrationPfrDate;
    private String okatoCode;
    private String phoneCode;
    private String phoneNumber;
    private String phoneFaxNumber;
    private String zipCode;
    private String house;
    private String building;
    private String room;

    private String regionName;
    private String regionCode;
    private Long regionId;

    private String admTerritoryName;
    private String admTerritoryCode;
    private Long admTerritoryId;

    private String factZipCode;
    private String factHouse;
    private String factBuilding;
    private String factRoom;
    private String description;
    private Long   getSalary;
    private String regCertificate;
    private Long   oneWindow;
    private Date  lastUpdateDate;
    private Date  createDate;
    private Date  registerRO;
    private Date  unRegisterRO;
    private Long  atomic;
    private Long addInsType;
    private Long strahNumber;
    private String firstName;
    private String lastName;
    private String middleName;
    private Long  sex;
    private String birthPlace;
    private Date birthDay;
    private String typeDoc;
    private String  seriesDoc;
    private String numDoc;
    private Date  dateDoc;
    private String nameOrgDoc;
    private String codeOrgDoc;
    private Long kpp;
    private String fullName;
    private String shortName;
    private String tradeName;
    private String oldRegNumRo;
    private String fomsRegNum;
    private Date startFomsDate;
    private Date finishFomsDate;
    private String fomsOrgCode;
    private String fomsOrgName;
    private Long  orgKind;
    private Long writeOff;
    private Long isActual;

    public String getOpfrCode() {
        return opfrCode;
    }

    public void setOpfrCode(String opfrCode) {
        this.opfrCode = opfrCode;
    }

    public Long getOpfrId() {
        return opfrId;
    }

    public void setOpfrId(Long opfrId) {
        this.opfrId = opfrId;
    }

    public String getTerDepartmentPFRCode() {
        return terDepartmentPFRCode;
    }

    public void setTerDepartmentPFRCode(String terDepartmentPFRCode) {
        this.terDepartmentPFRCode = terDepartmentPFRCode;
    }

    public Long getTerDepartmentPFRId() {
        return terDepartmentPFRId;
    }

    public void setTerDepartmentPFRId(Long terDepartmentPFRId) {
        this.terDepartmentPFRId = terDepartmentPFRId;
    }

    public Long getInsRegNum() {
        return insRegNum;
    }

    public void setInsRegNum(Long insRegNum) {
        this.insRegNum = insRegNum;
    }

    public String getInsTypeName() {
        return insTypeName;
    }

    public void setInsTypeName(String insTypeName) {
        this.insTypeName = insTypeName;
    }

    public String getIfnsCode() {
        return ifnsCode;
    }

    public void setIfnsCode(String ifnsCode) {
        this.ifnsCode = ifnsCode;
    }

    public Long getIfnsId() {
        return ifnsId;
    }

    public void setIfnsId(Long ifnsId) {
        this.ifnsId = ifnsId;
    }

    public String getBaseDepartmentCode() {
        return baseDepartmentCode;
    }

    public void setBaseDepartmentCode(String baseDepartmentCode) {
        this.baseDepartmentCode = baseDepartmentCode;
    }

    public Long getBaseDepartmentId() {
        return baseDepartmentId;
    }

    public void setBaseDepartmentId(Long baseDepartmentId) {
        this.baseDepartmentId = baseDepartmentId;
    }

    public String getTerOrganCode() {
        return terOrganCode;
    }

    public void setTerOrganCode(String terOrganCode) {
        this.terOrganCode = terOrganCode;
    }

    public Long getTerOrganId() {
        return terOrganId;
    }

    public void setTerOrganId(Long terOrganId) {
        this.terOrganId = terOrganId;
    }

    public String getRegistrationDepCode() {
        return registrationDepCode;
    }

    public void setRegistrationDepCode(String registrationDepCode) {
        this.registrationDepCode = registrationDepCode;
    }

    public Long getRegistrationDepartmentId() {
        return registrationDepartmentId;
    }

    public void setRegistrationDepartmentId(Long registrationDepartmentId) {
        this.registrationDepartmentId = registrationDepartmentId;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getStreetCode() {
        return streetCode;
    }

    public void setStreetCode(String streetCode) {
        this.streetCode = streetCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Long getStreetId() {
        return streetId;
    }

    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }

    public String getInsCategoryCode() {
        return insCategoryCode;
    }

    public void setInsCategoryCode(String insCategoryCode) {
        this.insCategoryCode = insCategoryCode;
    }

    public String getOkvedCode() {
        return okvedCode;
    }

    public void setOkvedCode(String okvedCode) {
        this.okvedCode = okvedCode;
    }

    public Long getOkvedId() {
        return okvedId;
    }

    public void setOkvedId(Long okvedId) {
        this.okvedId = okvedId;
    }

    public String getOpfCode() {
        return opfCode;
    }

    public void setOpfCode(String opfCode) {
        this.opfCode = opfCode;
    }

    public Long getOpfId() {
        return opfId;
    }

    public void setOpfId(Long opfId) {
        this.opfId = opfId;
    }

    public String getInsStartTypeCode() {
        return insStartTypeCode;
    }

    public void setInsStartTypeCode(String insStartTypeCode) {
        this.insStartTypeCode = insStartTypeCode;
    }

    public String getInsFinishTypeCode() {
        return insFinishTypeCode;
    }

    public void setInsFinishTypeCode(String insFinishTypeCode) {
        this.insFinishTypeCode = insFinishTypeCode;
    }

    public String getInsStatusCode() {
        return insStatusCode;
    }

    public void setInsStatusCode(String insStatusCode) {
        this.insStatusCode = insStatusCode;
    }

    public String getTownCode() {
        return townCode;
    }

    public void setTownCode(String townCode) {
        this.townCode = townCode;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public Long getTownId() {
        return townId;
    }

    public void setTownId(Long townId) {
        this.townId = townId;
    }

    public String getStartRegistrationKindCode() {
        return startRegistrationKindCode;
    }

    public void setStartRegistrationKindCode(String startRegistrationKindCode) {
        this.startRegistrationKindCode = startRegistrationKindCode;
    }

    public Integer getStartRegistrationKindIsPerson() {
        return startRegistrationKindIsPerson;
    }

    public void setStartRegistrationKindIsPerson(Integer startRegistrationKindIsPerson) {
        this.startRegistrationKindIsPerson = startRegistrationKindIsPerson;
    }

    public Long getStartRegistrationKindId() {
        return startRegistrationKindId;
    }

    public void setStartRegistrationKindId(Long startRegistrationKindId) {
        this.startRegistrationKindId = startRegistrationKindId;
    }

    public String getFinishRegistrationKindCode() {
        return finishRegistrationKindCode;
    }

    public void setFinishRegistrationKindCode(String finishRegistrationKindCode) {
        this.finishRegistrationKindCode = finishRegistrationKindCode;
    }

    public Integer getFinishRegistrationKindIsPerson() {
        return finishRegistrationKindIsPerson;
    }

    public void setFinishRegistrationKindIsPerson(Integer finishRegistrationKindIsPerson) {
        this.finishRegistrationKindIsPerson = finishRegistrationKindIsPerson;
    }

    public Long getFinishRegistrationKindId() {
        return finishRegistrationKindId;
    }

    public void setFinishRegistrationKindId(Long finishRegistrationKindId) {
        this.finishRegistrationKindId = finishRegistrationKindId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Long getOgrn() {
        return ogrn;
    }

    public void setOgrn(Long ogrn) {
        this.ogrn = ogrn;
    }

    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }

    public Date getStatusChangeDate() {
        return statusChangeDate;
    }

    public void setStatusChangeDate(Date statusChangeDate) {
        this.statusChangeDate = statusChangeDate;
    }

    public Date getRegistrationFnsDate() {
        return registrationFnsDate;
    }

    public void setRegistrationFnsDate(Date registrationFnsDate) {
        this.registrationFnsDate = registrationFnsDate;
    }

    public Date getUnRegistrationFnsDate() {
        return unRegistrationFnsDate;
    }

    public void setUnRegistrationFnsDate(Date unRegistrationFnsDate) {
        this.unRegistrationFnsDate = unRegistrationFnsDate;
    }

    public Date getStartRegistartionPfrDate() {
        return startRegistartionPfrDate;
    }

    public void setStartRegistartionPfrDate(Date startRegistartionPfrDate) {
        this.startRegistartionPfrDate = startRegistartionPfrDate;
    }

    public Date getFinishRegistartionPfrDate() {
        return finishRegistartionPfrDate;
    }

    public void setFinishRegistartionPfrDate(Date finishRegistartionPfrDate) {
        this.finishRegistartionPfrDate = finishRegistartionPfrDate;
    }

    public Date getRegistrationPfrDate() {
        return registrationPfrDate;
    }

    public void setRegistrationPfrDate(Date registrationPfrDate) {
        this.registrationPfrDate = registrationPfrDate;
    }

    public String getOkatoCode() {
        return okatoCode;
    }

    public void setOkatoCode(String okatoCode) {
        this.okatoCode = okatoCode;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneFaxNumber() {
        return phoneFaxNumber;
    }

    public void setPhoneFaxNumber(String phoneFaxNumber) {
        this.phoneFaxNumber = phoneFaxNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public String getAdmTerritoryName() {
        return admTerritoryName;
    }

    public void setAdmTerritoryName(String admTerritoryName) {
        this.admTerritoryName = admTerritoryName;
    }

    public String getAdmTerritoryCode() {
        return admTerritoryCode;
    }

    public void setAdmTerritoryCode(String admTerritoryCode) {
        this.admTerritoryCode = admTerritoryCode;
    }

    public Long getAdmTerritoryId() {
        return admTerritoryId;
    }

    public void setAdmTerritoryId(Long admTerritoryId) {
        this.admTerritoryId = admTerritoryId;
    }

    public String getFactZipCode() {
        return factZipCode;
    }

    public void setFactZipCode(String factZipCode) {
        this.factZipCode = factZipCode;
    }

    public String getFactHouse() {
        return factHouse;
    }

    public void setFactHouse(String factHouse) {
        this.factHouse = factHouse;
    }

    public String getFactBuilding() {
        return factBuilding;
    }

    public void setFactBuilding(String factBuilding) {
        this.factBuilding = factBuilding;
    }

    public String getFactRoom() {
        return factRoom;
    }

    public void setFactRoom(String factRoom) {
        this.factRoom = factRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getGetSalary() {
        return getSalary;
    }

    public void setGetSalary(Long getSalary) {
        this.getSalary = getSalary;
    }

    public String getRegCertificate() {
        return regCertificate;
    }

    public void setRegCertificate(String regCertificate) {
        this.regCertificate = regCertificate;
    }

    public Long getOneWindow() {
        return oneWindow;
    }

    public void setOneWindow(Long oneWindow) {
        this.oneWindow = oneWindow;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getRegisterRO() {
        return registerRO;
    }

    public void setRegisterRO(Date registerRO) {
        this.registerRO = registerRO;
    }

    public Date getUnRegisterRO() {
        return unRegisterRO;
    }

    public void setUnRegisterRO(Date unRegisterRO) {
        this.unRegisterRO = unRegisterRO;
    }

    public Long getAtomic() {
        return atomic;
    }

    public void setAtomic(Long atomic) {
        this.atomic = atomic;
    }

    public Long getAddInsType() {
        return addInsType;
    }

    public void setAddInsType(Long addInsType) {
        this.addInsType = addInsType;
    }

    public Long getStrahNumber() {
        return strahNumber;
    }

    public void setStrahNumber(Long strahNumber) {
        this.strahNumber = strahNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Long getSex() {
        return sex;
    }

    public void setSex(Long sex) {
        this.sex = sex;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getTypeDoc() {
        return typeDoc;
    }

    public void setTypeDoc(String typeDoc) {
        this.typeDoc = typeDoc;
    }

    public String getSeriesDoc() {
        return seriesDoc;
    }

    public void setSeriesDoc(String seriesDoc) {
        this.seriesDoc = seriesDoc;
    }

    public String getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(String numDoc) {
        this.numDoc = numDoc;
    }

    public Date getDateDoc() {
        return dateDoc;
    }

    public void setDateDoc(Date dateDoc) {
        this.dateDoc = dateDoc;
    }

    public String getNameOrgDoc() {
        return nameOrgDoc;
    }

    public void setNameOrgDoc(String nameOrgDoc) {
        this.nameOrgDoc = nameOrgDoc;
    }

    public String getCodeOrgDoc() {
        return codeOrgDoc;
    }

    public void setCodeOrgDoc(String codeOrgDoc) {
        this.codeOrgDoc = codeOrgDoc;
    }

    public Long getKpp() {
        return kpp;
    }

    public void setKpp(Long kpp) {
        this.kpp = kpp;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getOldRegNumRo() {
        return oldRegNumRo;
    }

    public void setOldRegNumRo(String oldRegNumRo) {
        this.oldRegNumRo = oldRegNumRo;
    }

    public String getFomsRegNum() {
        return fomsRegNum;
    }

    public void setFomsRegNum(String fomsRegNum) {
        this.fomsRegNum = fomsRegNum;
    }

    public Date getStartFomsDate() {
        return startFomsDate;
    }

    public void setStartFomsDate(Date startFomsDate) {
        this.startFomsDate = startFomsDate;
    }

    public Date getFinishFomsDate() {
        return finishFomsDate;
    }

    public void setFinishFomsDate(Date finishFomsDate) {
        this.finishFomsDate = finishFomsDate;
    }

    public String getFomsOrgCode() {
        return fomsOrgCode;
    }

    public void setFomsOrgCode(String fomsOrgCode) {
        this.fomsOrgCode = fomsOrgCode;
    }

    public String getFomsOrgName() {
        return fomsOrgName;
    }

    public void setFomsOrgName(String fomsOrgName) {
        this.fomsOrgName = fomsOrgName;
    }

    public Long getOrgKind() {
        return orgKind;
    }

    public void setOrgKind(Long orgKind) {
        this.orgKind = orgKind;
    }

    public Long getWriteOff() {
        return writeOff;
    }

    public void setWriteOff(Long writeOff) {
        this.writeOff = writeOff;
    }

    public Long getActual() {
        return isActual;
    }

    public void setActual(Long actual) {
        isActual = actual;
    }
}
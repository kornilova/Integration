package com.estylesoft.integration.test.Ptks;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Exchange.CompareDictionaryDataFromFBSHelper;
import com.estylesoft.integration.IntegrationException;
import com.estylesoft.integration.test.TestBase;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 02.04.14
 * Time: 16:57
 * To change this template use File | Settings | File Templates.
 */
public class CompareExportedDictionaryInPtks extends TestBase {

    private CompareDictionaryDataFromFBSHelper compareDictionaryHelper;

    @BeforeSuite
    public void BeforeSuite() throws IOException {

     compareDictionaryHelper =
                new CompareDictionaryDataFromFBSHelper(getSqlConnectionPtks(), getSqlConnectionFbs());
    }

    @Test(description = "Проверка актуализации Федеральный округ")
    public void CheckFederalOkrug() throws IntegrationException {
        CheckResult res = compareDictionaryHelper.compareActualFederalOkrug();
        assertTrue(res.getIsSuccess(), res.getFullMessage());
    }

    @Test(description = "Проверка актуализации Признак постановки на учет плательщкиа")
    public void CheckRegistrationStart() throws IntegrationException {
        CheckResult res = compareDictionaryHelper.compareActualRegistrationStart();
        assertTrue(res.getIsSuccess(), res.getFullMessage());
    }

    @Test(description = "Проверка актуализации Признак снятия с учета плательщкиа")
    public void CheckRegistrationFinish() throws IntegrationException {
        CheckResult res = compareDictionaryHelper.compareActualRegistrationFinish();
        assertTrue(res.getIsSuccess(), res.getFullMessage());
    }

    @Test(description = "Проверка актуализации Кода бюджетной классификации")
    public void CheckKbk() throws IntegrationException {
        CheckResult res = compareDictionaryHelper.compareActualKbk();
        assertTrue(res.getIsSuccess(), res.getFullMessage());
    }

    @Test(description = "Проверка актуализации Категории плательщика")
    public void CheckCategory() throws IntegrationException {
        CheckResult res = compareDictionaryHelper.compareActualCategory();
        assertTrue(res.getIsSuccess(), res.getFullMessage());
    }

    @Test(description = "Проверка актуализации Тип плательщика")
    public void CheckInsurerType() throws IntegrationException {
        CheckResult res = compareDictionaryHelper.compareActualInsurerType();
        assertTrue(res.getIsSuccess(), res.getFullMessage());
    }
}

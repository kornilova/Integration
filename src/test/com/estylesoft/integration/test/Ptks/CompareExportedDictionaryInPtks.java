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
        assertTrue(res.getIsSuccess(), res.getMessageTest());
    }
}

package com.estylesoft.integration.test;

import com.estylesoft.integration.CheckResult;
import com.estylesoft.integration.Exchange.CheckIntegrationResultHelper;
import com.estylesoft.integration.IntegrationException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import static org.testng.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 08.04.14
 * Time: 17:47
 * To change this template use File | Settings | File Templates.
 */
public class CheckIntegrationResult extends TestBase {
    private CheckIntegrationResultHelper checkIntegrationResultHelper;

    private Long opfrId;

    @BeforeSuite
    public void BeforeSuite() throws IOException, IntegrationException {

        checkIntegrationResultHelper =
                new CheckIntegrationResultHelper(getSqlConnectionPtks(), getSqlConnectionFbs());
        opfrId = checkIntegrationResultHelper.getFbsOpfrId();
        assertTrue(opfrId!=null, "OPFR_ID is not defined in Target.FBS.");
    }

    @Test(description = "Проверка результата интеграции Справочник ОПФР", priority = 1)
    public void CheckOpfr() throws IntegrationException {
        assertTrue(opfrId!=null, "OPFR_ID is not defined in Target.FBS.");

        CheckResult res = checkIntegrationResultHelper.CheckIntegrationOpfr();
        assertTrue(res.getIsSuccess(), res.getFullMessage());
    }

    @Test(description = "Проверка результата интеграции Справочник Базововое отделение", priority = 2)
    public void CheckBaseDepartment() throws IntegrationException {
        assertTrue(opfrId!=null, "OPFR_ID is not defined in Target.FBS.");

        CheckResult res = checkIntegrationResultHelper.CheckIntegrationBaseDepartment(opfrId);
        assertTrue(res.getIsSuccess(), res.getFullMessage());
    }

    @Test(description = "Проверка результата интеграции Справочник Территориальный орган", priority = 2)
    public void CheckTerOrgan() throws IntegrationException {
        assertTrue(opfrId!=null, "OPFR_ID is not defined in Target.FBS.");

        CheckResult res = checkIntegrationResultHelper.CheckIntegrationTerOrgan(opfrId);
        assertTrue(res.getIsSuccess(), res.getFullMessage());
    }
}

package Reporter;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.*;
import org.testng.xml.XmlSuite;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 30.01.14
 * Time: 11:02
 * To change this template use File | Settings | File Templates.
 */
public class CheckReporter implements IReporter {
    private String delimiter = "===============================================";
    private String smallDelimiter = "--";

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> iSuites, String s) {
        for (ISuite suite : iSuites) {
            String suiteName = suite.getName();
            Map<java.lang.String,org.testng.ISuiteResult> suiteResults = suite.getResults();
            for (ISuiteResult sr : suiteResults.values()) {
                ITestContext tc = sr.getTestContext();

                Set<ITestResult> passedTests= tc.getPassedTests().getAllResults();
                System.out.println(delimiter);

                System.out.println("Passed tests for suite '" + suiteName +"' is:" + passedTests.size());

                for(ITestResult passed: passedTests)
                {
                    System.out.println("Test name '"+ passed.getName()+"', description '" + passed.getMethod().getDescription()+ "'");
                }

                System.out.println(delimiter);
                Set<ITestResult> failedTests= tc.getFailedTests().getAllResults();
                System.out.println("(!)FAILED tests for suite '" + suiteName +"' is:" + failedTests.size());

                for(ITestResult failed: failedTests)
                {
                    System.out.println(smallDelimiter);
                    System.out.println("Test name '"+ failed.getName()+"', description '" + failed.getMethod().getDescription()+ "'");
                    System.out.println("Message text:");
                    System.out.println(failed.getThrowable().getMessage());
                    //failed.getThrowable().printStackTrace();
                }
                System.out.println(delimiter);
                Set<ITestResult> skippedTests= tc.getSkippedTests().getAllResults();
                System.out.println("Skipped tests for suite '" + suiteName +"' is:" + skippedTests.size());

                for(ITestResult skipped: skippedTests)
                {
                    System.out.println("Test name '"+ skipped.getName()+"', description '" + skipped.getMethod().getDescription()+ "'");
                }
                System.out.println(delimiter);
            }
        }
    }
}

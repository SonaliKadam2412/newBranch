package utility;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ExtendReportUtility {

    String projectPath = System.getProperty("user.dir");
    ExtentReports extentReports;
    ExtentTest testStep;

    public ExtendReportUtility(){
        extentReports = new ExtentReports(System.getProperty("user.dir") + "\\target\\Test-output\\report.html", true);
        Map<String, String> map = new HashMap<>();
        map.put("Host Name", "Demo Insta Extent reports");
        map.put("Env", "Prod");
        map.put("tester", "praveenkumar");
        extentReports.addSystemInfo(map);
        extentReports.loadConfig(new File(projectPath + "\\extent-config.xml"));
        testStep = extentReports.startTest("Extend report test name");

    }





@Test
    public void test1(){

    testStep.log(LogStatus.INFO, "************************");


    extentReports.endTest(testStep);
    extentReports.flush();
    extentReports.close();
}



}

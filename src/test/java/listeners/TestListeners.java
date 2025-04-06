package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.FileManager;
import utilities.Logs;

public class TestListeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Logs.info("onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Logs.info("onTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Logs.info("Test fallido: %s", result.getName());
        FileManager.getScreenshot(result.getName());
        FileManager.getPageSource(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logs.info("onTestSkipped");
    }
}

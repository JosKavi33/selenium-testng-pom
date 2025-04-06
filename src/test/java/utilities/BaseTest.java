package utilities;

import io.qameta.allure.testng.AllureTestNg;
import listeners.SuiteListeners;
import listeners.TestListeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListeners.class, SuiteListeners.class, AllureTestNg.class})
public class BaseTest {

    protected final String smoke = "smoke";
    protected final String regression = "regression";
    protected final CommonFlows commonFlows = new CommonFlows();
    private final DriverManager driverManager = new DriverManager();

    @BeforeMethod(alwaysRun = true)
    public void masterSetUp() {
        Logs.info("🚀 [BaseTest] Setting up WebDriver");
        driverManager.buildDriver();

        if (WebDriverProvider.get() == null) {
            Logs.error("❌ [BaseTest] WebDriver is NULL after setup!");
            throw new IllegalStateException("WebDriver setup failed. Please check DriverManager.");
        } else {
            Logs.info("✅ [BaseTest] WebDriver initialized successfully");
        }
    }

    @AfterMethod(alwaysRun = true)
    public void masterTearDown() {
        Logs.info("🧹 [BaseTest] Tearing down WebDriver");
        driverManager.killDriver();
    }
}

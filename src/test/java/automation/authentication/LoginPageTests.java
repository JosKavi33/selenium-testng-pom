package automation.authentication;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TopBar;
import utilities.BaseTest;
import utilities.CommonFlows;

public class LoginPageTests extends BaseTest {

    private final CommonFlows commonFlows = new CommonFlows();
    private final TopBar topBar = new TopBar();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToLoginPage();

    }

    @Tag(regression)
    @Tag(smoke)
    @Test(groups = {regression, smoke})
    @Description("Validate that the Login Sign In correctly")
    @Severity(SeverityLevel.CRITICAL)
    public void loginAccountTest() {
        topBar.verifyAfterLoginPage();
    }

}

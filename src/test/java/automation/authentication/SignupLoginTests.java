package automation.authentication;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignupLogin;
import utilities.BaseTest;

public class SignupLoginTests extends BaseTest {

    private final SignupLogin signupLogin = new SignupLogin();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToSignUpLoginPage();
    }

    @Tag(regression)
    @Tag(smoke)
    @Test(groups = {regression, smoke})
    @Description("Validate that the SignUpLoginPage loads correctly")
    @Severity(SeverityLevel.CRITICAL)
    public void verifySignupLoginTest() {
        signupLogin.verifyPage();
    }
}

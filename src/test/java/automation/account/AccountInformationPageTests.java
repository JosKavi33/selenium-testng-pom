package automation.account;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.AccountInformationPage;
import pages.SignupLogin;
import pages.TopBar;
import utilities.BaseTest;

public class AccountInformationPageTests extends BaseTest {

    private final AccountInformationPage accountInformationPage = new AccountInformationPage();
    private final SignupLogin signupLogin = new SignupLogin();
    private final AccountCreatedPage accountCreatedPage = new AccountCreatedPage();
    private final TopBar topBar = new TopBar();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToHomePage();
        topBar.loginButtonClick();
    }

    @Tag(regression)
    @Tag(smoke)
    @Test(groups = {regression, smoke})
    @Description("Validate that the AccountInformationPage loads correctly")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyTest() {
        signupLogin.fillSignUp();
        accountInformationPage.waitPageToLoad();
        accountInformationPage.verifyPage();
        accountInformationPage.fillForms();
        accountCreatedPage.waitPageToLoad();
        accountCreatedPage.verifyPage();
    }

}

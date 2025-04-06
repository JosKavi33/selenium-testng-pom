package automation.contact;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContacUsPage;
import utilities.BaseTest;
import utilities.CommonFlows;
import utilities.Logs;

public class ContactUsTests extends BaseTest {

    private final CommonFlows commonFlows = new CommonFlows();
    private final ContacUsPage contacUsPage = new ContacUsPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToContactUsPage();
        contacUsPage.waitPageToLoad();
    }

    @Tag(regression)
    @Tag(smoke)
    @Test(groups = {regression, smoke})
    @Description("Validate that the ContactUsPage loads correctly")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Verifying ContactUsPage")
    public void verifyTest() {
        Logs.info("Verifying ContactUsPage");
        contacUsPage.verifyPage();
    }

    @Tag(regression)
    @Test(groups = {regression})
    @Description("Validate that the ContactUsPage send a message correctly")
    @Severity(SeverityLevel.CRITICAL)
    public void fillContactUsForm() {
        verifyTest();
        contacUsPage.fillContactUsForm();
        contacUsPage.verifySuccessMessage();
    }

}

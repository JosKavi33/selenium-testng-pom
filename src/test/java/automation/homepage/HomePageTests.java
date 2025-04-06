package automation.homepage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TopBar;
import utilities.BaseTest;

public class HomePageTests extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final TopBar topBar = new TopBar();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToHomePage();
    }

    @Tag(regression)
    @Test(groups = {regression, smoke})
    @Description("Validate that the homepage loads correctly")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyTest() {
        homePage.verifyPage();
        topBar.verifyPage();
    }
}

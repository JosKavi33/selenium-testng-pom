package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class AccountCreatedPage extends BasePage {

    private final By accountCreatedTitle = By.xpath("//b[text()='Account Created!']");
    private final By messageSuccesfull = By.xpath("//p[text()='Congratulations! Your new account has been successfully created!']");
    private final By continueButton = By.cssSelector("a[data-qa='continue-button']");

    @Override
    @Step("⏳ Waiting for the Page AccountCreatedPage Load")
    public void waitPageToLoad() {
        Logs.info("⏳ Waitting for the Page AccountCreatedPage Load");
        waitPage(accountCreatedTitle, this.getClass().getSimpleName());
        Logs.info("✅ AccountCreatedPage is Loaded");
    }

    @Override
    @Step("🔍 Verifying the Page AccountCreatedPage")
    public void verifyPage() {
        Logs.info("🔍 Verifying the Page AccountCreatedPage");
        softAssert.assertTrue(find(accountCreatedTitle).isDisplayed(), "❌ Failure in the Locator accountCreatedTitle");
        softAssert.assertTrue(find(messageSuccesfull).isDisplayed(), "❌ Failure in the Locator messageSuccesfull");
        softAssert.assertTrue(find(continueButton).isDisplayed(), "❌ Failure in the Locator continueButton");
        softAssert.assertAll();
        Logs.info("✅ The AccountCreatedPage Verification Passed");
    }
}

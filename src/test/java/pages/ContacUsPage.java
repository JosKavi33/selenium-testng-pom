package pages;

import io.qameta.allure.Step;
import net.datafaker.Faker;
import org.openqa.selenium.By;
import utilities.BasePage;
import utilities.Logs;

public class ContacUsPage extends BasePage {

    private final By contactUsTitle = By.xpath("//h2[text()='Contact ']");
    private final By getInTouchTitle = By.xpath("//h2[text()='Get In Touch']");
    private final By nameInput = By.cssSelector("input[data-qa='name']");
    private final By emailInput = By.cssSelector("input[data-qa='email']");
    private final By subjectInput = By.cssSelector("input[data-qa='subject']");
    private final By messageInput = By.id("message");
    private final By selectFileButton = By.cssSelector("input[name='upload_file']");
    private final By submitButton = By.cssSelector("input[data-qa='submit-button']");
    private final By successAlertMessage = By.className("status");

    @Override
    @Step("⏳ Waiting ProductsPage")
    public void waitPageToLoad() {
        Logs.info("⏳ Waiting ProductsPage");
        waitPage(contactUsTitle, this.getClass().getSimpleName());
        Logs.info("✅ ProductsPage is Loaded");
    }

    @Override
    @Step("🔍 Verifying ContactUsPage")
    public void verifyPage() {
        Logs.info("🔍 Verifying ContactUsPage");
        softAssert.assertTrue(find(contactUsTitle).isDisplayed());
        softAssert.assertTrue(find(getInTouchTitle).isDisplayed());
        softAssert.assertTrue(find(nameInput).isDisplayed());
        softAssert.assertTrue(find(emailInput).isDisplayed());
        softAssert.assertTrue(find(subjectInput).isDisplayed());
        softAssert.assertTrue(find(messageInput).isDisplayed());
        softAssert.assertTrue(find(selectFileButton).isDisplayed());
        softAssert.assertTrue(find(submitButton).isDisplayed());
        softAssert.assertAll();
        Logs.info("✅ The ContactUsPage Verification Passed");
    }

    @Step("📝 Filling ContactUs Form")
    public void fillContactUsForm() {
        Logs.info("📝 Filling ContactUs Form");
        final var faker = new Faker();
        final var name = faker.name().fullName();
        final var email = faker.internet().emailAddress();
        final var subject = faker.internet().emailSubject();
        final var message = faker.lorem().sentence();

        find(nameInput).sendKeys(name);
        find(emailInput).sendKeys(email);
        find(subjectInput).sendKeys(subject);
        find(messageInput).sendKeys(message);

        find(submitButton).click();
        getDriver().switchTo().alert().accept();
        Logs.info("✅ The Form has Been Filled");
    }

    @Step("🔍 Verifying Success Message")
    public void verifySuccessMessage() {
        Logs.info("🔍 Verifying Success Message");
        softAssert.assertTrue(find(successAlertMessage).isDisplayed(), "❌ Failure in the Locator successAlertMessage");
        softAssert.assertEquals(find(successAlertMessage).getText(), "Success! Your details have been submitted successfully.", "❌ Failure in the Expected Message");
        softAssert.assertAll();
        Logs.info("✅ The Success Message Verification Passed");
    }
}

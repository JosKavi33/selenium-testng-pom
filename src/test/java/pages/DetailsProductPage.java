package pages;

import io.qameta.allure.Step;
import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.BasePage;
import utilities.Logs;

import java.util.Arrays;
import java.util.List;

public class DetailsProductPage extends BasePage {

    private final By getItemTitle(String itemName) {
        final var xpath = String.format("//h2[text()='%s']", itemName);
        return By.xpath(xpath);
    }

    private final By getItemPrice(String itemName) {
        return RelativeLocator
                .with(By.tagName("img"))
                .below(getItemTitle(itemName));
    }

    private final By itemDescription = RelativeLocator.with(By.tagName("img")).below(getItemTitle("Blue Top"));
    private final By itemQuantity = By.xpath("//label[text()='Quantity:']");
    private final By itemButtonAddToCart = RelativeLocator.with(By.tagName("button")).toRightOf(itemQuantity);
    private final By itemAvailability = By.xpath("//b[text()='Availability:']");
    private final By itemCondition = By.xpath("//b[text()='Condition:']");
    private final By itemBrand = By.xpath("//b[text()='Brand:']");
    private final By reviewFormTitle = By.xpath("//a[text()='Write Your Review']");
    private final By nameReviewFormInput = By.id("name");
    private final By emailReviewFormInput = By.id("email");
    private final By addReviewFormTextarea = By.id("review");
    private final By submitFormButton = By.id("button-review");
    private final By verificationSendMessage = By.xpath("//span[text()='Thank you for your review.']");

    @Override
    @Step("⏳ Waiting DetailsProductPage")
    public void waitPageToLoad() {
        Logs.info("⏳ Waiting DetailsProductPage");
        waitPage(getItemTitle("Blue Top"), this.getClass().getSimpleName());
        Logs.info("✅ DetailsProductPage is Loaded");
    }

    @Override
    @Step("🔍 Verifying DetailsProductPage")
    public void verifyPage() {
        Logs.info("🔍 Verifying DetailsProductPage");
        List<By> elements = Arrays.asList(
                getItemTitle("Blue Top"), itemDescription, getItemPrice("Blue Top"), itemQuantity, itemButtonAddToCart,
                itemAvailability, itemCondition, itemBrand, reviewFormTitle, nameReviewFormInput,
                emailReviewFormInput, addReviewFormTextarea, submitFormButton
        );

        for (By element : elements) {
            softAssert.assertTrue(find(element).isDisplayed(), "❌ Failure the Element is not displayed: " + element.toString());
            softAssert.assertAll();
        }
        Logs.info("✅ The DetailsProductPage Verification Passed");
    }

    @Step("📝 Filling the Review Form and Verifying the Sended Message")
    public void fillReviewFormDetailsProductPage() {
        Logs.info("📝 Filling the Review Form and Verifying the Sended Message");
        final var faker = new Faker();
        final var name = faker.name().fullName();
        final var email = faker.internet().emailAddress();
        final var review = faker.lorem().sentence();
        Logs.info("Filling the Review Form");
        find(nameReviewFormInput).sendKeys(name);
        find(emailReviewFormInput).sendKeys(email);
        find(addReviewFormTextarea).sendKeys(review);
        find(submitFormButton).click();
        Logs.info("Verifying Sended Message");
        softAssert.assertTrue(find(verificationSendMessage).isDisplayed(), "❌ Failure in the Locator verificationSendMessage");
        softAssert.assertEquals(find(verificationSendMessage).getText(), "Thank you for your review.", "❌ Failure in the Expected Messsage");
        softAssert.assertAll();
        Logs.info("✅ The Review Form Verification, the Form Filled and the Message Verification Passed");
    }

}

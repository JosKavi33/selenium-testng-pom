package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.BasePage;
import utilities.Logs;

import java.time.Duration;

public class CartPage extends BasePage {

    private final By shoppingCartTitle = By.xpath("//li[text()='Shopping Cart']");
    private final By messageOfStateCart = By.xpath("//b[text()='Cart is empty!']");
    private final By hereLinkButton = By.xpath("//a[u[text()='here']]");
    private final By productList = By.className("cart_product");
    private final By deleteProductsButton = By.className("cart_quantity_delete");


    @Override
    @Step("⏳ Waiting the CartPage Load")
    public void waitPageToLoad() {
        Logs.info("⏳ Waiting the CartPage Load");
        waitPage(shoppingCartTitle, this.getClass().getSimpleName());
        Logs.info("✅ CartPage is Loaded");
    }

    @Override
    @Step("🔍 Verifying the Cart Page")
    public void verifyPage() {
        Logs.info("🔍 Verifying the CartPage");
        softAssert.assertTrue(find(shoppingCartTitle).isDisplayed(), "❌ Failure in the Locator shoppingCartTitle");
        softAssert.assertTrue(find(messageOfStateCart).isDisplayed(), "❌ Failure in the Locator messageOfStateCart");
        softAssert.assertTrue(find(hereLinkButton).isDisplayed(), "❌ Failure in the Locator hereLinkButton");
        softAssert.assertAll();
        Logs.info("✅ The CartPage Verification Passed.");
    }

    @Step("👉 Making Click in Here link button")
    public void hereLinkClick() {
        Logs.info("👉 Making Click in Here link button");
        find(hereLinkButton).click();
        Logs.info("✅ hereLinkButton Has Been Clicked");
    }

    @Step("🔍 Verifying the href link products")
    public void linkProductsVerify() {
        final var hereLinkLabel = find(hereLinkButton);
        Logs.info("🔍 Verifying the href link products");
        softAssert.assertTrue(find(hereLinkButton).isEnabled(), "❌ Failure for locator availability");
        softAssert.assertEquals(hereLinkLabel.getAttribute("href"), "https://www.automationexercise.com/products", "❌ Failure in the href Link Expected");
        softAssert.assertAll();
        Logs.info("✅ The href Links Products Passed.");
    }

    @Step("🗑️ Deleted Previous Products")
    public void deletePreviousProducts() {
        var productos = findAll(deleteProductsButton);
        for (var element : productos) {
            Logs.info("🗑️ Deleted Previous Products");
            element.click();
            new WebDriverWait(getDriver(), Duration.ofSeconds(3))
                    .until(ExpectedConditions.stalenessOf(element));
        }
        new WebDriverWait(getDriver(), Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(hereLinkButton));

        Logs.info("✅ All Previous Products Deleted.");
    }

    @Step("🔍 Verifying that {0} Products were Added")
    public void verifyAddedProducts(int expectedSize) {
        Logs.info("🔍 Verifying that " + expectedSize + " Products were Added");
        int actualSize = findAll(productList).size();

        Assert.assertEquals(actualSize, expectedSize,
                "❌ Mismatch in Product List Size. Expected: " + expectedSize + ", but found: " + actualSize);

        Logs.info("✅ The Added Products Verification Passed.");
    }


}

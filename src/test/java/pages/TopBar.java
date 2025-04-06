package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.BasePage;
import utilities.Logs;

import java.time.Duration;

public class TopBar extends BasePage {

    private final By loginButton = By.cssSelector("a[href='/login']");
    private final By cartButton = By.cssSelector("a[href='/view_cart']");
    private final By logoutButton = By.xpath("//a[text()=' Logout']");
    private final By deleteAccountButton = By.xpath("//a[text()=' Delete Account']");
    private final By productsButton = By.cssSelector("a[href='/products']");
    private final By contacUsButton = By.cssSelector("a[href='/contact_us']");


    @Override
    @Step("⏳ Waiting the TopBar Load")
    public void waitPageToLoad() {
        Logs.info("⏳ Waiting the TopBar Load");
        waitPage(cartButton, this.getClass().getSimpleName());
        Logs.info("✅ TopBar is Loaded");
    }

    @Override
    @Step("🔍 Verifying the TopBar")
    public void verifyPage() {
        Logs.info("🔍 Verifying the TopBar");
        Assert.assertTrue(find(loginButton).isDisplayed());
        Assert.assertTrue(find(loginButton).isEnabled());
        Assert.assertTrue(find(productsButton).isDisplayed());
        Assert.assertTrue(find(productsButton).isEnabled());
        Assert.assertTrue(find(cartButton).isDisplayed());
        Assert.assertTrue(find(cartButton).isEnabled());
        Assert.assertTrue(find(contacUsButton).isDisplayed());
        Assert.assertTrue(find(contacUsButton).isEnabled());
        softAssert.assertAll();
        Logs.info("✅ The TopBar Verification Passed");
    }

    @Step("🔍 Verifying the Logged TopBar")
    public void verifyAfterLoginPage() {
        Logs.info("🔍 Verifying the Logged TopBar");
        waitElementToBeVisible(logoutButton);
        softAssert.assertTrue(find(logoutButton).isDisplayed());
        softAssert.assertTrue(find(logoutButton).isEnabled());
        softAssert.assertTrue(find(deleteAccountButton).isDisplayed());
        softAssert.assertTrue(find(deleteAccountButton).isEnabled());
        softAssert.assertTrue(find(cartButton).isDisplayed());
        softAssert.assertTrue(find(cartButton).isEnabled());
        softAssert.assertTrue(find(productsButton).isDisplayed());
        softAssert.assertTrue(find(productsButton).isEnabled());
        softAssert.assertAll();
        Logs.info("✅ TopBar after login successfully verified.");
    }

    @Step("👉 Making Click in Login button")
    public void loginButtonClick() {
        Logs.info("👉 Making Click in Login button");
        find(loginButton).click();
        Logs.info("✅ The Login button has Been Clicked");
    }

    @Step("👉 Making Click in Cart button")
    public void cartButtonClick() {
        Logs.info("👉 Making Click in Cart button");
        find(cartButton).click();
        Logs.info("✅ The Cart button has Been Clicked");
    }

    @Step("👉 Making Click in Products button")
    public void productsButtonClick() {
        Logs.info("👉 Making Click in Products button");
        find(productsButton).click();
        Logs.info("✅ The Products button has Been Clicked");
    }

    @Step("👉 Making Click in ContactUs button")
    public void contactUsClick() {
        Logs.info("👉 Making Click in ContacUs button");
        find(contacUsButton).click();
        Logs.info("✅ The ContactUs button has Been Clicked");

    }

    public void waitElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}

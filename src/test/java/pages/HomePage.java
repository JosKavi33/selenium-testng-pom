package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.BasePage;
import utilities.Logs;

public class HomePage extends BasePage {

    private final By itemCarrusel = By.id("recommended-item-carousel");

    @Override
    @Step("⏳ Waiting for HomePage Load")
    public void waitPageToLoad() {
        Logs.info("⏳ Waiting for HomePage Load");
        waitPage(itemCarrusel, this.getClass().getSimpleName());
        Logs.info("✅ HomePage is Loaded");
    }

    @Override
    @Step("🔍 Verifying HomePage")
    public void verifyPage() {
        Logs.info("🔍 Verifying HomePage");
        Assert.assertTrue(find(itemCarrusel).isDisplayed(), "❌ Failure in the itemCarrusel locator");
        Logs.info("✅ The HomePage Verification Passed");
    }

}

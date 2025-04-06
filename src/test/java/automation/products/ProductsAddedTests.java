package automation.products;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductsPage;
import utilities.BaseTest;
import utilities.CommonFlows;

public class ProductsAddedTests extends BaseTest {

    private final CommonFlows commonFlows = new CommonFlows();
    private final ProductsPage productsPage = new ProductsPage();
    private final CartPage cartPage = new CartPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToShoppingCartPageAndDeletePreviousItems();
    }

    @Tag(regression)
    @Tag(smoke)
    @Test(groups = {regression, smoke})
    @Description("Validate that the productPage don't have previuos Products added and loads correctly")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyProductPageTest() {
        productsPage.verifyPage();
    }

    @Tag(regression)
    @Test(groups = {regression})
    @Description("Validate that the products has been added correctly")
    @Severity(SeverityLevel.CRITICAL)
    public void productAddTest() {
        productsPage.addProducts(5);
        cartPage.waitPageToLoad();
        cartPage.verifyAddedProducts(5);
    }
}

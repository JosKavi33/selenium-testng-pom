package automation.products;

import data.CustomDataProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.Tag;
import models.ItemDetails;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductsPage;
import utilities.BaseTest;
import utilities.CommonFlows;
import utilities.Logs;

import java.util.List;

public class ProductsPageTests extends BaseTest {

    private final CommonFlows commonFlows = new CommonFlows();
    private final ProductsPage productsPage = new ProductsPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToProductsPage();
        productsPage.waitPageToLoad();
    }

    @Tag(regression)
    @Tag(smoke)
    @Test(groups = {regression})
    @Description("Validate that the ProductPage loads correctly")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyProductPageTest() {
        productsPage.verifyPage();
    }

    @Tag(regression)
    @Test(groups = {regression}, dataProvider = CustomDataProvider.DP_ITEM_PRICE, dataProviderClass = CustomDataProvider.class)
    @Description("Validate that the Details in Products has correctly")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyPriceDetailProductPageTest(List<ItemDetails> allItems) {
        Logs.info("Verifying all products from Excel in one execution");
        productsPage.verifyNameAndPriceProducts(allItems);
    }
}

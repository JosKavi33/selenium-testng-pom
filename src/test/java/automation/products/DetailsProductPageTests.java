package automation.products;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DetailsProductPage;
import pages.ProductsPage;
import utilities.BaseTest;
import utilities.CommonFlows;

public class DetailsProductPageTests extends BaseTest {

    private final DetailsProductPage detailsProductPage = new DetailsProductPage();
    private final CommonFlows commonFlows = new CommonFlows();
    private final ProductsPage productsPage = new ProductsPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToProductsPage();
    }

    @Tag(regression)
    @Tag(smoke)
    @Test(groups = {regression, smoke})
    @Description("Validate that the DetailProductPage loads correctly")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyDetailProductPageTest() {
        productsPage.firstProductDetailClick();
        detailsProductPage.waitPageToLoad();
        detailsProductPage.verifyPage();
    }

    @Tag(regression)
    @Test(groups = {regression})
    @Description("Validate that the Review as sended correctly")
    @Severity(SeverityLevel.CRITICAL)
    public void verifyReviewDetailProductPageTest() {
        verifyDetailProductPageTest();
        detailsProductPage.fillReviewFormDetailsProductPage();
    }

}

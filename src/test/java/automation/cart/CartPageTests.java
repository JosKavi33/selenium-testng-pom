package automation.cart;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.Tag;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.TopBar;
import utilities.BaseTest;
import utilities.CommonFlows;

public class CartPageTests extends BaseTest {

    private final CommonFlows commonFlows = new CommonFlows();
    private final TopBar topBar = new TopBar();
    private final CartPage cartPage = new CartPage();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        commonFlows.goToHomePage();
        commonFlows.goToShoppingCartPageAndDeletePreviousItems();
    }


    @Tag(regression)
    @Tag(smoke)
    @Test(groups = {regression, smoke})
    @Description("Validate that the Links in the Products are correctly")
    @Severity(SeverityLevel.CRITICAL)
    public void cartTest() {
        topBar.cartButtonClick();
        cartPage.waitPageToLoad();
        cartPage.linkProductsVerify();
    }

}

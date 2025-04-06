package pages;

import data.DataGiver;
import io.qameta.allure.Step;
import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.testng.Assert;
import utilities.BasePage;
import utilities.Logs;

import java.util.Arrays;
import java.util.List;

public class SignupLogin extends BasePage {

    private final By titleLoginForm = By.xpath("//h2[text()='Login to your account']");
    private final By emailLoginInput = By.cssSelector("input[data-qa='login-email']");
    private final By passwordLoginInput = By.cssSelector("input[data-qa='login-password']");
    private final By loginButton = By.cssSelector("button[data-qa='login-button']");

    private final By titleSignUpForm = By.xpath("//h2[text()='New User Signup!']");
    private final By nameSignUpInput = By.cssSelector("input[data-qa='signup-name']");
    private final By emailSignUpInput = By.cssSelector("input[data-qa='signup-email']");
    private final By signUpButton = By.cssSelector("button[data-qa='signup-button']");

    @Override
    @Step("⏳ Waiting for the SignupLoginPage Load")
    public void waitPageToLoad() {
        Logs.info("⏳ Waiting for the SignupLoginPage Load");
        waitPage(loginButton, this.getClass().getSimpleName());
        Assert.assertTrue(find(loginButton).isDisplayed());
        Assert.assertTrue(find(loginButton).isEnabled());
        softAssert.assertAll();
        find(loginButton).click();
        Logs.info("✅ SignupLoginPage is Loaded");
    }

    @Override
    @Step("🔍 Verifying the SignupLoginPage Forms")
    public void verifyPage() {
        Logs.info("🔍 Verifying the SignupLoginPage Forms");
        List<By> elements = Arrays.asList(
                titleLoginForm, emailLoginInput, passwordLoginInput, loginButton,
                titleSignUpForm, nameSignUpInput, emailSignUpInput, signUpButton
        );

        elements.forEach(element -> softAssert.assertTrue(find(element).isDisplayed(), "❌ Failure the Element is not displayed: " + element.toString()));

        softAssert.assertAll();
        Logs.info("✅ The SignupLoginPage Forms Verification Passed");

    }

    @Step("📝 Filling the SignUp Form")
    public void fillSignUp() {

        Logs.info("📝 Filling the SignUp Form");
        final var faker = new Faker();

        Logs.info("📝 Writing Name in SignUp");
        find(nameSignUpInput).sendKeys(faker.name().name());

        Logs.info("📝 Writing Email in SignUp");
        find(emailSignUpInput).sendKeys(faker.internet().emailAddress());

        Logs.info("👉 Making Click in SignUp");
        find(signUpButton).click();
        Logs.info("✅ The SignUp Form has Been Filled and Continue");
    }

    @Step("📝 Filling the Account Login")
    public void fillLogin() {

        Logs.info("📝 Filling the Login Form");
        final var credentials = DataGiver.getValidCredentials();

        Logs.info("📝 Writing Email Address in Login");
        find(emailLoginInput).sendKeys(credentials.getEmail());

        Logs.info("📝 Writing Email in Login");
        find(passwordLoginInput).sendKeys(credentials.getPassword());

        Logs.info("👉 Making Click in Login");
        find(loginButton).click();
        Logs.info("✅ The Login Form has Been Filled and Continue");
    }
}

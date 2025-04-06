package pages;

import io.qameta.allure.Step;
import net.datafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utilities.BasePage;
import utilities.Logs;

import java.util.Arrays;
import java.util.List;

public class AccountInformationPage extends BasePage {

    //Account Information Form
    private final By accountInformationTitle = By.xpath("//b[text()='Enter Account Information']");
    private final By genderMaleInput = By.id("id_gender1");
    private final By genderFemaleInput = By.id("id_gender2");
    private final By nameInput = By.id("name");
    private final By emailInput = By.id("email");
    private final By passwordInput = By.id("password");
    private final By daysSelect = By.id("days");
    private final By monthsSelect = By.id("months");
    private final By yearsSelect = By.id("years");

    //Address Information Form
    private final By addresInformationTitle = By.xpath("//b[text()='Address Information']");
    private final By firstNameInput = By.id("first_name");
    private final By lastNameInput = By.id("last_name");
    private final By companyInput = By.id("company");
    private final By firstAddressInput = By.id("address1");
    private final By secondAddressInput = By.id("address2");
    private final By countrySelect = By.id("country");
    private final By stateInput = By.id("state");
    private final By cityInput = By.id("city");
    private final By zipcodeInput = By.id("zipcode");
    private final By mobilNumberInput = By.id("mobile_number");
    private final By createAcountButton = By.cssSelector("button[data-qa='create-account']");

    @Override
    @Step("⏳ Waiting for the AccountInformationPage Form to Load")
    public void waitPageToLoad() {
        Logs.info("⏳ Waiting for the AccountInformationPage Form to Load");
        waitPage(accountInformationTitle, this.getClass().getSimpleName());
        Logs.info("✅ AccountInformationPage is Loaded");
    }

    @Override
    @Step("🔍 Verifying the AccountInformationPage Form")
    public void verifyPage() {
        Logs.info("🔍 Verifying the AccountInformationPage Form");
        List<By> elements = Arrays.asList(
                accountInformationTitle, genderMaleInput, genderFemaleInput, nameInput, emailInput, passwordInput,
                daysSelect, monthsSelect, yearsSelect, addresInformationTitle, firstNameInput, lastNameInput, companyInput,
                firstAddressInput, secondAddressInput, countrySelect, stateInput, cityInput, zipcodeInput,
                mobilNumberInput, createAcountButton
        );
        elements.forEach(element -> softAssert.assertTrue(find(element).isDisplayed(), "❌ Failure the Element is not displayed: " + element.toString()));
        softAssert.assertAll();
        Logs.info("✅ The AccountInformationPage Verification Passed");
    }

    @Step("📝  Filling the Form")
    public void fillForms() {
        Logs.debug("📝  Filling the Form");
        final var faker = new Faker();

        Logs.info("🚻 Selecting Gender in AccountInformationPage Form");
        if (faker.bool().bool()) {
            find(genderMaleInput).click();
        } else {
            find(genderFemaleInput).click();
        }

        Logs.info("🔐 Writing Password in AccountInformationPage Form");
        find(passwordInput).sendKeys(faker.internet().password());

        Logs.info("📅 Select Day of Birth in AccountInformationPage Form");
        Select dayDropdown = new Select(find(daysSelect));
        dayDropdown.selectByValue(String.valueOf(faker.number().numberBetween(1, 31)));

        Logs.info("📅 Select Month of Birth in AccountInformationPage Form");
        Select monthDropdown = new Select(find(monthsSelect));
        monthDropdown.selectByIndex(faker.number().numberBetween(1, 12));

        Logs.info("📅 Select Year of Birth in AccountInformationPage Form");
        Select yearDropdown = new Select(find(yearsSelect));
        yearDropdown.selectByValue(String.valueOf(faker.number().numberBetween(1900, 2021)));

        Logs.info("📝 Writing FirstName in Address Information Form");
        find(firstNameInput).sendKeys(faker.name().firstName());

        Logs.info("📝 Writing LastName in Address Information Form");
        find(lastNameInput).sendKeys(faker.name().lastName());

        Logs.info("📝 Writing Company in Address Information Form");
        find(companyInput).sendKeys(faker.company().name());

        Logs.info("📝 Writing Address1 in Address Information Form");
        find(firstAddressInput).sendKeys(faker.address().streetAddress());

        Logs.info("📝 Writing Address2 in Address Information Form");
        find(secondAddressInput).sendKeys(faker.address().secondaryAddress());

        Logs.info("🌎 Selecting Country in Address Information Form");
        Select countryDropdown = new Select(find(countrySelect));
        String[] availableCountries = {"India", "United States", "Canada", "Australia", "Israel", "New Zealand", "Singapore"};
        int randomIndex = faker.random().nextInt(availableCountries.length);
        String selectedCountry = availableCountries[randomIndex];
        countryDropdown.selectByValue(selectedCountry);

        Logs.info("📝 Writing State in Address Information Form");
        find(stateInput).sendKeys(faker.address().state());

        Logs.info("📝 Writing City in Address Information Form");
        find(cityInput).sendKeys(faker.address().city());

        Logs.info("📝 Writing ZipCode in Address Information Form");
        find(zipcodeInput).sendKeys(faker.address().zipCode());

        Logs.info("📝 Writing MobileNumber in Address Information Form");
        find(mobilNumberInput).sendKeys(faker.phoneNumber().cellPhone());

        Logs.info("👉 Clicking Create Account Button");
        find(createAcountButton).click();
        Logs.info("✅ The Form has Been Filled");
    }

}

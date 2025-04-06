package utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {

    private final boolean runServer = System.getenv("JOB_NAME") != null;

    public void buildDriver() {
        if (runServer) {
            buildRemoteDriver();
        } else {
            buildLocalDriver();
        }
    }

    public void killDriver() {
        Logs.debug("🛑 Killing the WebDriver");
        var driver = WebDriverProvider.get();
        if (driver != null) {
            try {
                driver.quit();
                Logs.info("✅ WebDriver closed successfully");
            } catch (Exception e) {
                Logs.error("❌ Error while quitting WebDriver: " + e.getMessage());
            }
        } else {
            Logs.debug("⚠️ WebDriver is null, nothing to kill");
        }
        WebDriverProvider.remove();
    }


    private void buildLocalDriver() {

        final var headleesMode = System.getProperty("headless") != null;
        var browserProperty = System.getProperty("browser");

        if (browserProperty == null) {
            Logs.debug("Assigning default driver to Edge");
            browserProperty = "EDGE";
        }

        final var browser = BROWSER.valueOf(browserProperty.toUpperCase());

        Logs.debug("🔧 Initializing local driver: %s | Headless: %b", browserProperty, headleesMode);

        final var driver = switch (browser) {

            case CHROME -> {
                final var chromeOptions = new ChromeOptions();
                if (headleesMode) {
                    chromeOptions.addArguments("--headless=new", "--disable-extensions");
                }
                yield new ChromeDriver(chromeOptions);
            }

            case EDGE -> {
                final var edgeOptions = new EdgeOptions();
                if (headleesMode) {
                    edgeOptions.addArguments("--headless=new", "--disable-extensions");
                }
                yield new EdgeDriver(edgeOptions);
            }

            case FIREFOX -> {
                final var firefoxOptions = new FirefoxOptions();
                if (headleesMode) {
                    firefoxOptions.addArguments("--headless");
                }
                yield new FirefoxDriver(firefoxOptions);
            }

            case SAFARI -> new SafariDriver();
        };

        Logs.debug("🖥️ Maximizing window and clearing cookies");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        Logs.debug("✅ Assigning Driver to the Webdriver Provider");
        WebDriverProvider.set(driver);
    }

    public void buildRemoteDriver() {
        Logs.info("Remote driver setup not yet implemented");
        // TODO: Add remote driver config for CI
    }

    private enum BROWSER {
        CHROME,
        FIREFOX,
        EDGE,
        SAFARI

    }

}

package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver basedriver;

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getProperty("browser");
        String baseUrl = ConfigReader.getProperty("baseUrl");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            // Disable Chrome popups & password manager
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("profile.default_content_setting_values.popups", 0);
            options.setExperimentalOption("prefs", prefs);

            // Disable browser UI elements and startup popups
            options.addArguments(
                    "--incognito",
                    "--disable-save-password-bubble",
                    "--disable-features=AutofillServerCommunication,PasswordManagerOnboarding,PasswordImport,PasswordChange,AutofillEnableAccountWalletStorage",
                    "--disable-extensions",
                    "--disable-popup-blocking",
                    "--disable-notifications",
                    "--disable-infobars",
                    "--disable-blink-features=AutomationControlled",
                    "--start-maximized"
            );

            basedriver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            basedriver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            basedriver = new EdgeDriver();

        } else {
            throw new RuntimeException("❌ Browser not supported: " + browser);
        }

        basedriver.manage().window().maximize();
        basedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        if (baseUrl != null && !baseUrl.isEmpty()) {
            basedriver.get(baseUrl);
        }

        System.out.println("🧩 Browser launched → " + browser.toUpperCase());
        System.out.println("🌐 URL opened → " + baseUrl);
    }

    public WebDriver getDriver() {
        return basedriver;
    }

    @AfterMethod
    public void tearDown() {
        if (basedriver != null) {
            basedriver.quit();
            System.out.println("🧹 Browser closed successfully!");
        }
    }
}

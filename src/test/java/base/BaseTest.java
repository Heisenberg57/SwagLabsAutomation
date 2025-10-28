package base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import  io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test; // For the @Test annotation, marking methods as test methods.
import org.testng.Assert; // For various assertion methods like assertEquals, assertTrue, etc.
import utils.ConfigReader;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    protected WebDriver basedriver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();

        // Disable all password / credential prompts
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("profile.default_content_setting_values.popups", 0);
        options.setExperimentalOption("prefs", prefs);

        // Hardcore disable everything Chrome might spawn
        options.addArguments("--incognito");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-features=AutofillServerCommunication,PasswordManagerOnboarding,PasswordImport,PasswordChange,AutofillEnableAccountWalletStorage");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--start-maximized");

        basedriver = new ChromeDriver(options);
        basedriver.manage().window().maximize();
        basedriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        System.out.println("Browser launched succesfully");
        System.setProperty("testng.reporter.output", "test-output");
        String browser = ConfigReader.getProperty("browser");
        String baseUrl = ConfigReader.getProperty("baseUrl");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            basedriver = new ChromeDriver();
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
        basedriver.get(baseUrl);

        System.out.println("🌐 Browser launched at " + baseUrl);


    }

    public WebDriver getDriver() {
        return basedriver;

    }

    @AfterMethod
    public void tearDown() {
        if (basedriver != null) {
            basedriver.quit();
            System.out.println("You quit da browser succesfully");
        }
    }
}

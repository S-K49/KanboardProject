package ui.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.steps.LoginPage;

public class BaseTest {
    protected WebDriver driver;

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    @BeforeMethod(alwaysRun = true)

    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        System.out.println("Close driver");
        driver.close();
        driver.quit();
    }
}

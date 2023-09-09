import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCases {
    WebDriver driver;
    HomPageObjects home;
    String url = "";
    @BeforeTest
    public void beforeTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        home = new HomPageObjects(driver);
        url = "https://automationexercise.com/";
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(url);
    }
    @Test(priority = 0)
    public void verifyHome(){
        boolean isDisplayed = home.isHomePageVisible();
        Assert.assertTrue(isDisplayed);

    }
    @Test(priority = 1)
    public void scroll(){
        home.scrollDown();
    }
    @Test(priority = 2)
    public void subscribeLabels(){
        System.out.println(home.Subscribe());
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}

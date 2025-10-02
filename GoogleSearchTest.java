package smoke;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchTest {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void search(){
        driver.get("https://www.google.com/");
        WebElement q = driver.findElement(By.name("q"));
        q.sendKeys("Canan QA" + Keys.ENTER);
        assert driver.getTitle().toLowerCase().contains("canan qa");
    }

    @AfterClass
    public void tearDown(){
        if (driver != null) driver.quit();
    }
}

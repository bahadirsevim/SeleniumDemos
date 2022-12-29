import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class scroll_test {
    WebDriver driver;

    @BeforeAll
    void setup(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();
    }

    @Test
    void scrollingTest() throws Exception{
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        // Down
        javascriptExecutor.executeScript("window.scrollBy(0,500)");
        // Up
        javascriptExecutor.executeScript("window.scrollBy(0,-500)");
    }

    @AfterAll
    void tearDown(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}

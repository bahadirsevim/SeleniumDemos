import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class windows_tabs_test {
    WebDriver driver;

    @BeforeAll
    void setup(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();
    }

    @Test
    void SwitchToTabsTest(){
        WebElement tabButton = driver.findElement(By.id("tabButton"));
        tabButton.click();

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        System.out.println(tabs.size());

        driver.switchTo().window(tabs.get(1));
        System.out.println(driver.getCurrentUrl());

        WebElement sampleHeading = driver.findElement(By.id("sampleHeading"));
        System.out.println(sampleHeading.getText());
    }

    @AfterAll
    void tearDown(){
        driver.close();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

}

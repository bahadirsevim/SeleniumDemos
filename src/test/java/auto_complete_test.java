import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class auto_complete_test {
    WebDriver driver;

    @BeforeAll
    void setup(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://demoqa.com/auto-complete");
        driver.manage().window().maximize();
    }

    @Test
    void autoCompleteTest(){
        driver.findElement(By.tagName("html")).sendKeys(Keys.SPACE);
        WebElement input = driver.findElement(By.id("autoCompleteSingleInput"));
        input.sendKeys("R");

        List<WebElement> suggestions = driver.findElements(By.cssSelector("div.auto-complete__option"));
        for (WebElement suggestion : suggestions){
            String text = suggestion.getText();
            /*
            if(text.toLowerCase().contains("r")){
                System.out.println(text+" has r letter");
            }
             */

            if (text.equalsIgnoreCase("red")){
                suggestion.click();
                break;
            }
        }
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

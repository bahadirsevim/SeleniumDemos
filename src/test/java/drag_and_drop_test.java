import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class drag_and_drop_test {
    WebDriver driver;

    @BeforeAll
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        driver.manage().window().maximize();
    }

    @Test
    void dragAndDropTest(){
        driver.findElement(By.tagName("html")).sendKeys(Keys.SPACE);

        WebElement oslo = driver.findElement(By.id("box1"));
        WebElement stockholm = driver.findElement(By.id("box2"));
        WebElement washington = driver.findElement(By.id("box3"));
        WebElement copenhagen = driver.findElement(By.id("box4"));
        WebElement seoul = driver.findElement(By.id("box5"));
        WebElement rome = driver.findElement(By.id("box6"));
        WebElement madrid = driver.findElement(By.id("box7"));

        WebElement norway = driver.findElement(By.id("box101"));
        WebElement sweden = driver.findElement(By.id("box102"));
        WebElement unitedStates = driver.findElement(By.id("box103"));
        WebElement denmark = driver.findElement(By.id("box104"));
        WebElement southKorea = driver.findElement(By.id("box105"));
        WebElement italy = driver.findElement(By.id("box106"));
        WebElement spain = driver.findElement(By.id("box107"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(rome, italy).build().perform();
        actions.dragAndDrop(seoul, southKorea).build().perform();
        actions.dragAndDrop(stockholm, sweden).build().perform();
        actions.dragAndDrop(oslo, norway).build().perform();
        actions.dragAndDrop(madrid, spain).build().perform();
        actions.dragAndDrop(copenhagen, denmark).build().perform();
        actions.dragAndDrop(washington, unitedStates).build().perform();
    }

    @AfterAll
    void tearDown(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // driver.quit();
    }

}

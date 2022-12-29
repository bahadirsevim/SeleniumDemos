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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class date_picker_test {
    WebDriver driver;

    @BeforeAll
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/date-picker");
        driver.manage().window().maximize();
    }

    @Test
    void datePickerTest(){
        WebElement dateSelection = driver.findElement(By.id("datePickerMonthYearInput"));
        dateSelection.click();

        WebElement monthElement = driver.findElement(By.className("react-datepicker__month-select"));
        Select select = new Select(monthElement);
        select.selectByVisibleText("December");

        WebElement yearElement = driver.findElement(By.className(("react-datepicker__year-select")));
        select = new Select(yearElement);
        select.selectByVisibleText("1995");

        List<WebElement> dayElements = driver.findElements(By.className("react-datepicker__day"));
        for (WebElement dayElement : dayElements){
            String text = dayElement.getText();
            if(text.equals("19")){
                dayElement.click();
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
        // driver.quit();
    }
}

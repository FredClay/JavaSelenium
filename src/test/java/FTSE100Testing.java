import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FTSE100Testing {

    private RemoteWebDriver driver;

    @BeforeEach
    void setup() {
        this.driver = new EdgeDriver();
        this.driver.manage().window().maximize();
    }

    @Test
    void testRisers() {
        this.driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100");

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));

        WebElement acceptCookiesButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#acceptCookieButton")));
        acceptCookiesButton.click();

        WebElement risersButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#view-constituents > ul > li:nth-child(2) > a")));
        risersButton.click();


        WebElement nameOfLargestRiser = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#ls-row-RS1-L > td.name-col.align-left > a")));

        assertEquals("RS Group plc", nameOfLargestRiser.getText());
    }

    @Test
    void testFallers() {
        this.driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100");

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));

        WebElement acceptCookiesButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#acceptCookieButton")));
        acceptCookiesButton.click();

        WebElement fallersButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#view-constituents > ul > li:nth-child(3) > a")));
        fallersButton.click();


        WebElement nameOfLargestFaller = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#ls-row-HLN-L > td.name-col.align-left > a")));

        assertEquals("Haleon plc", nameOfLargestFaller.getText());
    }

    @AfterEach
    void tearDown() {
        this.driver.close();
    }

}

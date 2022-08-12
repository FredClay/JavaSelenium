import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumDriverTesting {

    private RemoteWebDriver driver;

    @BeforeEach
    void setup() {
        this.driver = new EdgeDriver();
    }

    @Test
    void testSearch() {
        this.driver.get("http://automationpractice.com/index.php");
        WebElement searchBox = this.driver.findElement(By.id("search_query_top"));
        searchBox.sendKeys("dress");
        searchBox.sendKeys(Keys.ENTER);

        WebElement topResult = this.driver
                .findElement(By.cssSelector("#center_column > ul > li:nth-child(1) > div > div.right-block > h5 > a"));

        assertEquals("Printed Summer Dress", topResult.getText());

    }

    @Test
    void checkOutTest() {
        this.driver.get("http://automationpractice.com/index.php");
        WebElement searchBox = this.driver.findElement(By.id("search_query_top"));
        searchBox.sendKeys("dress");
        searchBox.sendKeys(Keys.ENTER);

        WebElement topResult = this.driver
                .findElement(By.cssSelector("#center_column > ul > li:nth-child(1) > div > div.right-block > h5 > a"));
        Actions action = new Actions(this.driver);
        action.moveToElement(topResult);

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));

        WebElement addToCartBtn = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#center_column > ul > li:nth-child(1) > div > div.right-block > div.button-container > " +
                        "a.button.ajax_add_to_cart_button.btn.btn-default")));

        addToCartBtn.click();

        WebElement checkField = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_product.col-xs-12.col-md-6 > h2")));
        assertEquals("Product successfully added to your shopping cart", checkField.getText());
    }

    @AfterEach
    void tearDown() {
        this.driver.close();
    }

}

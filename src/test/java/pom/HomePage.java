package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(css = "#acceptCookieButton")
    private WebElement acceptCookiesButton;

    @FindBy(css = "#view-constituents > ul > li:nth-child(2) > a")
    private WebElement risersButton;

    @FindBy(css = "#view-constituents > ul > li:nth-child(3) > a")
    private WebElement fallersButton;

    public void acceptCookies() {
        this.acceptCookiesButton.click();
    }

    public void viewRisers() {
        this.risersButton.click();
    }

    public void viewFallers() {
        this.fallersButton.click();
    }


}

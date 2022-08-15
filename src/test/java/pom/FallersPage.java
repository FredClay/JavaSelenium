package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FallersPage {

    @FindBy(css = "#ls-row-HLN-L > td.name-col.align-left > a")
    private WebElement topFaller;

    public String getTopFaller() {
        return this.topFaller.getText();
    }

}

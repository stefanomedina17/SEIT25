package locators;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class BasicAuth {

    @FindBy(css = "p")
    public WebElement txt_Congratulations;
}

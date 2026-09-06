package locators;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Home{

    @FindBy(css = "h1")
    public WebElement titleHome;

    //a[contains(text(), '{string}')]
    @FindBy(css = "li")
    public List<WebElement> listHome;
}
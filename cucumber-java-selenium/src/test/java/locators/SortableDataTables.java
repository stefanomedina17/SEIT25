package locators;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SortableDataTables {

    @FindBy(id = "table1")
    public WebElement tblExample1;

    @FindBy(xpath = "//table[@id='table1']/thead//th")
    public List<WebElement> tblHeaders;

    @FindBy(xpath = "//table[@id='table1']/tbody/tr")
    public List<WebElement> tblBody;
}

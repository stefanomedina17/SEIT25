package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

import locators.Home;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class page_Home extends Page {

  public Home locatorHome;

  public page_Home(ChromeDriver driver) {
    super(driver);
    this.locatorHome = new Home();

    PageFactory.initElements(driver, this.locatorHome);
  }

  public boolean isHomePageLoaded() {
    System.out.println("----Checking if page is loaded----");
    boolean isTitleVisible = locatorHome.titleHome.isDisplayed();

    if(isTitleVisible) {
      System.out.println("Homepage title is : " + locatorHome.titleHome.getText());
      System.out.println("----Page loaded successfully----");
    }
    else{
      System.out.println("Homepage title is not visible.");
      System.out.println("----Page did not load successfully----");
    }
    return isTitleVisible;
  }

  public List<String> getHomeList(){
    int listSize = locatorHome.listHome.size();
    List<String> homeList = new ArrayList<>(listSize);

    System.out.println("----Retrieving list values----");
    for(int i = 0; i < listSize; i++){
        homeList.add(locatorHome.listHome.get(i).getText());
    }
    System.out.println(homeList);
    System.out.println("----List values retrieved----");
    System.out.println("Total Items in List: " + homeList.size());

    return homeList;
  }

  public void clickListOption(String example){
    int listSize = locatorHome.listHome.size();
    System.out.println("----Locating Basic Auth----");

    for(int i = 0; i < listSize; i++){
      WebElement option = locatorHome.listHome.get(i);

      if(option.getText().contains(example)){
        option.findElement(By.tagName("a")).click();
        waitForPageLoad();
        System.out.println("----Option was clicked----");
        break;
      }
    }
  }

  public void refresh() {
    driver.navigate().refresh();
    System.out.println("Refreshed page");
  }
}

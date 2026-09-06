package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

import locators.Home;

import java.util.ArrayList;
import java.util.List;

public class page_Home extends Page {

  public Home locatorHome;

  public page_Home(ChromeDriver driver) {
    super(driver);
    this.locatorHome = new Home();

    PageFactory.initElements(driver, this.locatorHome);
  }

  public void homePageLoad() {
    System.out.println("Checking if page is loaded......");
    boolean isTitleVisible = locatorHome.headerHome.isDisplayed();

    if(isTitleVisible) {
      System.out.println("Homepage title is : " + locatorHome.headerHome.getText());
      System.out.println("Page loaded successfully");
    }
    else{
      System.out.println("Homepage title is not visible.");
      System.out.println("Page did not load successfully");
    }
  }

  public List<String> getActualHomeList(){
    int listSize = locatorHome.listOptions.size();
    List<String> homeList = new ArrayList<>(listSize);

    System.out.println("Retrieving list values......");
    for(int i = 0; i < listSize; i++){
        homeList.add(locatorHome.listOptions.get(i).getText());
    }
    System.out.println(homeList);
    System.out.println("List values retrieved......");
    System.out.println("Total Items in List: " + homeList.size());

    return homeList;
  }

  public void clickListOption(String example){
    int listSize = locatorHome.listOptions.size();
    System.out.println("Locating element......");

    for(int i = 0; i < listSize; i++){
      WebElement option = locatorHome.listOptions.get(i);

      if(option.getText().contains(example)){
        System.out.println("Element found......");
        option.findElement(By.tagName("a")).click();
        waitForPageLoad();
        System.out.println("Element was clicked......");
        break;
      }
    }
  }

  public List<String> getExpectedHomeList(){
    List<String> expectedList = new ArrayList<>();

    expectedList.add("A/B Testing");
    expectedList.add("Add/Remove Elements");
    expectedList.add("Basic Auth (user and pass: admin)");
    expectedList.add("Broken Images");
    expectedList.add("Challenging DOM");
    expectedList.add("Context Menu");
    expectedList.add("Digest Authentication (user and pass: admin)");
    expectedList.add("Disappearing Elements");
    expectedList.add("Drag and Drop");
    expectedList.add("Dropdown");
    expectedList.add("Dynamic Content");
    expectedList.add("Dynamic Controls");
    expectedList.add("Dynamic Loading");
    expectedList.add("Entry Ad");
    expectedList.add("Exit Intent");
    expectedList.add("File Download");
    expectedList.add("File Upload");
    expectedList.add("Floating Menu");
    expectedList.add("Forgot Password");
    expectedList.add("Form Authentication");
    expectedList.add("Geolocation");
    expectedList.add("Horizontal Slider");
    expectedList.add("Infinite Scroll");
    expectedList.add("Inputs");
    expectedList.add("JavaScript Alerts");
    expectedList.add("JavaScript onload event error");
    expectedList.add("Key Presses");
    expectedList.add("Large & Deep DOM");
    expectedList.add("Multiple Windows");
    expectedList.add("Nested Frames");
    expectedList.add("Notification Messages");
    expectedList.add("Redirect Link");
    expectedList.add("Secure File Download");
    expectedList.add("Shadow DOM");
    expectedList.add("Shifting Content");
    expectedList.add("Slow Resources");
    expectedList.add("Sortable Data Tables");
    expectedList.add("Typos");
    expectedList.add("Redirect Link");
    expectedList.add("WYSIWYG Editor");

    return expectedList;
  }

  public void areListValuesMatched(List<String> actualList, List<String> expectedList){
    Assertions.assertEquals(actualList, expectedList, "Results do not match");
  }
}

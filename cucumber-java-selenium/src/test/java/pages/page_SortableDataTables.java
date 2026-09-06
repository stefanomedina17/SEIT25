package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import locators.SortableDataTables;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class page_SortableDataTables extends Page {

    public SortableDataTables locatorSortableDataTables;

    public page_SortableDataTables(ChromeDriver driver) {
        super(driver);
        this.locatorSortableDataTables = new SortableDataTables();

        PageFactory.initElements(driver, this.locatorSortableDataTables);
    }

    public void dataTablesPageLoad() {
        System.out.println("Checking if page is loaded......");
        boolean isTable1Visible = locatorSortableDataTables.tblExample1.isDisplayed();

        if(isTable1Visible) {
            System.out.println("Table 1 is visible");
        }
        else{
            System.out.println("Table 1 not found");
        }
    }

    public List<Map<String, String>> getActualTable1Values(){
        int headerSize = locatorSortableDataTables.tblHeaders.size();
        List<String> thElements = new ArrayList<>(headerSize);

        System.out.println("Retrieving header values......");
        for(int i = 0; i < headerSize - 1; i++){
            thElements.add(locatorSortableDataTables.tblHeaders.get(i).getText());
        }
        System.out.println("Header values retrieved: " + thElements);

        List<Map<String, String>> trElements = new ArrayList<>();

        System.out.println("Retrieving body data......");
        for (WebElement tr : locatorSortableDataTables.tblBody) {
            List<WebElement> cells = tr.findElements(By.tagName("td"));
            Map<String, String> rowData = new LinkedHashMap<>();

            for (int i = 0; i < thElements.size(); i++) {
                rowData.put(thElements.get(i), cells.get(i).getText());
            }

            trElements.add(rowData);
        }

        System.out.println("Table Data: " + trElements);
        return trElements;
    }

    public List<Map<String, String>> getExpectedTable1Values(){
        List<Map<String, String>> expectedValues = new ArrayList<>();

        Map<String, String> firstRow = new LinkedHashMap<>();
        firstRow.put("Last Name", "Smith");
        firstRow.put("First Name", "John");
        firstRow.put("Email", "jsmith@gmail.com");
        firstRow.put("Due", "$50.00");
        firstRow.put("Web Site", "http://www.jsmith.com");
        expectedValues.add(firstRow);

        Map<String, String> secondRow = new LinkedHashMap<>();
        secondRow.put("Last Name", "Bach");
        secondRow.put("First Name", "Frank");
        secondRow.put("Email", "fbach@yahoo.com");
        secondRow.put("Due", "$51.00");
        secondRow.put("Web Site", "http://www.frank.com");
        expectedValues.add(secondRow);

        Map<String, String> thirdRow = new LinkedHashMap<>();
        thirdRow.put("Last Name", "Doe");
        thirdRow.put("First Name", "Jason");
        thirdRow.put("Email", "jdoe@hotmail.com");
        thirdRow.put("Due", "$100.00");
        thirdRow.put("Web Site", "http://www.jdoe.com");
        expectedValues.add(thirdRow);

        Map<String, String> fourthRow = new LinkedHashMap<>();
        fourthRow.put("Last Name", "Conway");
        fourthRow.put("First Name", "Tim");
        fourthRow.put("Email", "tconway@earthlink.net");
        fourthRow.put("Due", "$50.00");
        fourthRow.put("Web Site", "http://www.timconway.com");
        expectedValues.add(fourthRow);

        return expectedValues;
    }

    public void areTableDataMatched(List<Map<String, String>> actualTableValues, List<Map<String, String>> expectedTableValues){
        Assertions.assertEquals(expectedTableValues, actualTableValues, "Table values do not match");
    }
}

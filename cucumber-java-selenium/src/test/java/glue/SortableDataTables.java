package glue;

import core.Context;
import core.Manager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.page_SortableDataTables;

import java.util.List;
import java.util.Map;

public class SortableDataTables extends Context {

    public page_SortableDataTables dataTablesPage;

    public SortableDataTables(Manager manager) {
        super(manager);
        this.dataTablesPage = new page_SortableDataTables(manager.getDriver());
    }

    @And("the Example1 Table is visible")
    public void isTable1Visible() {
        dataTablesPage.dataTablesPageLoad();
    }

    @Then("the actual table displays the expected results")
    public void verifyTableValuesMatch(){
        List<Map<String, String>> actualTable1Data = dataTablesPage.getActualTable1Values();
        List<Map<String, String>> expectedTable1Data = dataTablesPage.getExpectedTable1Values();

        dataTablesPage.areTableDataMatched(actualTable1Data, expectedTable1Data);
    }
}

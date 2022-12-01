package com.library.step_definitions;

import com.library.pages.BookPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.Driver;
import java.util.List;

public class US_3_Isa_StepDefs {
    LoginPage loginPage=new LoginPage();
    BookPage bookPage=new BookPage();
    List<String> actualCategoryList;
   // List<String> actualCategoryList;

    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {
        loginPage.login("librarian43@library","9Wa02cAu");

    }
    @When("I navigate to {string} page")
    public void i_navigate_to_page(String moduleName) {

        new LoginPage().navigateModule(moduleName);

    }
    @When("I take all book categories in UI")
    public void i_take_all_book_categories_in_ui() {
        actualCategoryList=BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);
        actualCategoryList.remove(0);
        System.out.println("actualCategoryList = " + actualCategoryList);

    }
    @When("I execute query to get book categories")
    public void i_execute_query_to_get_book_categories() {

        String query="select * from book_categories";

        //run query to get all categories from Database
        DB_Util.runQuery(query);

        //store data
        List<String> expectedCategoryList= DB_Util.getColumnDataAsList(3);

    }
    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {

        String query="select name from book_categories";

        //run query to get all categories from Database
        DB_Util.runQuery(query);

        //store data
        List<String> expectedCategoryList= DB_Util.getColumnDataAsList(1);



        // Assertions
        Assert.assertEquals(expectedCategoryList,actualCategoryList);


    }

}

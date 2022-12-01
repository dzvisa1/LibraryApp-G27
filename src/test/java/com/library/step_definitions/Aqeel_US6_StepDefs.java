package com.library.step_definitions;

import com.library.pages.BookPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class Aqeel_US6_StepDefs {
    BookPage bookPage = new BookPage();

    @When("the librarian click to add book")
    public void the_librarian_click_to_add_book() {
        bookPage.addBook.click();

    }
    @When("the librarian enter book name {string}")
    public void the_librarian_enter_book_name(String string) {
        bookPage.bookName.sendKeys(string);

    }
    @When("the librarian enter ISBN {string}")
    public void the_librarian_enter_isbn(String string) {
        bookPage.isbn.sendKeys(string);

    }
    @When("the librarian enter year {string}")
    public void the_librarian_enter_year(String string) {
        bookPage.year.sendKeys(string);
    }
    @When("the librarian enter author {string}")
    public void the_librarian_enter_author(String string) {
        bookPage.author.sendKeys(string);

    }
    @When("the librarian choose the book category {string}")
    public void the_librarian_choose_the_book_category(String string) {
        Select select = new Select(bookPage.bookCategory);
        select.selectByVisibleText("Drama");

    }
    @When("the librarian click to save changes")
    public void the_librarian_click_to_save_changes() {
      bookPage.saveChangesButton.click();

    }
    @Then("the librarian verify new book by {string}")
    public void the_librarian_verify_new_book_by(String string) {



    }
    @Then("the librarian verify new book from database by {string}")
    public void the_librarian_verify_new_book_from_database_by(String string) {

    }

}

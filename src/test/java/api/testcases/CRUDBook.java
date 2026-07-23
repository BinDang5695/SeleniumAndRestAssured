package api.testcases;

import settings.globals.EndPointGlobal;
import settings.helpers.JsonHelper;
import settings.keywords.ApiKeyword;
import api.common.BaseTest;
import api.common.VerifyDataBookBody;
import api.listeners.TestListener;
import models.api.Book;
import settings.utils.LogUtils;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;

@Listeners(TestListener.class)
public class CRUDBook extends BaseTest {

    private Book book;
    String dataFile = "src/test/resources/filetest/CreateBook.json";

    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Test")
    @Feature("Create, verify")
    @Story("Book")
    @Description("Add new Book and verify response of created Book")
    @Test(priority = 1)
    public void testAddNewBook() {

        book = testdata.api.Book.getDataToCreateBook();

        JsonHelper.updateValueJsonFile(dataFile, book);

        Response response = ApiKeyword.post(EndPointGlobal.EP_BOOK, new File(dataFile));

        JsonHelper.updateValueJsonFile(dataFile, book);

        VerifyDataBookBody.verifyResponseSuccess(response, book, 200);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Test")
    @Feature("Read, verify")
    @Story("Book")
    @Description("Read Book and verify response of created Book")
    @Test(priority = 2)
    public void getBook(){
        LogUtils.info("ID: " + book.getId());

        Response response = ApiKeyword.get(EndPointGlobal.EP_BOOK + "/" + book.getId());

        VerifyDataBookBody.verifyResponseSuccess(response, book, 200);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Test")
    @Feature("Update, verify")
    @Story("Book")
    @Description("Update Book and verify response of updated Book")
    @Test(priority = 3)
    public void putBook() throws Exception {

        book = testdata.api.Book.createUpdatedBook(book);

        JsonHelper.updateValueJsonFile(dataFile, book);

        String jsonBody = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(dataFile)));

        Response response = ApiKeyword.put(EndPointGlobal.EP_BOOK + "/" + book.getId(), jsonBody);

        VerifyDataBookBody.verifyResponseSuccess(response, book, 200);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Test")
    @Feature("Read, verify")
    @Story("Book")
    @Description("Read Book and verify response of updated Book")
    @Test(priority = 4)
    public void getBookAfterPut(){
        LogUtils.info("ID: " + book.getId());

        Response response = ApiKeyword.get(EndPointGlobal.EP_BOOK + "/" + book.getId());

        VerifyDataBookBody.verifyResponseSuccess(response, book, 200);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Test")
    @Feature("Delete, verify")
    @Story("Book")
    @Description("Delete Book and verify response of updated Book")
    @Test(priority = 5)
    public void deleteBook(){

        Response response = ApiKeyword.delete(EndPointGlobal.EP_BOOK + "/" + book.getId());

        VerifyDataBookBody.verifyResponseSuccessAfterDelete(response, book, 200);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Test")
    @Feature("Read, verify")
    @Story("Book")
    @Description("Read Book and verify response of deleted Book")
    @Test(priority = 6)
    public void getAfterDeleteBook() {

        Response response = ApiKeyword.get(EndPointGlobal.EP_BOOK + "/" + book.getId());

        JsonPath jsonPath = response.jsonPath();

        ApiKeyword.verifyStatusCode(response, 400);

        Assert.assertEquals(jsonPath.getString("message"), "Not found", "Message not match.");
        Assert.assertEquals(jsonPath.getString( "errors"), "No book found with the submitted id", "Error detail not match.");
        LogUtils.info("message: " + jsonPath.getString("message"));
        LogUtils.info("errors: " + jsonPath.getString("errors"));


    }


}
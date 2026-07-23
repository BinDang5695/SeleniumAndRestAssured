package api.testcases;

import settings.globals.EndPointGlobal;
import settings.helpers.JsonHelper;
import settings.keywords.ApiKeyword;
import api.common.BaseTest;
import api.common.VerifyDataCategoryBody;
import api.listeners.TestListener;
import models.api.Category;
import settings.utils.LogUtils;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;

@Listeners(TestListener.class)
public class CRUDCategory extends BaseTest {

    private Category category;
    String dataFile = "src/test/resources/filetest/CreateCategory.json";

    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Test")
    @Feature("Category, verify")
    @Story("Category")
    @Description("Add new Category and verify response of created Category")
    @Test(priority = 1)
    public void testAddNewCategory() {

        category = testdata.api.Category.getDataToCreateCategory();

        JsonHelper.updateValueJsonFile(dataFile, category);

        Response response = ApiKeyword.post(EndPointGlobal.EP_CATEGORY, new File(dataFile));

        VerifyDataCategoryBody.verifyResponseSuccess(response, category, 200);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Test")
    @Feature("Read, verify")
    @Story("Category")
    @Description("Read Category and verify response of created Category")
    @Test(priority = 2)
    public void getCategory(){
        LogUtils.info("USER_NAME: " + category.getName());

        Response response = ApiKeyword.get(EndPointGlobal.EP_CATEGORY + "/" + category.getId());

        VerifyDataCategoryBody.verifyResponseSuccess(response, category, 200);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Test")
    @Feature("Update, verify")
    @Story("Category")
    @Description("Update Category and verify response of updated Category")
    @Test(priority = 3)
    public void putCategory() throws Exception {

        category = testdata.api.Category.createUpdatedCategory(category);

        JsonHelper.updateValueJsonFile(dataFile, category);

        String jsonBody = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(dataFile)));

        Response response = ApiKeyword.put(EndPointGlobal.EP_CATEGORY + "/" + category.getId(), jsonBody);

        VerifyDataCategoryBody.verifyResponseSuccess(response, category, 200);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Test")
    @Feature("Read, verify")
    @Story("Category")
    @Description("Read Category and verify response of updated Category")
    @Test(priority = 4)
    public void getCategoryAfterPut(){
        LogUtils.info("USER_NAME: " + category.getName());

        Response response = ApiKeyword.get(EndPointGlobal.EP_CATEGORY + "/" + category.getId());

        VerifyDataCategoryBody.verifyResponseSuccess(response, category, 200);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Test")
    @Feature("Delete, verify")
    @Story("Category")
    @Description("Delete Category and verify response of updated Category")
    @Test(priority = 5)
    public void deleteCategory(){

        Response response = ApiKeyword.delete(EndPointGlobal.EP_CATEGORY + "/" + category.getId());

        VerifyDataCategoryBody.verifyResponseSuccess(response, category, 200);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Test")
    @Feature("Read, verify")
    @Story("Category")
    @Description("Read Category and verify response of deleted Category")
    @Test(priority = 6)
    public void getAfterDeleteCategory() {

        Response response = ApiKeyword.get(EndPointGlobal.EP_CATEGORY + "/" + category.getId());

        JsonPath jsonPath = response.jsonPath();

        ApiKeyword.verifyStatusCode(response, 400);

        Assert.assertEquals(jsonPath.getString("message"), "Not found", "Message not match.");
        Assert.assertEquals(jsonPath.getString( "errors"), "No categogy found with the submitted id", "Error detail not match.");
        LogUtils.info("message: " + jsonPath.getString("message"));
        LogUtils.info("errors: " + jsonPath.getString("errors"));

    }


}
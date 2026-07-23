package api.testcases;

import settings.globals.EndPointGlobal;
import settings.helpers.JsonHelper;
import settings.keywords.ApiKeyword;
import api.common.BaseTest;
import api.common.VerifyDataUserBody;
import api.listeners.TestListener;
import models.api.User;
import settings.utils.LogUtils;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.File;

@Listeners(TestListener.class)
public class CRUDUser extends BaseTest {

    private User user;
    String dataFile = "src/test/resources/filetest/CreateUser.json";

    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Test")
    @Feature("Create, verify")
    @Story("User")
    @Description("Add new User and verify response of created User")
    @Test(priority = 1)
    public void testAddNewUser() {

        user = testdata.api.User.getDataToCreateUser();

        JsonHelper.updateValueJsonFile(dataFile, user);

        Response response = ApiKeyword.post(EndPointGlobal.EP_USER, new File(dataFile));

        VerifyDataUserBody.verifyResponseSuccess(response, user, 200);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Test")
    @Feature("Read, verify")
    @Story("User")
    @Description("Read User and verify response of created User")
    @Test(priority = 2)
    public void getUser(){
        LogUtils.info("USER_NAME: " + user.getUsername());

        Response response = ApiKeyword.get(EndPointGlobal.EP_USER, "username", new File(dataFile));

        VerifyDataUserBody.verifyResponseSuccess(response, user, 200);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Test")
    @Feature("Update, verify")
    @Story("User")
    @Description("Update User and verify response of created User")
    @Test(priority = 3)
    public void putUser() throws Exception {

        user = testdata.api.User.createUpdatedUser(user);

        JsonHelper.updateValueJsonFile(dataFile, user);

        String jsonBody = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(dataFile)));

        Response response = ApiKeyword.put(EndPointGlobal.EP_USER + "/" + user.getId(), jsonBody);

        VerifyDataUserBody.verifyResponseSuccess(response, user, 200);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Test")
    @Feature("Read, verify")
    @Story("User")
    @Description("Read User and verify response of updated User")
    @Test(priority = 4)
    public void getUserAfterPut(){
        LogUtils.info("USER_NAME: " + user.getUsername());

        Response response = ApiKeyword.get(EndPointGlobal.EP_USER, "username", new File(dataFile));

        VerifyDataUserBody.verifyResponseSuccess(response, user, 200);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Test")
    @Feature("Delete, verify")
    @Story("User")
    @Description("Delete User and verify response of updated User")
    @Test(priority = 5)
    public void deleteUser(){

        Response response = ApiKeyword.delete(EndPointGlobal.EP_USER, "username", new File(dataFile));

        VerifyDataUserBody.verifyResponseSuccess(response, user, 200);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Test")
    @Feature("Delete, verify")
    @Story("User")
    @Description("Read User and verify response of deleted User")
    @Test(priority = 6)
    public void getAfterDeleteUser() {

        Response response = ApiKeyword.get(EndPointGlobal.EP_USER, "username", new File(dataFile));

        JsonPath jsonPath = response.jsonPath();

        ApiKeyword.verifyStatusCode(response, 400);

        Assert.assertEquals(jsonPath.getString("message"), "Not found", "Message not match.");
        Assert.assertEquals(jsonPath.getString( "errors"), "No user found with the submitted id", "Error detail not match.");
        LogUtils.info("message: " + jsonPath.getString("message"));
        LogUtils.info("errors: " + jsonPath.getString("errors"));

    }


}
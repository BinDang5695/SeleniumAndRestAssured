package api.testcases;

import settings.globals.EndPointGlobal;
import settings.keywords.ApiKeyword;
import api.common.BaseTest;
import api.common.VerifyDataImageBody;
import api.listeners.TestListener;
import models.api.ImageResponse;
import testdata.api.Image;
import settings.utils.LogUtils;
import io.qameta.allure.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;

@Listeners(TestListener.class)
public class CRUDImage extends BaseTest {

    private ImageResponse imageresponse = new ImageResponse();

    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Test")
    @Feature("Create, verify")
    @Story("Image")
    @Description("Add new Image and verify response of created Image")
    @Test(priority = 1)
    public void testAddNewImage() {

        File file = Image.getImageFile("UK.jpg");

        Response response = ApiKeyword.post(EndPointGlobal.EP_IMAGE, "image", file);

        VerifyDataImageBody.verifyResponseSuccess(response, imageresponse, 200);

        LogUtils.info("Upload file: " + file.getName() + " | Size: " + file.length() + " bytes");

    }

    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Test")
    @Feature("Read, verify")
    @Story("Image")
    @Description("Read Image and verify response of created Image")
    @Test(priority = 2)
    public void getImage(){
        LogUtils.info("Id: " + imageresponse.getId());

        Response response = ApiKeyword.get(EndPointGlobal.EP_IMAGE + "/" + imageresponse.getId());

        VerifyDataImageBody.verifyResponseSuccess(response, imageresponse, 200);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Test")
    @Feature("Update, verify")
    @Story("Image")
    @Description("Update Image and verify response of updated Image")
    @Test(priority = 3)
    public void putImage() {

        File file = Image.getImageFile("UpdateImage.jpg");

        Response response = ApiKeyword.post(EndPointGlobal.EP_IMAGE + "/" + imageresponse.getId(), "image", file);

        VerifyDataImageBody.verifyResponseSuccess(response, imageresponse, 200);

        LogUtils.info("Upload file: " + file.getName() + " | Size: " + file.length() + " bytes");

    }

    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Test")
    @Feature("Read, verify")
    @Story("Image")
    @Description("Read Image and verify response of updated Image")
    @Test(priority = 4)
    public void getImageAfterPut(){

        LogUtils.info("Id: " + imageresponse.getId());

        Response response = ApiKeyword.get(EndPointGlobal.EP_IMAGE + "/" + imageresponse.getId());

        VerifyDataImageBody.verifyResponseSuccess(response, imageresponse, 200);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Test")
    @Feature("Delete, verify")
    @Story("Image")
    @Description("Delete Image and verify response of updated Image")
    @Test(priority = 5)
    public void deleteImage(){

        Response response = ApiKeyword.delete(EndPointGlobal.EP_IMAGE + "/" + imageresponse.getId());

        VerifyDataImageBody.verifyResponseSuccess(response, imageresponse, 200);

    }

    @Severity(SeverityLevel.CRITICAL)
    @Epic("Regression Test")
    @Feature("Read, verify")
    @Story("Image")
    @Description("Read Image and verify response of deleted Image")
    @Test(priority = 6)
    public void getAfterDeleteImage() {

        Response response = ApiKeyword.get(EndPointGlobal.EP_IMAGE + "/" + imageresponse.getId());

        JsonPath jsonPath = response.jsonPath();

        ApiKeyword.verifyStatusCode(response, 400);

        Assert.assertEquals(jsonPath.getString("message"), "Not found", "Message not match.");
        Assert.assertEquals(jsonPath.getString( "errors"), "No image found with the submitted id", "Error detail not match.");
        LogUtils.info("message: " + jsonPath.getString("message"));
        LogUtils.info("errors: " + jsonPath.getString("errors"));

    }


}
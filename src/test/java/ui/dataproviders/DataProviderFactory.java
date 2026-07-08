package ui.dataproviders;

import io.qameta.allure.internal.shadowed.jackson.core.type.TypeReference;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import models.ui.ExportFileType;
import org.testng.annotations.DataProvider;
import ui.testdata.CustomerCase;

import java.io.File;
import java.util.List;

public class DataProviderFactory {

    @DataProvider(name = "data_provider_login_success")
    public Object[][] dataProviderLoginSuccess() {
        return new Object[][]{
                {"admin@example.com", "123456"},
                //{"admin@example.com", "123456"},
                //{"admin@example.com", "123456"},
        };
    }

    @DataProvider(name = "data_provider_login_fail_invalid_email")
    public Object[][] dataProviderLoginFailWithInvalidEmail() {
        return new Object[][]{
                {"admin123@example.com", "123456"},
        };
    }

    @DataProvider(name = "data_provider_login_fail_invalid_password")
    public Object[][] dataProviderLoginFailWithInvalidPassword() {
        return new Object[][]{
                {"admin@example.com", "123456789"},
        };
    }

    @DataProvider(name = "exportTypes")
    public Object[][] exportTypes() {
        return new Object[][]{
                {ExportFileType.PDF},
                {ExportFileType.EXCEL},
                {ExportFileType.CSV}
        };
    }

    @DataProvider(name = "customerData")
    public Object[][] customerData() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        List<CustomerCase> list = mapper.readValue(
                new File("src/test/resources/filetest/CustomerData.json"),
                new TypeReference<List<CustomerCase>>() {
                });

        Object[][] data = new Object[list.size()][1];

        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i);
        }

        return data;
    }

}

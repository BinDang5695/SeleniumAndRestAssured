package testdata.api;

import settings.helpers.SystemHelper;

import java.io.File;

public class Image {

    public static File getImageFile(String fileName) {
        return new File(SystemHelper.getCurrentDir() + "/src/test/resources/filetest/" + fileName);
    }

}
package testdata.ui;

import java.nio.file.Paths;

public class Contact {

    private static final String RECEIPT_PATH = Paths.get(
            System.getProperty("user.dir"),
            "src",
            "test",
            "resources",
            "filetest",
            "UK.jpg"
    ).toString();

    public static models.ui.Contact getContact() {
        return new models.ui.Contact(
                "Bin",
                "Dang",
                "vbin561995@gmail.com",
                "123456",
                RECEIPT_PATH,
                ""
        );
    }
}
package ui.testdata;

import models.ui.Contact;

import java.nio.file.Paths;

public class ContactData {

    private static final String RECEIPT_PATH = Paths.get(
            System.getProperty("user.dir"),
            "src",
            "test",
            "resources",
            "filetest",
            "UK.jpg"
    ).toString();

    public static Contact getContact() {
        return new Contact(
                "Bin",
                "Dang",
                "vbin561995@gmail.com",
                "123456",
                RECEIPT_PATH,
                ""
        );
    }
}
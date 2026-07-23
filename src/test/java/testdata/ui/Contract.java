package testdata.ui;

public class Contract {

    public static models.ui.Contract getContract() {
        return new models.ui.Contract(
                "Bin Customer",
                "Bin Subject",
                "1000",
                "1",
                "18-11-2040",
                "18-11-2040",
                "Bin Description"
        );
    }

    public static models.ui.Contract getUpdatedContract() {
        return new models.ui.Contract(
                "Bin Customer",
                "Bin Subject Updated",
                "2000",
                "1",
                "18-11-2045",
                "18-11-2045",
                "Bin Description Updated"
        );
    }
}
package testdata.ui;

import settings.helpers.FileHelper;

public class Item {

    public static models.ui.Item getItem() {
        return new models.ui.Item(
                FileHelper.getTestDataFile("BinItems.csv"),
                "Bin Description",
                "Bin Long description",
                "$25.00",
                "0.00%",
                "0.00%",
                "Bin Unit"
        );
    }
}
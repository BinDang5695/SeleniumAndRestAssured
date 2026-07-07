package ui.testdata;

import models.ui.Item;
import settings.helpers.FileHelper;

public class ItemData {

    public static Item getItem() {
        return new Item(
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
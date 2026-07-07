package test.ui.testdata;

import models.ui.Contract;

public class ContractData {

    public static Contract getContract() {
        return new Contract(
                "Bin Customer",
                "Bin Subject",
                "1000",
                "1",
                "18-11-2040",
                "18-11-2040",
                "Bin Description"
        );
    }

    public static Contract getUpdatedContract() {
        return new Contract(
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
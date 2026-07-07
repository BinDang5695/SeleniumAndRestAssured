package ui.testdata;

import models.ui.Lead;

public class LeadData {

    public static Lead getLead() {
        return new Lead(
                "Bin Lead",
                "bin.dangvan@nashtechglobal.com",
                "Active",
                "Facebook",
                "Selenium",
                "19-11-2040 11:17"
        );
    }


}
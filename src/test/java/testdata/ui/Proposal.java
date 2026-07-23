package testdata.ui;

public class Proposal {

    public static models.ui.Proposal getProposal() {
        return new models.ui.Proposal(
                "Bin Subject",
                "Customer",
                "Bin Customer",
                "20",
                "20-12-2040",
                "€1.000,00",
                "27-12-2040",
                "vbin@gmail.com",
                "Bin Description",
                "(1,000.00) Bin description...",
                "1000"
        );
    }

}


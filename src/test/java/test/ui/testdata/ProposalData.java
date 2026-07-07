package test.ui.testdata;

import models.ui.Proposal;

public class ProposalData {

    public static Proposal getProposal() {
        return new Proposal(
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


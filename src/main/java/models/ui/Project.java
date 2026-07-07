package models.ui;

public class Project {

    private String name;
    private String customer;
    private String verifyProjectNameCustomer;
    private String verifyProjectProgress;

    public Project() {
    }

    public Project(String name, String customer,
                   String verifyProjectNameCustomer,
                   String verifyProjectProgress) {
        this.name = name;
        this.customer = customer;
        this.verifyProjectNameCustomer = verifyProjectNameCustomer;
        this.verifyProjectProgress = verifyProjectProgress;
    }

    public String getName() {
        return name;
    }

    public String getCustomer() {
        return customer;
    }

    public String getVerifyProjectNameCustomer() {
        return verifyProjectNameCustomer;
    }

    public String getVerifyProjectProgress() {
        return verifyProjectProgress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setVerifyProjectNameCustomer(String verifyProjectNameCustomer) {
        this.verifyProjectNameCustomer = verifyProjectNameCustomer;
    }

    public void setVerifyProjectProgress(String verifyProjectProgress) {
        this.verifyProjectProgress = verifyProjectProgress;
    }

}
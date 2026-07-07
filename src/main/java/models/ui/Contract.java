package models.ui;

public class Contract {

    private String customerName;
    private String subject;
    private String contractValue;
    private String contractType;
    private String startDate;
    private String endDate;
    private String description;

    public Contract() {
    }

    public Contract(String customerName, String subject, String contractValue,
                    String contractType, String startDate, String endDate,
                    String description) {
        this.customerName = customerName;
        this.subject = subject;
        this.contractValue = contractValue;
        this.contractType = contractType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContractValue() {
        return contractValue;
    }

    public void setContractValue(String contractValue) {
        this.contractValue = contractValue;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
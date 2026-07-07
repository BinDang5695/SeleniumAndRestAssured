package models.ui;

public class Proposal {

    private String subject;
    private String related;
    private String customer;
    private String day;
    private String date;
    private String total;
    private String openTill;
    private String email;
    private String binDescription;
    private String description;
    private String rate;

    public Proposal() {
    }

    public Proposal(String subject, String related,String customer, String day, String date, String total,
                    String openTill, String email, String binDescription,
                    String description, String rate) {
        this.subject = subject;
        this.related = related;
        this.customer = customer;
        this.day = day;
        this.date = date;
        this.total = total;
        this.openTill = openTill;
        this.email = email;
        this.binDescription = binDescription;
        this.description = description;
        this.rate = rate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getRelated() {
        return related;
    }

    public void setRelated(String related) {
        this.related = related;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getOpenTill() {
        return openTill;
    }

    public void setOpenTill(String openTill) {
        this.openTill = openTill;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBinDescription() {
        return binDescription;
    }

    public void setBinDescription(String binDescription) {
        this.binDescription = binDescription;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
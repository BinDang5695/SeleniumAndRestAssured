package models.ui;

public class Customer {

    private String company;
    private String currency;
    private String currencySymbol;

    public Customer() {
    }

    public Customer(String company,
                    String currency,
                    String currencySymbol) {
        this.company = company;
        this.currency = currency;
        this.currencySymbol = currencySymbol;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }
}
package models.ui;

public class Customer {

    private String company;
    private String vatNumber;
    private String phoneNumber;
    private String website;
    private String group;
    private String currency;
    private String currencySymbol;
    private String language;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    public Customer() {
    }

    public Customer(String company,
                    String vatNumber,
                    String phoneNumber,
                    String website,
                    String group,
                    String currency,
                    String currencySymbol,
                    String language,
                    String address,
                    String city,
                    String state,
                    String zipCode,
                    String country) {
        this.company = company;
        this.vatNumber = vatNumber;
        this.phoneNumber = phoneNumber;
        this.website = website;
        this.group = group;
        this.currency = currency;
        this.currencySymbol = currencySymbol;
        this.language = language;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
package models.ui;

public class Item {

    private String file;
    private String description;
    private String longDescription;
    private String rate;
    private String tax1;
    private String tax2;
    private String unit;

    public Item() {
    }

    public Item(String file, String description, String longDescription,
                String rate, String tax1, String tax2, String unit) {
        this.file = file;
        this.description = description;
        this.longDescription = longDescription;
        this.rate = rate;
        this.tax1 = tax1;
        this.tax2 = tax2;
        this.unit = unit;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTax1() {
        return tax1;
    }

    public void setTax1(String tax1) {
        this.tax1 = tax1;
    }

    public String getTax2() {
        return tax2;
    }

    public void setTax2(String tax2) {
        this.tax2 = tax2;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
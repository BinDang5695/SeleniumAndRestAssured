package models.ui;

public class Lead {

    private String name;
    private String email;
    private String status;
    private String source;
    private String tags;
    private String contactedToday;

    public Lead() {
    }

    public Lead(String name, String email, String status, String source, String tags,  String contactedToday) {
        this.name = name;
        this.email = email;
        this.status = status;
        this.source = source;
        this.tags = tags;
        this.contactedToday = contactedToday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
    public String getContactedToday() {
        return contactedToday;
    }
    public void setContactedToday(String contactedToday) {
        this.contactedToday = contactedToday;
    }
}
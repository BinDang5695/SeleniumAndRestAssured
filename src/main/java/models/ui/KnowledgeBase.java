package models.ui;

public class KnowledgeBase {

    private String subject;
    private String group;
    private String description;

    public KnowledgeBase() {
    }

    public KnowledgeBase(String subject, String group, String description) {
        this.subject = subject;
        this.group = group;
        this.description = description;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
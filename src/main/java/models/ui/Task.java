package models.ui;

public class Task {

    private String subject;
    private String subject_status;
    private String updatedSubject;

    public Task() {
    }

    public Task(String subject, String subject_status, String updatedSubject) {
        this.subject = subject;
        this.subject_status = subject_status;
        this.updatedSubject = updatedSubject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject_status() {
        return subject_status;
    }

    public void setSubject_status(String subject_status) {
        this.subject_status = subject_status;
    }

    public String getUpdatedSubject() {
        return updatedSubject;
    }

    public void setUpdatedSubject(String updatedSubject) {
        this.updatedSubject = updatedSubject;
    }
}
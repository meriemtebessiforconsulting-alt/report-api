package report.issue.report_api;

public class IssuePayload {
    private String appName;
    private String title;
    private String details;
    private String topic;
    private String userEmail;
    private boolean acceptContact;

    // --- Getters ---
    public String getAppName() {
        return appName;
    }
    public String getTitle() {
        return title;
    }
    public String getDetails() {
        return details;
    }
    public String getTopic() {
        return topic;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public boolean isAcceptContact() {
        return acceptContact;
    }

    // --- Setters ---
    public void setAppName(String appName) {
        this.appName = appName;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public void setAcceptContact(boolean acceptContact) {
        this.acceptContact = acceptContact;
    }
}


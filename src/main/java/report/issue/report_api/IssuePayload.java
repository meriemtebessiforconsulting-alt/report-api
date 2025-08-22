package report.issue.report_api;

public class IssuePayload {
    private String appName;
    private String title;
    private String details;
    private String topic;
    private String userEmail;
    private boolean acceptContact;

    // ✅ Obligatoire : getters et setters
    public String getAppName() { return appName; }
    public void setAppName(String appName) { this.appName = appName; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }

    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public boolean isAcceptContact() { return acceptContact; }
    public void setAcceptContact(boolean acceptContact) { this.acceptContact = acceptContact; }
}

package report.issue.report_api;

import java.time.LocalDateTime;
import java.util.UUID;

public class Issue {
    private String id;
    private String appName;
    private String title;
    private String details;
    private String topic;
    private String userEmail;
    private boolean acceptContact;
    private String status;
    private int version;
    private LocalDateTime createdAt;
    
    public Issue() {}  // <-- Jackson needs this

    public Issue(String appName, String title, String details, String topic, String userEmail, boolean acceptContact) {
        this.id = UUID.randomUUID().toString();
        this.appName = appName;
        this.title = title;
        this.details = details;
        this.topic = topic;
        this.userEmail = userEmail;
        this.acceptContact = acceptContact;
        this.status = "new";
        this.version = 1;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() { return id; }
    public String getAppName() { return appName; }
    public String getTitle() { return title; }
    public String getDetails() { return details; }
    public String getTopic() { return topic; }
    public String getUserEmail() { return userEmail; }
    public boolean isAcceptContact() { return acceptContact; }
    public String getStatus() { return status; }
    public int getVersion() { return version; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}

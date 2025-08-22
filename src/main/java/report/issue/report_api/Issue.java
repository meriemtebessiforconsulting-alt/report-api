package report.issue.report_api;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String appName;
    private String title;
    private String details;
    private String topic;
    private String userEmail;
    private boolean acceptContact;

    private String status = "new";
    private int version = 1;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Issue() {}

    public Issue(String appName, String title, String details,
            String topic, String userEmail, boolean acceptContact) {
   this.appName = appName;
   this.title = title;
   this.details = details;
   this.topic = topic;
   this.userEmail = userEmail;
   this.acceptContact = acceptContact;
}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getVersion() { return version; }
    public void setVersion(int version) { this.version = version; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

}

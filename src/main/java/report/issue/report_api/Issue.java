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

    // getters & setters
}

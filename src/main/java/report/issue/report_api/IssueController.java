package report.issue.report_api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class IssueController {
    private final IssueRepository repository;

    public IssueController(IssueRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/report-issue")
    public Issue reportIssue(@RequestBody IssuePayload payload) {
        Issue issue = new Issue(
                payload.getAppName(),
                payload.getTitle(),
                payload.getDetails(),
                payload.getTopic(),
                payload.getUserEmail(),
                payload.isAcceptContact()
        );
        return repository.save(issue);
    }

    @GetMapping("/issues")
    public List<Issue> getIssues() {
        return repository.findAll();
    }

    // ✅ Nouveau endpoint pour modifier le statut d’un issue
    @PatchMapping("/issues/{id}/status")
    public ResponseEntity<Issue> updateStatus(
            @PathVariable Long id,
            @RequestBody StatusPayload payload) {

        return repository.findById(id)
                .map(issue -> {
                    issue.setStatus(payload.getStatus());
                    Issue updated = repository.save(issue);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping("/issues/filter")
    public List<Issue> filterIssues(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String appName,
            @RequestParam(required = false) String userEmail,
            @RequestParam(required = false) String topic,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String creationDate // format: yyyy-MM-dd
    ) {
        return repository.findAll().stream()
                .filter(issue -> status == null || issue.getStatus().equalsIgnoreCase(status))
                .filter(issue -> id == null || issue.getId().equals(id))
                .filter(issue -> appName == null || issue.getAppName().equalsIgnoreCase(appName))
                .filter(issue -> userEmail == null || issue.getUserEmail().equalsIgnoreCase(userEmail))
                .filter(issue -> topic == null || issue.getTopic().equalsIgnoreCase(topic))
                .filter(issue -> title == null || issue.getTitle().toLowerCase().contains(title.toLowerCase()))
                .filter(issue -> {
                    if (creationDate == null) return true;
                    return issue.getCreatedAt().toLocalDate().toString().equals(creationDate);
                })
                .toList();
    }

}

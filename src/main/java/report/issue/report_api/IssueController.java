package report.issue.report_api;

import report.issue.report_api.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class IssueController {
    private final IssueRepository repository = new IssueRepository();

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
        repository.saveIssue(issue);
        return issue;  // Spring va automatiquement convertir en JSON
    }

    @GetMapping("/issues")
    public List<Issue> getIssues() {
        return repository.getAllIssues();
    }
}

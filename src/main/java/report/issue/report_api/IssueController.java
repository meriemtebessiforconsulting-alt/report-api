package report.issue.report_api;

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

        Issue saved = repository.save(issue);
        return saved; // Retourne l'objet complet, incluant ID généré
    }


    @GetMapping("/issues")
    public List<Issue> getIssues() {
        return repository.findAll();
    }
}

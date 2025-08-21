package report.issue.report_api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class IssueRepository {
    private static final String FILE_PATH = "issues.json";
    private ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();

    public List<Issue> getAllIssues() {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists() || file.length() == 0) return new ArrayList<>();
            return mapper.readValue(file, new TypeReference<List<Issue>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void saveIssue(Issue issue) {
        try {
            List<Issue> issues = getAllIssues();
            issues.add(issue);
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), issues);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

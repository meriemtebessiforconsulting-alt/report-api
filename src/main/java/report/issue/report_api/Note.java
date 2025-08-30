package report.issue.report_api;

import jakarta.persistence.Embeddable;

@Embeddable
public class Note {
    private String srvProviderCode;
    private double note;

    public Note() {}

    public Note(String srvProviderCode, double note) {
        this.srvProviderCode = srvProviderCode;
        this.note = note;
    }

    public String getSrvProviderCode() { return srvProviderCode; }
    public void setSrvProviderCode(String srvProviderCode) { this.srvProviderCode = srvProviderCode; }

    public double getNote() { return note; }
    public void setNote(double note) { this.note = note; }
}

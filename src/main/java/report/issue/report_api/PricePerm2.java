package report.issue.report_api;

import jakarta.persistence.Embeddable;

@Embeddable
public class PricePerm2 {
    private double average;
    private double min;
    private double max;

    public double getAverage() { return average; }
    public void setAverage(double average) { this.average = average; }

    public double getMin() { return min; }
    public void setMin(double min) { this.min = min; }

    public double getMax() { return max; }
    public void setMax(double max) { this.max = max; }
}

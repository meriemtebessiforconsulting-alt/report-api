package report.issue.report_api;

import jakarta.persistence.Embeddable;

@Embeddable
public class GeoCoordinates {
    private double latitude;
    private double longitude;

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
}

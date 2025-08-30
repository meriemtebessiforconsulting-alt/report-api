package report.issue.report_api;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class City {

    @Id
    private Long id; // auto-géré avec AtomicLong dans le controller

    private String geonameId;
    private String defaultName;
    private String admin2Code;
    private String admin4Code;
    private String postalCode;
    private String adminName1;
    private String adminName2;
    private String adminName3;

    @Embedded
    private GeoCoordinates geoCoordinates;

    @Embedded
    private PricePerm2 pricePerm2;

    @ElementCollection
    private List<Note> notes = new ArrayList<>();

    public City() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getGeonameId() { return geonameId; }
    public void setGeonameId(String geonameId) { this.geonameId = geonameId; }

    public String getDefaultName() { return defaultName; }
    public void setDefaultName(String defaultName) { this.defaultName = defaultName; }

    public String getAdmin2Code() { return admin2Code; }
    public void setAdmin2Code(String admin2Code) { this.admin2Code = admin2Code; }

    public String getAdmin4Code() { return admin4Code; }
    public void setAdmin4Code(String admin4Code) { this.admin4Code = admin4Code; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public String getAdminName1() { return adminName1; }
    public void setAdminName1(String adminName1) { this.adminName1 = adminName1; }

    public String getAdminName2() { return adminName2; }
    public void setAdminName2(String adminName2) { this.adminName2 = adminName2; }

    public String getAdminName3() { return adminName3; }
    public void setAdminName3(String adminName3) { this.adminName3 = adminName3; }

    public GeoCoordinates getGeoCoordinates() { return geoCoordinates; }
    public void setGeoCoordinates(GeoCoordinates geoCoordinates) { this.geoCoordinates = geoCoordinates; }

    public PricePerm2 getPricePerm2() { return pricePerm2; }
    public void setPricePerm2(PricePerm2 pricePerm2) { this.pricePerm2 = pricePerm2; }

    public List<Note> getNotes() { return notes; }
    public void setNotes(List<Note> notes) { this.notes = notes; }
}

package restassuredexercises;

import java.util.ArrayList;
import java.util.List;

public class LocationData {

    private String postCode;
    private String country;
    private String countryAbbreviation;
    private List<Place> places;

    public LocationData() {
        this.postCode = "68746";
        this.country = "United States";
        this.countryAbbreviation = "US";
        places = new ArrayList<>();
        places.add(new Place());
    }

    public LocationData(String postCode, String country, String countryAbbreviation, List<Place> places) {
        this.postCode = postCode;
        this.country = country;
        this.countryAbbreviation = countryAbbreviation;
        this.places = places;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryAbbreviation() {
        return countryAbbreviation;
    }

    public void setCountryAbbreviation(String countryAbbreviation) {
        this.countryAbbreviation = countryAbbreviation;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }
}

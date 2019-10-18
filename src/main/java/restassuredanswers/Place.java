package restassuredanswers;

public class Place {

    private String placeName;
    private String state;
    private String stateAbbreviation;

    public Place() {
        this.placeName = "Monowi";
        this.state = "Nebraska";
        this.stateAbbreviation = "NE";
    }

    public Place(String placeName, String state, String stateAbbreviation) {
        this.placeName = placeName;
        this.state = state;
        this.stateAbbreviation = stateAbbreviation;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }
}

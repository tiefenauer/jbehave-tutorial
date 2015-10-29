package info.tiefenauer.tutorials.jbehave;

/**
 * Created by danieltiefenauer on 29.10.2015.
 */
public class Radio {

    private String stationName;
    private boolean turnedOn;

    public Radio() {

    }

    public void switchOnOff(){
        turnedOn = !turnedOn;
    }

    public boolean isTurnedOn() {
        return turnedOn;
    }
}

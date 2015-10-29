package info.tiefenauer.tutorials.jbehave;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by danieltiefenauer on 29.10.2015.
 */
public class Radio {

    private String stationName;
    private boolean turnedOn;
    private String currentStation;
    private String currentFrequency;

    public Radio() {

    }

    public void switchOnOff(){
        turnedOn = !turnedOn;
    }

    public boolean isTurnedOn() {
        return turnedOn;
    }

    public void selectStation(String stationName) {
        currentStation = stationName;
    }

    public String getDisplay() {
        return getShortName(currentStation);
    }

    private String getShortName(String currentStation) {
        if (currentStation == null)
            return "";
        if (currentStation.length() > 10)
            return currentStation.substring(0,7) + "...";
        return currentStation;
    }

    public void tuneTo(double frequency) {
        currentFrequency = new DecimalFormat("#.00").format(frequency) + " FM";
    }

    public String getCurrentFrequency() {
        return currentFrequency;
    }
}

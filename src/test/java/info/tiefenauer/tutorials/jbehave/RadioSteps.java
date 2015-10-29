package info.tiefenauer.tutorials.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by danieltiefenauer on 29.10.2015.
 */
public class RadioSteps {

    private Radio radio;
    private ArrayList<RadioStation> stations;

    @Given("a digital radio")
    public void aDigitalRadio(){
        radio = new Radio();
    }

    @Given("the radio is already turned on")
    public void theRadioIsTurnedOn(){
        if (radio == null)
            aDigitalRadio();
        if(!radio.isTurnedOn())
            radio.switchOnOff();
    }

    @Given("the radio stations: $table")
    public void theRadioStations(ExamplesTable table){
        stations = new ArrayList<>();
        String name, frequency;
        for(Map<String, String> row : table.getRows()){
            name = row.get("name");
            frequency = row.get("frequency");
            stations.add(new RadioStation(name, frequency));
        }
    }

    @When("I press the on/off switch")
    public void iTurnOnTheRadio(){
        radio.switchOnOff();
    }

    @When("I select the station $stationName")
    public void iSelectTheStation(String stationName){
        radio.selectStation(stationName);
    }

    @When("I tune to $frequency")
    public void iTuneTo(double frequency){
        radio.tuneTo(frequency);
    }

    @Then("the radio should be turned on")
    public void theRadioShouldBeTurnedOn(){
        assertTrue(radio.isTurnedOn());
    }

    @When("all stations are added as presets")
    public void allStationsAreAddedAsPresets(){
        for(RadioStation station : stations){
            radio.addPreset(station);
        }
    }

    @Then("the radio should be turned off")
    public void theRadioShouldBeTurnedOff(){
        assertFalse(radio.isTurnedOn());
    }

    @Then("the radio should display $displayName as the current station")
    public void theRadioShouldDisplayAsTheCurrentStation(String displayName){
        assertEquals(displayName, radio.getDisplay());
    }

    @Then("the radio should have $frequency set as current frequency")
    public void theRadioShouldHaveSetCurrentFrequency(String frequency){
        assertEquals(frequency, radio.getCurrentFrequency());
    }

    @Then("the radio should have $numberOfStations stations saved")
    public void theRadioShouldHaveStationsSaved(int numberOfStations){
        assertEquals(numberOfStations, stations.size());
    }
}

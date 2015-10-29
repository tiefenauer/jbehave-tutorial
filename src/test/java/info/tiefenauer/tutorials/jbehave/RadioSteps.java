package info.tiefenauer.tutorials.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

/**
 * Created by danieltiefenauer on 29.10.2015.
 */
public class RadioSteps {

    private Radio radio;

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

}

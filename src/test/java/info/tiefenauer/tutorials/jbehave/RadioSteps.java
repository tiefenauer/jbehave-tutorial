package info.tiefenauer.tutorials.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by danieltiefenauer on 29.10.2015.
 */
public class RadioSteps {

    private Radio radio;

    @Given("a digital radio")
    public void aDigitalRadio(){
        radio = new Radio();
    }

    @When("I turn on the radio")
    public void iTurnOnTheRadio(){
        radio.switchOnOff();
    }

    @Then("the radio should be turned on")
    public void theRadioShouldBeTurnedOn(){
        assertTrue(radio.isTurnedOn());
    }
}

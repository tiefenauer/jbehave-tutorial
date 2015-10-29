Meta:
@author Daniel Tiefenauer
@homepage http://www.tiefenauer.info

Narrative:
As a music lover
I want to turn the radio on and off
So that I can start and stop listening to music

Scenario: Simple tests
!-- simple test
Given a digital radio
When I press the on/off switch
Then the radio should be turned on

!-- parameterized test
Given a digital radio
When I tune to 103.8
Then the radio should have 103.80 FM set as current frequency

!-- composite step
Given a digital radio
And the radio is already turned on
When I press the on/off switch
Then the radio should be turned off

Scenario: examples tables
!-- parameterized test with example table
Given a digital radio
When I select the station <stationName>
Then the radio should display <displayName> as the current station

Examples:
|stationName|displayName|
|Dani F.M.|Dani F.M.|
|A really long station name which will definitely not fit into the display|A reall...|

Scenario: tabular parameters
Given the radio stations:
|name|frequency|
|Dani F.M.|90.0|
|Holiday F.M.|103.8|
|Radio Paradise|99.9|
When all stations are added as presets
Then the radio should have 3 stations saved
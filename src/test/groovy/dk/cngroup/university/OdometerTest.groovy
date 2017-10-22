package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll

class OdometerTest extends Specification {

    @Unroll
    "should increase odometer state by two"() {
        given:
        def odometer = new Odometer()

        when:
        odometer.addMeterTraveled()
        odometer.addMeterTraveled()
        def distance = odometer.getMetersTraveled()

        then:
        distance == 2
    }

    @Unroll
    "odometer state should correspond with his journey"(String inputText, int metersTraveled) {
        given:
        Simulator.simulate(inputText)
        def odometer = Simulator.getOdometer()

        expect:
        metersTraveled == odometer.getMetersTraveled()

        where:
        inputText                              | metersTraveled
        InputTest.testInputTrue                | 3
        InputTest.specialTestInputTrue         | 3
        InputTest.testInputInitialInaccessible | 0
        InputTest.testInputFinalInaccessible   | 0
        InputTest.testInputOdometer            | 9
    }
}

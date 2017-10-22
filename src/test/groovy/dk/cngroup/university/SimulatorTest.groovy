package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll

class SimulatorTest extends Specification {

    @Unroll
    "should successfully achieve the destination"() {
        when:
        boolean result = Simulator.simulate(InputTest.testInputTrue)
        then:
        result == true
    }

    @Unroll
    "should not successfully achieve the destination"() {
        when:
        boolean result = Simulator.simulate(InputTest.testInputFalse)
        then:
        result == false
    }

    @Unroll
    "should successfully achieve the destination on special landscape"() {
        when:
        boolean result = Simulator.simulate(InputTest.specialTestInputTrue)
        then:
        result == true
    }
}
package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll

class SimulatorTest extends Specification {

    @Unroll
    "should successfully achieve the destination"() {
        when:
        boolean result = Simulator.simulate(InputTest.testInput)
        then:
        result == true
    }
}
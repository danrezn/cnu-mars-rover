package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll

class RoverPositionFactoryTest extends Specification {

    @Unroll
    "should return #positionState from #position"(String position, String positionState) {
        given:
        def roverPosition = RoverPositionFactory.getPosition(position)

        expect:
        positionState == roverPosition
                .printPosition()
        where:
        position | positionState
        "1,2"    | "1,2"
        "0,0"    | "0,0"
        "15,1"   | "15,1"
        "3,88"   | "3,88"
        "90,54"  | "90,54"
    }
}

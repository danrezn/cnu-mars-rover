package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll

import static dk.cngroup.university.Direction.*

class RoverTest extends Specification {

    @Unroll
    "should return correct direction to WEST"() {
        when:
        def rover = new Rover(WEST)
        then:
        rover.getDirection() == WEST
    }

    @Unroll
    "should return correct direction to NORTH"() {
        when:
        def rover = new Rover(NORTH)
        then:
        rover.getDirection() == NORTH
    }

    @Unroll
    "should return default direction"() {
        when:
        def rover = new Rover()
        then:
        rover.getDirection() == NORTH
    }

    @Unroll
    "should turn left from #oldDirection to #newDirection"(Direction oldDirection, Direction newDirection) {
        given:
        def rover = new Rover(oldDirection)

        expect:
        newDirection == rover
                .turnLeft()
                .getDirection()

        where:
        oldDirection | newDirection
        NORTH        | WEST
        WEST         | SOUTH
        SOUTH        | EAST
        EAST         | NORTH
    }

    @Unroll
    "should turn right from #oldDirection to #newDirection"(Direction oldDirection, Direction newDirection) {
        given:
        def rover = new Rover(oldDirection)

        expect:
        newDirection == rover
                .turnRight()
                .getDirection()

        where:
        oldDirection | newDirection
        NORTH        | EAST
        WEST         | NORTH
        SOUTH        | WEST
        EAST         | SOUTH
    }
}

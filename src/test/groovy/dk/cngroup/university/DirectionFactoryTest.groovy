package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll

class DirectionFactoryTest extends Specification {

    @Unroll
    "should return #direction from #worldSide"(Direction direction, WorldSide worldSide) {
        expect:
        direction == DirectionFactory.getDirection(worldSide)

        where:
        direction       | worldSide
        Direction.NORTH | WorldSide.NORTH
        Direction.SOUTH | WorldSide.SOUTH
        Direction.WEST  | WorldSide.WEST
        Direction.EAST  | WorldSide.EAST
    }

    @Unroll
    "should throw exception when null"() {
        when:
        DirectionFactory.getDirection(null)

        then:
        thrown NullPointerException
    }

    @Unroll
    "should return #direction from #directionCharacter"(Direction direction, String directionCharacter) {
        expect:
        direction == DirectionFactory.getDirection(directionCharacter)

        where:
        direction       | directionCharacter
        Direction.NORTH | "N"
        Direction.SOUTH | "S"
        Direction.WEST  | "W"
        Direction.EAST  | "E"
    }
}

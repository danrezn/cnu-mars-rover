package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll

class InputTest extends Specification {

    def static String testInput =

            "1,0\n" +
                    "\n" +
                    "N\n" +
                    "\n" +
                    "5\n" +
                    "\n" +
                    "..0..\n" +
                    ".....\n" +
                    ".0..0\n" +
                    ".0...\n" +
                    ".....\n" +
                    "\n" +
                    "4,0\n" +
                    "\n" +
                    "RRFLFRFF"

    @Unroll
    "should get text representation of initial position"() {
        given:
        Input input = new Input(testInput)

        when:
        String initialPosition = input.getInitialPosition();

        then:
        initialPosition == "1,0"
    }

    @Unroll
    "should get text representation of initial direction"() {
        given:
        Input input = new Input(testInput)

        when:
        String initialDirection = input.getInitialDirection();

        then:
        initialDirection == "N"
    }

    @Unroll
    "should get text representation of landscape size"() {
        given:
        Input input = new Input(testInput)

        when:
        int landscapeSize = input.getLandscapeSize();

        then:
        landscapeSize == 5
    }

    @Unroll
    "should get text representation of landscape matrix"() {
        given:
        Input input = new Input(testInput)

        when:
        String landscapeMatrix = input.getLandscapeMatrix();

        then:
        landscapeMatrix ==
                "..0........0..0.0........"
    }

    @Unroll
    "should get text representation of final position"() {
        given:
        Input input = new Input(testInput)

        when:
        String finalPosition = input.getFinalPosition();

        then:
        finalPosition == "4,0"
    }

    @Unroll
    "should get text representation of commands"() {
        given:
        Input input = new Input(testInput)

        when:
        String commands = input.getCommands();

        then:
        commands == "RRFLFRFF"
    }

}

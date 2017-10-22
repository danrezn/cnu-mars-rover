package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll

class InputTest extends Specification {

    def static String testInputTrue =

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

    def static String testInputFalse =

            "1,0\n" +
                    "\n" +
                    "N\n" +
                    "\n" +
                    "5\n" +
                    "\n" +
                    "..0..\n" +
                    ".....\n" +
                    ".00.0\n" +
                    ".....\n" +
                    ".....\n" +
                    "\n" +
                    "2,3\n" +
                    "\n" +
                    "RRFLFRFF"

    def static String specialTestInputTrue =

            "0,0\n" +
                    "\n" +
                    "N\n" +
                    "\n" +
                    "3\n" +
                    "\n" +
                    "...\n" +
                    "00.\n" +
                    "..0\n" +
                    "\n" +
                    "1,2\n" +
                    "\n" +
                    "FLFBRRRFLFFRFRFBLF"

    def static String testInputInitialInaccessible =

            "0,0\n" +
                    "\n" +
                    "N\n" +
                    "\n" +
                    "3\n" +
                    "\n" +
                    "0..\n" +
                    "...\n" +
                    "...\n" +
                    "\n" +
                    "0,2\n" +
                    "\n" +
                    "RFF"

    def static String testInputFinalInaccessible =

            "1,0\n" +
                    "\n" +
                    "N\n" +
                    "\n" +
                    "3\n" +
                    "\n" +
                    "...\n" +
                    ".0.\n" +
                    "...\n" +
                    "\n" +
                    "1,1\n" +
                    "\n" +
                    "RF"

    def static String testInputStoneDetection =

            "1,0\n" +
                    "\n" +
                    "N\n" +
                    "\n" +
                    "3\n" +
                    "\n" +
                    "0..\n" +
                    "..0\n" +
                    "...\n" +
                    "\n" +
                    "1,1\n" +
                    "\n" +
                    "RF"


    @Unroll
    "should get text representation of initial position"() {
        given:
        Input input = new Input(testInputTrue)

        when:
        String initialPosition = input.getInitialPosition();

        then:
        initialPosition == "1,0"
    }

    @Unroll
    "should get text representation of initial direction"() {
        given:
        Input input = new Input(testInputTrue)

        when:
        String initialDirection = input.getInitialDirection();

        then:
        initialDirection == "N"
    }

    @Unroll
    "should get text representation of landscape size"() {
        given:
        Input input = new Input(testInputTrue)

        when:
        int landscapeSize = input.getLandscapeSize();

        then:
        landscapeSize == 5
    }

    @Unroll
    "should get text representation of landscape matrix"() {
        given:
        Input input = new Input(testInputTrue)

        when:
        String landscapeMatrix = input.getLandscapeMatrix();

        then:
        landscapeMatrix ==
                "..0........0..0.0........"
    }

    @Unroll
    "should get text representation of final position"() {
        given:
        Input input = new Input(testInputTrue)

        when:
        String finalPosition = input.getFinalPosition();

        then:
        finalPosition == "4,0"
    }

    @Unroll
    "should get text representation of commands"() {
        given:
        Input input = new Input(testInputTrue)

        when:
        String commands = input.getCommands();

        then:
        commands == "RRFLFRFF"
    }

}

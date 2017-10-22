package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll

import static dk.cngroup.university.Field.ACCESSIBLE
import static dk.cngroup.university.Field.INACCESSIBLE

class LandscapeTest extends Specification {

    def static Field[][] testLandscape = [
            [ACCESSIBLE, ACCESSIBLE, ACCESSIBLE],
            [ACCESSIBLE, ACCESSIBLE, ACCESSIBLE],
            [ACCESSIBLE, ACCESSIBLE, ACCESSIBLE]
    ]

    @Unroll
    "should create landscape"() {
        given:
        RandomFieldGenerator generator = Mock(RandomFieldGenerator)
        9 * generator.getRandomField() >> ACCESSIBLE

        Landscape landscape = new Landscape(generator, 3)

        expect:
        landscape.getLandscape() == testLandscape
    }


    void "should print to string"() {
        given:
        RandomFieldGenerator generator = Mock(RandomFieldGenerator)
        generator.getRandomField() >>> [INACCESSIBLE, INACCESSIBLE, ACCESSIBLE]

        Landscape landscape = new Landscape(generator, 3)

        when:
        String result = landscape.toString();

        then:
        result == """00.
...
...
"""
    }

    @Unroll
    "should return #isAccessible for #x:#y"(boolean isAccessible, int x, int y) {
        given:
        RandomFieldGenerator generator = Mock(RandomFieldGenerator)
        generator.getRandomField() >>> [INACCESSIBLE, INACCESSIBLE, ACCESSIBLE]

        Landscape landscape = new Landscape(generator, 3)

        def position = new RoverPosition(x, y)

        expect:
        isAccessible == landscape.isFieldAccessible(position)

        where:
        isAccessible | x  | y
        false        | 0  | 0
        false        | 0  | 1
        true         | 0  | 2
        true         | 1  | 0
        false        | 3  | 3
        false        | -1 | -2
    }

    void "should print to string a field constructed by landscape plan from input"() {
        given:
        def landscapeMatrix = new Input(InputTest.testInputTrue).getLandscapeMatrix()
        def squareSize = new Input(InputTest.testInputTrue).landscapeSize

        Landscape landscape = new Landscape(landscapeMatrix, squareSize)

        when:
        String result = landscape.toString();

        then:
        result == "..0..\n" +
                ".....\n" +
                ".0..0\n" +
                ".0...\n" +
                ".....\n"
    }

    void "should return false if the initial and final destinations are at ACCESSIBLE fields"(String inputText, boolean result) {
        given:
        def input = new Input(inputText)
        def landscape = new Landscape(input.getLandscapeMatrix(), input.getLandscapeSize())
        def initialPosition = RoverPositionFactory.getPosition(input.getInitialPosition())
        def finalPosition = RoverPositionFactory.getPosition(input.getFinalPosition())

        expect:
        result == landscape.isInaccessibilityDetected(initialPosition, finalPosition)

        where:
        inputText                              | result
        InputTest.testInputTrue                | false
        InputTest.testInputInitialInaccessible | true
        InputTest.testInputFinalInaccessible   | true


    }
}

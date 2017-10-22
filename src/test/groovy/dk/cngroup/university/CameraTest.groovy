package dk.cngroup.university

import spock.lang.Specification
import spock.lang.Unroll

class CameraTest extends Specification {

    @Unroll
    void "should print to string coordinates of two stones"() {
        given:
        def camera = new Camera()
        camera.takePicture(new RoverPosition(1, 5))
        camera.takePicture(new RoverPosition(3, 8))

        when:
        String album = camera.generateAlbum();

        then:
        album == "Stones in photoalbum: 1,5 + 3,8"
    }

    @Unroll
    void "should print coordinates of stones right before the Rover"(String inputText, String album) {
        given:
        Simulator.simulate(inputText)
        def camera = Simulator.getCamera();

        expect:
        album == camera.generateAlbum();

        where:
        inputText                         | album
        InputTest.testInputTrue           | "Stones in photoalbum: 2,1"
        InputTest.testInputFalse          | "Stones in photoalbum: 2,1"
        InputTest.specialTestInputTrue    | "Stones in photoalbum: 1,1 + 2,2"
        InputTest.testInputStoneDetection | "Stones in photoalbum: 0,0 + 1,2"
    }
}

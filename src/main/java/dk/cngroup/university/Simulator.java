package dk.cngroup.university;

public class Simulator {

    private static Input input;

    private static Rover rover;
    private static Landscape landscape;
    private static RoverPosition roverPosition;
    private static Camera camera;
    private static Odometer odometer;

    private static Mars mars;


    public static boolean simulate(String inputText) {

        input = new Input(inputText);

        rover = new Rover(DirectionFactory.getDirection(input.getInitialDirection()));
        landscape = new Landscape(input.getLandscapeMatrix(), input.getLandscapeSize());
        roverPosition = RoverPositionFactory.getPosition(input.getInitialPosition());
        camera = new Camera();
        odometer = new Odometer();

        mars = new Mars(rover, landscape, roverPosition, camera, odometer);

        RoverPosition initialPosition = RoverPositionFactory.getPosition(input.getInitialPosition());
        RoverPosition finalPosition = RoverPositionFactory.getPosition(input.getFinalPosition());

        if (landscape.isInaccessibilityDetected(initialPosition, finalPosition)) {
            System.out.println("Initial of final position is at an inaccessible field");
            return false;
        }

        executeCommands(input.getCommands());

        System.out.println("The photoalbum contains pictures of these stones: " + camera.generateAlbum());
        System.out.println("The rover has traveled " + odometer.getMetersTraveled() + " meter(s)");

        if (mars.getPosition().printPosition().equals(RoverPositionFactory.getPosition(input.getFinalPosition()).printPosition())) {
            return true;
        } else {
            return false;
        }
    }

    public static void executeCommands(String commands) {
        char[] commandList = commands.toCharArray();

        for (Character command : commandList) {
            mars = new Mars(rover, landscape, roverPosition, camera, odometer);
            checkForwardPosition();

            switch (command) {
                case 'R':
                    rover = new Rover(rover.getDirection().getRightOf());
                    break;
                case 'L':
                    rover = new Rover(rover.getDirection().getLeftOf());
                    break;
                case 'F':
                    mars = new Mars(rover, landscape, mars.moveForward(), camera, odometer);
                    roverPosition = mars.getPosition();
                    break;
                case 'B':
                    mars = new Mars(rover, landscape, mars.moveBackward(), camera, odometer);
                    roverPosition = mars.getPosition();
                    break;
            }
        }
        checkForwardPosition();
    }

    /**
     * Finds out if there is something to snap. If there is something, camera takes the picture
     */
    public static void checkForwardPosition() {
        RoverPosition forwardPosition = RoverPositionFactory.getForwardPosition(roverPosition, rover.getDirection());

        if (forwardPosition.isInsideLandscape(input.getLandscapeSize()) & !landscape.isFieldAccessible(forwardPosition)) {
            camera.takePicture(forwardPosition);
        }
    }

    public static Camera getCamera() {
        return camera;
    }

    public static Odometer getOdometer() {
        return odometer;
    }
}

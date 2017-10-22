package dk.cngroup.university;

public class Simulator {

    private static Input input;

    private static Rover rover;
    private static Landscape landscape;
    private static RoverPosition roverPosition;

    private static Mars mars;


    public static boolean simulate(String inputText) {

        input = new Input(inputText);

        rover = new Rover(DirectionFactory.getDirection(input.getInitialDirection()));
        landscape = new Landscape(input.getLandscapeMatrix(), input.getLandscapeSize());
        roverPosition = RoverPositionFactory.getPosition(input.getInitialPosition());

        mars = new Mars(rover, landscape, roverPosition);

        RoverPosition initialPosition = RoverPositionFactory.getPosition(input.getInitialPosition());
        RoverPosition finalPosition = RoverPositionFactory.getPosition(input.getFinalPosition());

        if (landscape.isInaccessibilityDetected(initialPosition, finalPosition)) {
            return false;
        }

        executeCommands(input.getCommands());

        if (mars.getPosition().printPosition().equals(RoverPositionFactory.getPosition(input.getFinalPosition()).printPosition())) {
            return true;
        } else {
            return false;
        }
    }

    public static void executeCommands(String commands) {
        char[] commandList = commands.toCharArray();

        for (Character command : commandList) {

            mars = new Mars(rover, landscape, roverPosition);

            switch (command) {
                case 'R':
                    rover = new Rover(rover.getDirection().getRightOf());
                    break;
                case 'L':
                    rover = new Rover(rover.getDirection().getLeftOf());
                    break;
                case 'F':
                    mars = new Mars(rover, landscape, mars.moveForward());
                    roverPosition = mars.getPosition();
                    break;
                case 'B':
                    mars = new Mars(rover, landscape, mars.moveBackward());
                    roverPosition = mars.getPosition();
                    break;

            }
        }
    }
}

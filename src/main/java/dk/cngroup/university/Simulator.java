package dk.cngroup.university;

public class Simulator {

    public static boolean simulate(String inputText) {

        Input input = new Input(inputText);

        Rover rover = new Rover(DirectionFactory.getDirection(input.getInitialDirection()));
        Landscape landscape = new Landscape(input.getLandscapeMatrix(), input.getLandscapeSize());
        RoverPosition roverPosition = RoverPositionFactory.getPosition(input.getInitialPosition());

        Mars mars = new Mars(rover, landscape, roverPosition);

        mars.executeCommands(input.getCommands());

        if (mars.getPosition() == RoverPositionFactory.getPosition(input.getFinalPosition())) {
            return true;
        } else {
            return false;
        }
    }
}

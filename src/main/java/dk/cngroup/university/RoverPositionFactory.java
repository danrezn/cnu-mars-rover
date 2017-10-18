package dk.cngroup.university;

public class RoverPositionFactory {

    public static RoverPosition getForwardPosition(RoverPosition position, Direction direction) {
        switch (direction) {
            case NORTH:
                return new RoverPosition(position.getX() - 1, position.getY());
            case SOUTH:
                return new RoverPosition(position.getX() + 1, position.getY());
            case WEST:
                return new RoverPosition(position.getX(), position.getY() - 1);
            case EAST:
                return new RoverPosition(position.getX(), position.getY() + 1);
        }
        return position;
    }

    public static RoverPosition getBackwardPosition(RoverPosition position, Direction direction) {
        switch (direction) {
            case NORTH:
                return new RoverPosition(position.getX() + 1, position.getY());
            case SOUTH:
                return new RoverPosition(position.getX() - 1, position.getY());
            case WEST:
                return new RoverPosition(position.getX(), position.getY() + 1);
            case EAST:
                return new RoverPosition(position.getX(), position.getY() - 1);
        }
        return position;
    }

    public static RoverPosition getPosition(String position) {

        //Splits text representation of position into two coordinates
        int x = Integer.parseInt(position.substring(0, position.indexOf(",")));
        int y = Integer.parseInt(position.substring(position.indexOf(",") + 1));

        return new RoverPosition(x, y);
    }
}

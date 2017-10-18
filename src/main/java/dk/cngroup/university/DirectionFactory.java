package dk.cngroup.university;

public class DirectionFactory {

    public static Direction getDirection(WorldSide side) {
        switch (side) {
            case NORTH:
                return Direction.NORTH;
            case EAST:
                return Direction.EAST;
            case WEST:
                return Direction.WEST;
            case SOUTH:
                return Direction.SOUTH;
        }
        //should never happen
        throw new RuntimeException("unkown worldside value");
    }

    public static Direction getDirection(String direction) {
        switch (direction) {
            case "N":
                return Direction.NORTH;
            case "E":
                return Direction.EAST;
            case "W":
                return Direction.WEST;
            case "S":
                return Direction.SOUTH;
        }
        //should never happen
        throw new RuntimeException("unkown worldside value");
    }
}

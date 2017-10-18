package dk.cngroup.university;

public class Rover {
    private Direction direction;

    public Rover() {
        this.direction = Direction.NORTH;
    }

    public Rover(Direction direction) {
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public Rover turnLeft() {
        return new Rover(direction.getLeftOf());
    }

    public Rover turnRight() {
        return new Rover(direction.getRightOf());
    }

}

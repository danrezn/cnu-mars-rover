package dk.cngroup.university;

public class Mars {
    private Rover rover;
    private Landscape landscape;
    private RoverPosition position;
    private Camera camera;
    private Odometer odometer;

    public Mars(Rover rover, Landscape landscape, RoverPosition position, Camera camera, Odometer odometer) {
        this.rover = rover;
        this.landscape = landscape;
        this.position = position;
        this.camera = camera;
        this.odometer = odometer;
    }

    public RoverPosition getPosition() {
        return position;
    }

    public RoverPosition moveForward() {
        RoverPosition forwardPosition = RoverPositionFactory.getForwardPosition(position, rover.getDirection());

        if (landscape.isFieldAccessible(forwardPosition)) {
            odometer.addMeterTraveled();
            return forwardPosition;
        } else {
            return position;
        }
    }

    public RoverPosition moveBackward() {
        RoverPosition backwardPosition = RoverPositionFactory.getBackwardPosition(position, rover.getDirection());

        if (landscape.isFieldAccessible(backwardPosition)) {
            odometer.addMeterTraveled();
            return backwardPosition;
        } else {
            return position;
        }
    }
}

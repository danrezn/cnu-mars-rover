package dk.cngroup.university;

/**
 * Allows you to measure the number of meters traveled
 */
public class Odometer {

    private int metersTraveled = 0;

    public Odometer() {

    }

    public void addMeterTraveled() {
        metersTraveled++;
    }

    public int getMetersTraveled() {
        return metersTraveled;
    }
}

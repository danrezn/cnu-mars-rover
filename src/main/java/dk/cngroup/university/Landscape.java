package dk.cngroup.university;

import java.util.ArrayList;

public class Landscape {

    private Field[][] landscape;

    public Landscape(Field[][] landscape) {
        this.landscape = landscape;
    }

    public Landscape(RandomFieldGenerator generator, int squareSize) {
        this.landscape = createLandscape(generator, squareSize);
    }

    public Landscape(String landscapePlan, int squareSize) {
        this.landscape = createLandscape(landscapePlan, squareSize);
    }

    private Field[][] createLandscape(RandomFieldGenerator generator, int squareSize) {
        Field[][] landscape = new Field[squareSize][squareSize];
        for (int i = 0; i < squareSize; i++) {
            for (int j = 0; j < squareSize; j++) {
                landscape[i][j] = generator.getRandomField();
            }
        }
        return landscape;
    }

    public Field[][] getLandscape() {
        return landscape;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Field[] row : landscape) {
            for (Field field : row) {
                sb.append(field);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public boolean isFieldAccessible(RoverPosition pos) {
        if (!pos.isInsideLandscape(landscape.length)) {
            return false;
        }

        Field field = landscape[pos.getX()][pos.getY()];
        return field == Field.ACCESSIBLE;
    }

    public Field[][] createLandscape(String landscapePlan, int squareSize) {

        ArrayList<Field> listOfFields = getListOfFieldsAccordingLandscapePlan(landscapePlan, squareSize);

        Field[][] landscape = new Field[squareSize][squareSize];
        int h = 0;

        for (int i = 0; i < squareSize; i++) {
            for (int j = 0; j < squareSize; j++) {
                landscape[i][j] = listOfFields.get(h);
                h++;
            }
        }
        return landscape;
    }

    private static ArrayList<Field> getListOfFieldsAccordingLandscapePlan(String landscapePlan, int squareSize) {

        ArrayList<Field> result = new ArrayList<>();

        for (int i = 0; i <= squareSize * squareSize - 1; i++) {
            char fieldSign = landscapePlan.charAt(i);
            if (fieldSign == '.') {
                result.add(Field.ACCESSIBLE);
            } else {
                result.add(Field.INACCESSIBLE);
            }
        }
        return result;
    }

    /**
     * Detects situation, when either initial or final destinations are at an INACCESSIBLE field.
     * Returns false if both positions ara at ACCESSIBLE field
     */
    public boolean isInaccessibilityDetected(RoverPosition initialPosition, RoverPosition finalPosition) {
        if (isFieldAccessible(initialPosition) && isFieldAccessible(finalPosition)) {
            return false;
        } else {
            return true;
        }
    }
}
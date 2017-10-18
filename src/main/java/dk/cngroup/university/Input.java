package dk.cngroup.university;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {

    private String initialPosition;
    private String finalPosition;
    private String initialDirection;
    private int landscapeSize;
    private String landscapeMatrix;
    private String commands;


    public Input(String inputText) {

        Pattern pattern = Pattern.compile("(\\d,\\d)\\n\\n(.)\\n\\n(\\d)\\n\\n([\\n\\d.]*)?\\n\\n(\\d,\\d)\\n\\n(\\w*)");
        Matcher matcher = pattern.matcher(inputText);
        matcher.find();

        initialPosition = matcher.group(1);
        initialDirection = matcher.group(2);
        landscapeSize = Integer.parseInt(matcher.group(3));
        landscapeMatrix = matcher.group(4).replaceAll("\n", "");
        finalPosition = matcher.group(5);
        commands = matcher.group(6);
    }

    public String getInitialPosition() {
        return initialPosition;
    }

    public String getInitialDirection() {
        return initialDirection;
    }

    public int getLandscapeSize() {
        return landscapeSize;
    }

    public String getLandscapeMatrix() {
        return landscapeMatrix;
    }

    public String getFinalPosition() {
        return finalPosition;
    }

    public String getCommands() {
        return commands;
    }

}


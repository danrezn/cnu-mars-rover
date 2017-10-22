package dk.cngroup.university;

import java.util.HashSet;

public class Camera {

    private HashSet<String> allPhotos = new HashSet<>();

    public void takePicture(RoverPosition roverPosition) {
        allPhotos.add(roverPosition.printPosition());
    }

    public String generateAlbum() {
        String photoAlbum = "Stones in photoalbum: " + String.join(" + ", allPhotos);

        return photoAlbum;
    }
}

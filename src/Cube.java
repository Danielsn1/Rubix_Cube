import java.awt.*;
import java.util.HashMap;

public class Cube {
    public HashMap<String,Face> faces;

    public Cube(){
        faces = new HashMap<>();
        faces.put("Top", new Face(Color.white));
        faces.put("Front", new Face(Color.red));
        faces.put("Back", new Face(Color.yellow));
        faces.put("Left", new Face(Color.orange));
        faces.put("Right", new Face(Color.green));
        faces.put("Bottom", new Face(Color.blue));
    }



    public HashMap<String, Face> getFaces() {
        return faces;
    }

    public String toString() {
        return "Cube{" +
                "faces=" + faces +
                '}';
    }
}
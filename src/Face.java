import java.awt.Color;
import java.util.Random;

public class Face {
    public Tile[][] face;

    // public constructor that creates a face of a uniform color
    public Face(Color clr) {
        face = new Tile[3][3];
        createFace(clr);
    }

    // This method creates tiles of a uniform color in order to fill a face
    private void createFace(Color clr) {
        int x = 0;
        int y = 0;
        for (Tile[] array : face) {
            for (Tile ignored : array) {
                face[x][y] = new Tile(clr, x, y);
                x++;
                if(x > 2) x = 0;
            }
            y++;
        }
    }

    public Tile[][] getFace() {
        return face;
    }

    public String toString(){
        String result = "";
        for (Tile[] array : face) {
            for (Tile tile : array) {
                result += tile + "\n";
            }
        }
        return result;
    }
}

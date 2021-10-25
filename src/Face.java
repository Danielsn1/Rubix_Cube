import java.awt.*;
import java.util.Random;

public class Face {
    public Tile[][] face;
    public int whiteCount;
    public int redCount;
    public int blueCount;
    public int greenCount;
    

    public Face(){
        face = new Tile[3][3];
        createFace();
    }

    private void createFace(){
        int x = 0;
        int y = 0;
        Random rand = new Random();
        for (Tile[] array : face) {
            for (Tile tile : array){
                switch (Colors.values()[rand.nextInt(Colors.values().length)]){
                    case RED -> tile = new Tile(Color.red,x,y);
                    case BLUE -> tile = new Tile(Color.blue,x,y);
                    case GREEN -> tile = new Tile(Color.green,x,y);
                    case WHITE -> tile = new Tile(Color.white,x,y);
                    case ORANGE -> tile = new Tile(Color.orange,x,y);
                    case YELLOW -> tile = new Tile(Color.yellow,x,y);
                }
                x ++;
            }
            y ++;
        }
    }

    public Tile[][] getFace() {
        return face;
    }
}

import java.awt.*;
import java.util.Random;

public class Face {
    public Tile[][] face;
    public int whiteCount, redCount, blueCount, greenCount, orangeCount, yellowCount;
    private int maxWhite, maxRed, maxBlue, maxGreen, maxOrange, maxYellow;
    private Color color;


    public Face(Color clr) {
        whiteCount = redCount = blueCount = greenCount = orangeCount = yellowCount = 0;
        color = clr;
        face = new Tile[3][3];
        createFace(color);
    }

    public Face()

    private void createFace() {
        int x = 0;
        int y = 0;
        Random rand = new Random();
        for (Tile[] array : face) {
            for (Tile tile : array) {
                switch (Colors.values()[rand.nextInt(Colors.values().length)]) {
                    case RED:
                        tile = new Tile(Color.red, x, y);
                        redCount++;
                    case BLUE:
                        tile = new Tile(Color.blue, x, y);
                        blueCount++;
                    case GREEN:
                        tile = new Tile(Color.green, x, y);
                        greenCount++;
                    case WHITE:
                        tile = new Tile(Color.white, x, y);
                        whiteCount++;
                    case ORANGE:
                        tile = new Tile(Color.orange, x, y);
                        orangeCount++;
                    case YELLOW:
                        tile = new Tile(Color.yellow, x, y);
                        yellowCount++;
                }
                x++;
            }
            y++;
        }
    }

    private void createFace(Color clr) {
        int x = 0;
        int y = 0;
        for (Tile[] array : face) {
            for (Tile tile : array) {
                tile = new Tile(clr, x, y);
                x++;
            }
            y++;
        }
    }

    public Tile[][] getFace() {
        return face;
    }

    public int getBlueCount() {
        return blueCount;
    }

    public int getGreenCount() {
        return greenCount;
    }

    public int getOrangeCount() {
        return orangeCount;
    }

    public int getYellowCount() {
        return yellowCount;
    }

    public int getWhiteCount() {
        return whiteCount;
    }

    public int getRedCount() {
        return redCount;
    }
}

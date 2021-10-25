import java.awt.Color;
import java.util.Random;

public class Face {
    public Tile[][] face;
    public int whiteCount, redCount, blueCount, greenCount, orangeCount, yellowCount;

    // public constructor that creates a face of a uniform color
    public Face(Color clr) {
        // sets the count of all the colors to 0
        whiteCount = redCount = blueCount = greenCount = orangeCount = yellowCount = 0;
        face = new Tile[3][3];
        createFace(clr);
    }
    // public constructor that makes a random faces constrained by maximum amount of each color for the face
    public Face(int[] max){
        whiteCount = redCount = blueCount = greenCount = orangeCount = yellowCount = 0;
        face = new Tile[3][3];
        createFace(max);
    }
    // This method creates the random face with the given constraints.
    // the order of the colors in the array are white, red, blue, green, orange, yellow
    private void createFace(int[] max) {
        // These two variables keep track where on the face the loop is at
        int x = 0;
        int y = 0;
        // Hold the clr to set the tile
        Colors clr;
        // A boolean flag to get out of the do loop
        boolean flag;
        Random rand = new Random();
        for (Tile[] array : face) {
            for (Tile tile : array) {
                do{
                    // Gets a random color from the Colors enum
                    clr = Colors.values()[rand.nextInt(Colors.values().length)];
                    // This switch statement checks if the color can be the one randomly chosen
                    switch (clr){
                        case WHITE:
                            if(max[0] <= whiteCount) flag = false;
                        case RED:
                            if(max[1] <= redCount) flag = false;
                        case BLUE:
                            if(max[2] <= blueCount) flag = false;
                        case GREEN:
                            if(max[3] <= greenCount) flag = false;
                        case ORANGE:
                            if(max[4] <= orangeCount) flag = false;
                        case YELLOW:
                            if(max[5] <= yellowCount) flag = false;
                        default:
                            flag = true;
                    }
                }while(flag);
                // This switch statement creates the tile with the corresponding color
                switch (clr) {
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
    // This version of create face creates a face with a single color
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

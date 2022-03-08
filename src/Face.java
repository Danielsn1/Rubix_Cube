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
    public Face(Face fce){
        whiteCount = redCount = blueCount = greenCount = orangeCount = yellowCount = 0;
        face = new Tile[3][3];
        createFace(fce);
    }
    // This method creates the random face with the given constraints.
    // the order of the colors in the array are white, red, blue, green, orange, yellow
    private void createFace(int[] max) {
        // These two variables keep track where on the face the loop is at
        int x = 0;
        int y = 0;
        // Hold the clr to set the tile
        Colors clr;
        Random rand = new Random();
        for (Tile[] array : face) {
            for (Tile ignored : array) {
                do{
                    // Gets a random color from the Colors enum
                    clr = Colors.values()[rand.nextInt(Colors.values().length)];
                }while(isColorValid(clr,max));
                // This switch statement creates the tile with the corresponding color
                switch (clr) {
                    case RED:
                        face[x][y] = new Tile(Color.red, x, y);
                        redCount++;
                    case BLUE:
                        face[x][y] = new Tile(Color.blue, x, y);
                        blueCount++;
                    case GREEN:
                        face[x][y] = new Tile(Color.green, x, y);
                        greenCount++;
                    case WHITE:
                        face[x][y] = new Tile(Color.white, x, y);
                        whiteCount++;
                    case ORANGE:
                        face[x][y] = new Tile(Color.orange, x, y);
                        orangeCount++;
                    case YELLOW:
                        face[x][y] = new Tile(Color.yellow, x, y);
                        yellowCount++;
                }
                x++;
            }
            y++;
        }
    }
    // This creates a copy of the given face
    private void createFace(Face fce){
        for (int i = 0; i < face[0].length;i++){
            for (int k = 0; k < face.length; k++){
                Tile temp = fce.getFace()[i][k];
                face[i][k] = new Tile(temp.getColor(),temp.getPosition()[0],temp.getPosition()[1]);
            }
        }
    }
    // This version of create face creates a face with a single color
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
    // This method checks if a color is valid for the face
    private boolean isColorValid(Colors clr,int[] max) {
        // This switch statement checks if the color can be the one randomly chosen
        switch (clr) {
            case WHITE:
                if (max[0] <= whiteCount) return false;
            case RED:
                if (max[1] <= redCount) return false;
            case BLUE:
                if (max[2] <= blueCount) return false;
            case GREEN:
                if (max[3] <= greenCount) return false;
            case ORANGE:
                if (max[4] <= orangeCount) return false;
            case YELLOW:
                if (max[5] <= yellowCount) return false;
        }
        return true;
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

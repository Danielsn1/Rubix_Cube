import java.awt.*;

public class main  {
    // the order of the colors in the array are white, red, blue, green, orange, yellow
    public static int[] counts = new int[6];
    public static Face[]  faces = new Face[6];
    public static void main(String args[]){
        System.out.println("hello world");
        Tile tile = new Tile(Color.blue,0,1);
        System.out.println(tile);
        Face face = new Face(Color.white);
        System.out.println(face);
        createFaces();
        for(Face face1: faces){
            System.out.println(face1 + "\n");
        }
    }

    public static void createFaces(){
        int i = 0;
        for(Face ignore:faces){
            faces[i] = new Face(new int[]{9-counts[0],9-counts[1],9-counts[2],9-counts[3],9-counts[4],9-counts[5]});
            counts[0] += faces[i].whiteCount;
            counts[1] += faces[i].redCount;
            counts[2] += faces[i].blueCount;
            counts[3] += faces[i].greenCount;
            counts[4] += faces[i].orangeCount;
            counts[5] += faces[i].yellowCount;
            i ++;
        }
    }
}

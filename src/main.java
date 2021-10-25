import java.awt.*;

public class main  {
    // the order of the colors in the array are white, red, blue, green, orange, yellow
    public static void main(String args[]){
        System.out.println("hello world");
        Tile tile = new Tile(Color.blue,0,1);
        System.out.println(tile);
        Face face = new Face(Color.white);
        System.out.println(face);
        Cube cube = new Cube();
        System.out.println(cube);
    }
}

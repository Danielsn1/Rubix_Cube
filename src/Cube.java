import java.awt.*;
import java.util.HashMap;

public class Cube {
    public HashMap<String,Face> faces;
    private static String[] vertical  = {"Front", "Top", "Back", "Bottom"};
    private static String[] horizontal = {"Front", "Left", "Back", "Right"};

    public Cube(){
        faces = new HashMap<>();
        faces.put("Top", new Face(Color.white));
        faces.put("Front", new Face(Color.green));
        faces.put("Back", new Face(Color.blue));
        faces.put("Left", new Face(Color.orange));
        faces.put("Right", new Face(Color.red));
        faces.put("Bottom", new Face(Color.yellow));
    }

    public void rightUp(){
        Face front = faces.get("Front");
        Face top = faces.get("Top");
        Face back = faces.get("Back");
        Face bottom = faces.get("Bottom");

        swapTile(swapTile(swapTile(swapTile(front,top,Direction.FORWARD,Orientation.VERTICAL,2),
                back,Direction.FORWARD,Orientation.VERTICAL,2),
                bottom,Direction.FORWARD,Orientation.VERTICAL,2),
                front,Direction.FORWARD,Orientation.VERTICAL,2);

    }

    public void rightDown() {
        Face front = faces.get("Front");
        Face top = faces.get("Top");
        Face back = faces.get("Back");
        Face bottom = faces.get("Bottom");

        swapTile(swapTile(swapTile(swapTile(front, top, Direction.BACKWARD, Orientation.VERTICAL, 2),
                back, Direction.BACKWARD, Orientation.VERTICAL, 2),
                bottom, Direction.BACKWARD, Orientation.VERTICAL, 2),
                front, Direction.BACKWARD, Orientation.VERTICAL, 2);
    }

    public void leftUp(){
        Face front = faces.get("Front");
        Face top = faces.get("Top");
        Face back = faces.get("Back");
        Face bottom = faces.get("Bottom");

        swapTile(swapTile(swapTile(swapTile(front, top, Direction.FORWARD, Orientation.VERTICAL, 0),
                back, Direction.FORWARD, Orientation.VERTICAL, 0),
                bottom, Direction.FORWARD, Orientation.VERTICAL, 0),
                front, Direction.FORWARD, Orientation.VERTICAL, 0);
    }

    public void leftDown(){
        Face front = faces.get("Front");
        Face top = faces.get("Top");
        Face back = faces.get("Back");
        Face bottom = faces.get("Bottom");

        swapTile(swapTile(swapTile(swapTile(front,top,Direction.BACKWARD,Orientation.VERTICAL,0),
                back,Direction.BACKWARD,Orientation.VERTICAL,0),
                bottom,Direction.BACKWARD,Orientation.VERTICAL,0),
                front,Direction.BACKWARD,Orientation.VERTICAL,0);
    }

    public void topRight(){
        Face front = faces.get("Front");
        Face left = faces.get("Left");
        Face back = faces.get("Back");
        Face right = faces.get("Right");

        swapTile(swapTile(swapTile(swapTile(front,right,Direction.FORWARD,Orientation.HORIZONTAL,0),
                back,Direction.FORWARD,Orientation.HORIZONTAL,0),
                left,Direction.FORWARD,Orientation.HORIZONTAL,0),
                front,Direction.FORWARD,Orientation.HORIZONTAL,0);
    }

    public void topLeft(){
        Face front = faces.get("Front");
        Face left = faces.get("Left");
        Face back = faces.get("Back");
        Face right = faces.get("Right");

        swapTile(swapTile(swapTile(swapTile(front,right,Direction.BACKWARD,Orientation.HORIZONTAL,0),
                back,Direction.BACKWARD,Orientation.HORIZONTAL,0),
                left,Direction.BACKWARD,Orientation.HORIZONTAL,0),
                front,Direction.BACKWARD,Orientation.HORIZONTAL,0);
    }

    public void bottomRight(){
        Face front = faces.get("Front");
        Face left = faces.get("Left");
        Face back = faces.get("Back");
        Face right = faces.get("Right");

        swapTile(swapTile(swapTile(swapTile(front,right,Direction.FORWARD,Orientation.HORIZONTAL,2),
                back,Direction.FORWARD,Orientation.HORIZONTAL,2),
                left,Direction.FORWARD,Orientation.HORIZONTAL,2),
                front,Direction.FORWARD,Orientation.HORIZONTAL,2);
    }

    public void bottomLeft(){
        Face front = faces.get("Front");
        Face left = faces.get("Left");
        Face back = faces.get("Back");
        Face right = faces.get("Right");

        swapTile(swapTile(swapTile(swapTile(front,right,Direction.BACKWARD,Orientation.HORIZONTAL,2),
                back,Direction.BACKWARD,Orientation.HORIZONTAL,2),
                left,Direction.BACKWARD,Orientation.HORIZONTAL,2),
                front,Direction.BACKWARD,Orientation.HORIZONTAL,2);
    }

    private Face swapTile(Face f1, Face f2, Direction dir, Orientation or, int pos){
        Face temp = new Face(Color.WHITE);
        if(or == Orientation.VERTICAL){
            if(dir == Direction.FORWARD){
                for(int i = 0; i < f1.getFace().length; i++){
                    temp.getFace()[i][pos] = f2.getFace()[i][pos];
                    f2.getFace()[i][pos] = f1.getFace()[i][pos];
                }
            }else {
                for(int i = f1.getFace().length; i > 0; i--){
                    temp.getFace()[i][pos] = f2.getFace()[i][pos];
                    f2.getFace()[i][pos] = f1.getFace()[i][pos];
                }
            }
        }else {
            if(dir == Direction.FORWARD){
                for(int i = 0; i < f1.getFace().length; i++){
                    temp.getFace()[pos][i] = f2.getFace()[pos][i];
                    f2.getFace()[pos][i] = f1.getFace()[pos][i];
                }
            }else {
                for(int i = f1.getFace().length; i > 0; i--){
                    temp.getFace()[pos][i] = f2.getFace()[pos][i];
                    f2.getFace()[pos][i] = f1.getFace()[pos][i];
                }
            }
        }
        return temp;
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
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

        swapTile(swapTile(swapTile(swapTile(front,top),back),bottom),front);
        //System.out.println("\n\n" + front + top + back + bottom + "\n\n");
    }

    public void rightDown(){
        Face front = faces.get("Front");
        Face top = faces.get("Top");
        Face back = faces.get("Back");
        Face bottom = faces.get("Bottom");

        for(int i = 0; i < front.getFace().length; i++){
            top.getFace()[i][2] = faces.get("Back").getFace()[i][2];
            back.getFace()[i][2] = faces.get("Bottom").getFace()[i][2];
            bottom.getFace()[i][2] = faces.get("Front").getFace()[i][2];
            front.getFace()[i][2] = faces.get("Top").getFace()[i][2];
        }

        faces.put("Top", top);
        faces.put("Front", front);
        faces.put("Bottom", bottom);
        faces.put("Back", back);
    }

    public void leftUp(){
        Face front = faces.get("Front");
        Face top = faces.get("Top");
        Face back = faces.get("Back");
        Face bottom = faces.get("Bottom");

        for(int i = 0; i < front.getFace().length; i++){
            top.getFace()[i][0] = faces.get("Front").getFace()[i][0];
            back.getFace()[i][0] = faces.get("Top").getFace()[i][0];
            bottom.getFace()[i][0] = faces.get("Back").getFace()[i][0];
            front.getFace()[i][0] = faces.get("Bottom").getFace()[i][0];
        }

        faces.put("Top", top);
        faces.put("Front", front);
        faces.put("Bottom", bottom);
        faces.put("Back", back);
    }

    public void leftDown(){
        Face front = faces.get("Front");
        Face top = faces.get("Top");
        Face back = faces.get("Back");
        Face bottom = faces.get("Bottom");

        for(int i = 0; i < front.getFace().length; i++){
            top.getFace()[i][0] = faces.get("Back").getFace()[i][0];
            back.getFace()[i][0] = faces.get("Bottom").getFace()[i][0];
            bottom.getFace()[i][0] = faces.get("Front").getFace()[i][0];
            front.getFace()[i][0] = faces.get("Top").getFace()[i][0];
        }

        faces.put("Top", top);
        faces.put("Front", front);
        faces.put("Bottom", bottom);
        faces.put("Back", back);
    }

    public void topRight(){
        Face front = faces.get("Front");
        Face left = faces.get("Left");
        Face back = faces.get("Back");
        Face right = faces.get("Right");

        for(int i = 0; i < front.getFace()[0].length; i++){
            right.getFace()[0][i] = faces.get("Front").getFace()[0][i];
            back.getFace()[0][i] = faces.get("Right").getFace()[0][i];
            left.getFace()[0][i] = faces.get("Back").getFace()[0][i];
            front.getFace()[0][i] = faces.get("Left").getFace()[0][i];
        }

        faces.put("Right", right);
        faces.put("Front", front);
        faces.put("Left", left);
        faces.put("Back", back);
    }

    public void topLeft(){
        Face front = faces.get("Front");
        Face left = faces.get("Left");
        Face back = faces.get("Back");
        Face right = faces.get("Right");

        for(int i = 0; i < front.getFace()[0].length; i++){
            right.getFace()[0][i] = faces.get("Back").getFace()[0][i];
            back.getFace()[0][i] = faces.get("Left").getFace()[0][i];
            left.getFace()[0][i] = faces.get("Front").getFace()[0][i];
            front.getFace()[0][i] = faces.get("Right").getFace()[0][i];
        }

        faces.put("Right", right);
        faces.put("Front", front);
        faces.put("Left", left);
        faces.put("Back", back);
    }

    public void bottomRight(){
        Face front = faces.get("Front");
        Face left = faces.get("Left");
        Face back = faces.get("Back");
        Face right = faces.get("Right");

        for(int i = 0; i < front.getFace()[2].length; i++){
            right.getFace()[2][i] = faces.get("Front").getFace()[2][i];
            back.getFace()[2][i] = faces.get("Right").getFace()[2][i];
            left.getFace()[2][i] = faces.get("Back").getFace()[2][i];
            front.getFace()[2][i] = faces.get("Left").getFace()[2][i];
        }

        faces.put("Right", right);
        faces.put("Front", front);
        faces.put("Left", left);
        faces.put("Back", back);
    }

    public void bottomLeft(){
        Face front = faces.get("Front");
        Face left = faces.get("Left");
        Face back = faces.get("Back");
        Face right = faces.get("Right");

        for(int i = 0; i < front.getFace()[2].length; i++){
            right.getFace()[2][i] = faces.get("Back").getFace()[2][i];
            back.getFace()[2][i] = faces.get("Left").getFace()[2][i];
            left.getFace()[2][i] = faces.get("Front").getFace()[2][i];
            front.getFace()[2][i] = faces.get("Right").getFace()[2][i];
        }

        faces.put("Right", right);
        faces.put("Front", front);
        faces.put("Left", left);
        faces.put("Back", back);
    }

    private Face swapTile(Face f1, Face f2, Direction dir, Orientation or, int pos){
        Face temp = new Face(Color.WHITE);
        for(int i = 0; i < f1.getFace().length; i++){
            temp.getFace()[i][2] = f2.getFace()[i][2];
            f2.getFace()[i][2] = f1.getFace()[i][2];
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
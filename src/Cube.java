import java.awt.*;
import java.util.HashMap;
import java.util.Random;

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

        swapTile(swapTile(swapTile(swapTile(front,top,Orientation.VERTICAL,2),
                back,Orientation.VERTICAL,2),
                bottom,Orientation.VERTICAL,2),
                front,Orientation.VERTICAL,2);

    }

    public void rightDown() {
        Face front = faces.get("Front");
        Face top = faces.get("Top");
        Face back = faces.get("Back");
        Face bottom = faces.get("Bottom");

        swapTile(swapTile(swapTile(swapTile(front, bottom, Orientation.VERTICAL, 2),
                back, Orientation.VERTICAL, 2),
                top, Orientation.VERTICAL, 2),
                front, Orientation.VERTICAL, 2);
    }

    public void leftUp(){
        Face front = faces.get("Front");
        Face top = faces.get("Top");
        Face back = faces.get("Back");
        Face bottom = faces.get("Bottom");

        swapTile(swapTile(swapTile(swapTile(front, top, Orientation.VERTICAL, 0),
                back, Orientation.VERTICAL, 0),
                bottom, Orientation.VERTICAL, 0),
                front, Orientation.VERTICAL, 0);
    }

    public void leftDown(){
        Face front = faces.get("Front");
        Face top = faces.get("Top");
        Face back = faces.get("Back");
        Face bottom = faces.get("Bottom");

        swapTile(swapTile(swapTile(swapTile(front,bottom,Orientation.VERTICAL,0),
                back,Orientation.VERTICAL,0),
                top,Orientation.VERTICAL,0),
                front,Orientation.VERTICAL,0);
    }

    public void topRight(){
        Face front = faces.get("Front");
        Face left = faces.get("Left");
        Face back = faces.get("Back");
        Face right = faces.get("Right");

        swapTile(swapTile(swapTile(swapTile(front,right,Orientation.HORIZONTAL,0),
                back,Orientation.HORIZONTAL,0),
                left,Orientation.HORIZONTAL,0),
                front,Orientation.HORIZONTAL,0);
    }

    public void topLeft(){
        Face front = faces.get("Front");
        Face left = faces.get("Left");
        Face back = faces.get("Back");
        Face right = faces.get("Right");

        swapTile(swapTile(swapTile(swapTile(front,left,Orientation.HORIZONTAL,0),
                back,Orientation.HORIZONTAL,0),
                right,Orientation.HORIZONTAL,0),
                front,Orientation.HORIZONTAL,0);
    }

    public void bottomRight(){
        Face front = faces.get("Front");
        Face left = faces.get("Left");
        Face back = faces.get("Back");
        Face right = faces.get("Right");

        swapTile(swapTile(swapTile(swapTile(front,right,Orientation.HORIZONTAL,2),
                back,Orientation.HORIZONTAL,2),
                left,Orientation.HORIZONTAL,2),
                front,Orientation.HORIZONTAL,2);
    }

    public void bottomLeft(){
        Face front = faces.get("Front");
        Face left = faces.get("Left");
        Face back = faces.get("Back");
        Face right = faces.get("Right");

        swapTile(swapTile(swapTile(swapTile(front,left,Orientation.HORIZONTAL,2),
                back,Orientation.HORIZONTAL,2),
                right,Orientation.HORIZONTAL,2),
                front,Orientation.HORIZONTAL,2);
    }

    private Face swapTile(Face f1, Face f2, Orientation or, int pos){
        Face temp = new Face(Color.WHITE);
        if(or == Orientation.VERTICAL){
            for(int i = 0; i < f1.getFace().length; i++){
                temp.getFace()[i][pos] = f2.getFace()[i][pos];
                f2.getFace()[i][pos] = f1.getFace()[i][pos];
            }
        }else {
            for(int i = 0; i < f1.getFace().length; i++){
                temp.getFace()[pos][i] = f2.getFace()[pos][i];
                f2.getFace()[pos][i] = f1.getFace()[pos][i];
            }
        }
        return temp;
    }

    public void shuffle(){
        Random rand = new Random();
        for(int i = 0; i < 20; i++){
            switch(rand.nextInt(8)){
                case 0:
                    rightUp();
                    System.out.println("rightUp");
                    break;
                case 1:
                    rightDown();
                    System.out.println("rightDown");
                    break;
                case 2:
                    leftUp();
                    System.out.println("leftUp");
                    break;
                case 3:
                    leftDown();
                    System.out.println("leftDown");
                    break;
                case 4:
                    topRight();
                    System.out.println("topRight");
                    break;
                case 5:
                    topLeft();
                    System.out.println("topLeft");
                    break;
                case 6:
                    bottomRight();
                    System.out.println("bottomRight");
                    break;
                case 7:
                    bottomLeft();
                    System.out.println("bottomLeft");
                    break;
                default:
                    break;
            }
        }
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
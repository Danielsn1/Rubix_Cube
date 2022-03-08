import java.awt.Color;

public class Tile {
    private Color color;
    private int[] position;

    public Tile(Color clr, Integer xpos, Integer ypos){
        color = clr;
        position = new int[]{xpos,ypos};
    }

    public Color getColor() {
        return color;
    }

    public int[] getPosition() {
        return position;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public String toString(){
        return "Color: " + color + "\nPosition: " + position[0] + ", " + position[1];
    }
}

package Forms;
import java.awt.Graphics;


public class Tri implements Geometry {
    private int[] coordenadasX;
    private int[] coordenadasY;

    public Tri(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.coordenadasX = new int[]{x1, x2, x3};
        this.coordenadasY = new int[]{y1, y2, y3};
    }


    public void desenhar(Graphics g) {
        g.drawPolygon(coordenadasX, coordenadasY, 3);
    }

}
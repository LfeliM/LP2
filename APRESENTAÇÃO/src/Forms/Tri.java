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

    public boolean contem(int px, int py) {
        java.awt.Polygon p = new java.awt.Polygon(coordenadasX, coordenadasY, 3);
        return p.contains(px, py);
    }


    public void mover(int deltaX, int deltaY) {
        for (int i = 0; i < 3; i++) {
            coordenadasX[i] += deltaX;
            coordenadasY[i] += deltaY;
        }
    }

}
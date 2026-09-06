package Forms;
import java.awt.Graphics;

import java.awt.Graphics;

public class Line implements Geometry {
    private int x1, y1, x2, y2;

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void desenhar(Graphics g) {
        g.drawLine(x1, y1, x2, y2);
    }


    public boolean contem(int px, int py) {
        double distancia = java.awt.geom.Line2D.ptSegDist(x1, y1, x2, y2, px, py);
        return distancia <= 5.0;
    }

    public void mover(int deltaX, int deltaY) {
        this.x1 += deltaX;
        this.y1 += deltaY;
        this.x2 += deltaX;
        this.y2 += deltaY;
    }

}
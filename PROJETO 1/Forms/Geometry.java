package Forms;
import java.awt.Graphics;


public interface Geometry {

    void desenhar(Graphics g);
    boolean contem(int px, int py);
    void mover(int deltaX, int deltaY);
}

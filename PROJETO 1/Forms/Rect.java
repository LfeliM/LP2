package Forms;
import java.awt.Graphics;
public class Rect implements Geometry {
    private int x, y, largura, altura;

    public Rect(int x, int y, int largura, int altura) {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
    }

    public void desenhar(Graphics g) {
        g.drawRect(x, y, largura, altura);
    }


    public boolean contem(int px, int py) {
        return px >= x && px <= x + largura && py >= y && py <= y + altura;
    }


    public void mover(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

}


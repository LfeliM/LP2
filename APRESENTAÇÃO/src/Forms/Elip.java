package Forms;
import java.awt.Graphics;
public class Elip implements Geometry {
    private int x, y, largura, altura;

    public Elip(int x, int y, int semiEixoHorizontal, int semiEixoVertical) {
        this.x = x;
        this.y = y;
        this.largura = semiEixoHorizontal * 2;
        this.altura = semiEixoVertical * 2;
    }

    public void desenhar(Graphics g) {
        g.drawOval(x, y, largura, altura);

    }

    public boolean contem(int px, int py) {
        return px >= x && px <= x + largura && py >= y && py <= y + altura;
    }


    public void mover(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

}
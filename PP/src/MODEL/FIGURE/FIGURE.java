package MODEL.FIGURE;
import java.awt.Color;

public abstract class FIGURE {

    protected Color corPreenchimento = new Color(235, 235, 235);
    protected int x;
    protected int y;
    protected boolean preenchido;

    public FIGURE(int x, int y) {
        this.x = x;
        this.y = y;
        this.preenchido = false;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public Color getCorPreenchimento() { return corPreenchimento; }
    public void setCorPreenchimento(Color cor) { this.corPreenchimento = cor; }

    public void MOVER(int deltaX, int deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    public abstract boolean CONTACT(int px, int py);
    public abstract int VERTCLICK(int px, int py);
    public abstract void SIZER(int idVertice, int novoX, int novoY);

    protected boolean isProximo(int vx, int vy, int px, int py) {
        return Math.hypot(vx - px, vy - py) <= 20.0;
    }
}
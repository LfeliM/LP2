package MODEL.FIGURE;

public class LINE extends FIGURE {
    private int x2;
    private int y2;

    public LINE(int x, int y, int x2, int y2) {
        super(x, y);
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getX2() { return x2; }
    public int getY2() { return y2; }

    @Override
    public void MOVER(int deltaX, int deltaY) {
        super.MOVER(deltaX, deltaY);
        this.x2 += deltaX;
        this.y2 += deltaY;
    }

    @Override
    public boolean CONTACT(int px, int py) {
        double comprimentoQuadrado = Math.pow(x - x2, 2) + Math.pow(y - y2, 2);
        if (comprimentoQuadrado == 0) return Math.hypot(x - px, y - py) <= 5.0;

        double t = Math.max(0, Math.min(1, ((px - x) * (x2 - x) + (py - y) * (y2 - y)) / comprimentoQuadrado));
        double projX = x + t * (x2 - x);
        double projY = y + t * (y2 - y);

        return Math.hypot(px - projX, py - projY) <= 5.0;
    }

    @Override
    public int VERTCLICK(int px, int py) {
        double tolerancia = 12.0;
        if (Math.hypot(x - px, y - py) <= tolerancia) return 0;
        if (Math.hypot(x2 - px, y2 - py) <= tolerancia) return 1;
        return -1;
    }

    @Override
    public void SIZER(int idVertice, int novoX, int novoY) {
        if (idVertice == 0) {
            this.x = novoX;
            this.y = novoY;
        } else if (idVertice == 1) {
            this.x2 = novoX;
            this.y2 = novoY;
        }
    }
}
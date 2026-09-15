package MODEL.FIGURE;

public class TRI extends FIGURE {
    private int largura;
    private int altura;

    public TRI(int x, int y, int largura, int altura) {
        super(x, y);
        this.largura = largura;
        this.altura = altura;
    }

    @Override public int getX() { return largura < 0 ? x + largura : x; }
    @Override public int getY() { return altura < 0 ? y + altura : y; }
    public int getLargura() { return Math.abs(largura); }
    public int getAltura() { return Math.abs(altura); }

    @Override
    public boolean CONTACT(int px, int py) {
        int rx = getX();
        int ry = getY();
        int rw = getLargura();
        int rh = getAltura();

        int x1 = rx + rw / 2; int y1 = ry;
        int x2 = rx + rw;     int y2 = ry + rh;
        int x3 = rx;          int y3 = ry + rh;

        double areaTotal = Math.abs((x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1));

        double areaA = Math.abs((x1 - px) * (y2 - py) - (x2 - px) * (y1 - py));
        double areaB = Math.abs((x2 - px) * (y3 - py) - (x3 - px) * (y2 - py));
        double areaC = Math.abs((x3 - px) * (y1 - py) - (x1 - px) * (y3 - py));

        return Math.abs((areaA + areaB + areaC) - areaTotal) <= 1.0;
    }

    @Override
    public int VERTCLICK(int px, int py) {
        if (isProximo(x, y, px, py)) return 0;
        if (isProximo(x + largura, y, px, py)) return 1;
        if (isProximo(x + largura, y + altura, px, py)) return 2;
        if (isProximo(x, y + altura, px, py)) return 3;
        return -1;
    }

    @Override
    public void SIZER(int idVertice, int novoX, int novoY) {
        switch (idVertice) {
            case 0:
                int aX0 = this.x + this.largura; int aY0 = this.y + this.altura;
                this.x = novoX; this.y = novoY;
                this.largura = aX0 - this.x; this.altura = aY0 - this.y; break;
            case 1:
                int aY1 = this.y + this.altura;
                this.y = novoY; this.largura = novoX - this.x; this.altura = aY1 - this.y; break;
            case 2:
                this.largura = novoX - this.x; this.altura = novoY - this.y; break;
            case 3:
                int aX3 = this.x + this.largura;
                this.x = novoX; this.largura = aX3 - this.x; this.altura = novoY - this.y; break;
        }
    }
}
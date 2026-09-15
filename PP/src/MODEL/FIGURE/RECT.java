package MODEL.FIGURE;

public class RECT extends FIGURE {
    private int largura;
    private int altura;

    public RECT(int x, int y, int largura, int altura) {
        super(x, y);
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public int getX() { return largura < 0 ? x + largura : x; }

    @Override
    public int getY() { return altura < 0 ? y + altura : y; }

    public int getLargura() { return Math.abs(largura); }

    public int getAltura() { return Math.abs(altura); }

    @Override
    public boolean CONTACT(int px, int py) {
        int rx = getX();
        int ry = getY();
        int rw = getLargura();
        int rh = getAltura();
        return px >= rx && px <= rx + rw && py >= ry && py <= ry + rh;
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
                int ancoraX0 = this.x + this.largura;
                int ancoraY0 = this.y + this.altura;
                this.x = novoX;
                this.y = novoY;
                this.largura = ancoraX0 - this.x;
                this.altura = ancoraY0 - this.y;
                break;
            case 1:
                int ancoraY1 = this.y + this.altura;
                this.y = novoY;
                this.largura = novoX - this.x;
                this.altura = ancoraY1 - this.y;
                break;
            case 2:
                this.largura = novoX - this.x;
                this.altura = novoY - this.y;
                break;
            case 3:
                int ancoraX3 = this.x + this.largura;
                this.x = novoX;
                this.largura = ancoraX3 - this.x;
                this.altura = novoY - this.y;
                break;
        }
    }
}
package MODEL.FIGURE;

//CLASSE PUBLICA ABSTRATA QUE HERDA DA PASTA PRINCIPAL FIGURE

public class Carro extends FIGURE {

//METODOS PROTEGIDOS PRA MOVIMENTAÇÃO DE CLASSE

    private ELIP R1;
    private ELIP R2;
    private RECT Chassi;
    
//DECLARAÇÃO DAS VARIAVEIS PRA ALTURA LARGURA E COORDENADAS DA NOVA FORMULA

    public CARRO(int x1, int y1, int x2, int y2) {
        super(x1, y1, x2, y2);
        int Iniciox = math.min(x1, x2);
        int Inicioy = math.max(x1, x2);
        int FimX = math.max(y1, y2);
        int FimY = math.min(y1, y2);


        int larguraTotal = FimX - Iniciox;
        int alturaTotal =  FimY - inicioy;

        this.Chassi = new RECT(
            InicioX,
            InicioY,
            FimX,
            Inicio y +(alturaTotal * 2 / 3);
//Cria a roda esquerda        
        this.R1 = new ELIP(
            InicioX + larguraTotal / 8,
            InicioY + (alturaTotal* 2 / 3,
            FimY =(larguraTotal* 3 / 8),
            
//Cria a roda direita
        this.R2 = new ELIP(
            FimX + larguraTotal * 3/ 8,
            InicioY + (alturaTotal* 2 / 3,
            FimX =(larguraTotal / 8,
            FimY);
    }

//pincel pras figuras desenharem
    public void desenhar(Graphic g) {
        
        this.Chassi.desenhar(g);
        this.R1.desenhar(g);
        This.R2.desenhar(g);
//VARIAVEIS PRA LISTA DO FOCO
    public int getX1(){return x1;}
    public int gety1(){return x1;}
    public int getX2(){return x1;}
    public int getY2(){return x1;}





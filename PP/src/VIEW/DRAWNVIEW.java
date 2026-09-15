package VIEW;

import MODEL.FIGURE.FIGURE;
import MODEL.FIGURE.RECT;
import MODEL.FIGURE.LINE;
import MODEL.FIGURE.ELIP;
import MODEL.FIGURE.TRI;
import MODEL.FIGURE.CARRO;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class DRAWNVIEW extends Frame {

    private Label lblFerramenta;
    private Label lblCorAtual;
    private PainelDesenho painel;

    private List<FIGURE> formas;
    private FIGURE formaTemporaria = null;
    private FIGURE formaSelecionada = null;
    private FIGURE formaHover = null;

    private String ferramentaAtual = "Retângulo";

    public DRAWNVIEW(List<FIGURE> formas) {
//Declara lista de figuras
        public ArrayList<FIGURE> listaFiguras = new ArrayList<>();
//Declara o foco da lista
        public int IndiceFoco = -1;

        this.formas = formas;

        setTitle("Teste AWT - Editor Vetorial MVC (Cores e Atalhos)");
        setSize(950, 600);
        setLayout(new BorderLayout());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        Panel barraFerramentas = new Panel();
        barraFerramentas.setBackground(Color.LIGHT_GRAY);

        Label lblAtalhos = new Label("Formas: [R] Rect | [L] Linha | [E] Elip | [T] Tri | [C] Limpar");
        Label lblCores = new Label("Cores: [4] Cinza | [5] Vermelho | [6] Verde | [7] Azul | [8] Amarelo");
        lblCores.setForeground(Color.DARK_GRAY);

        lblFerramenta = new Label("Ferramenta: Retângulo");
        lblFerramenta.setFont(new Font("Arial", Font.BOLD, 12));

        lblCorAtual = new Label("(Cor: Cinza)");
        lblCorAtual.setFont(new Font("Arial", Font.BOLD, 12));

        barraFerramentas.add(lblAtalhos);
        barraFerramentas.add(new Label(" || "));
        barraFerramentas.add(lblCores);
        barraFerramentas.add(new Label(" || "));
        barraFerramentas.add(lblFerramenta);
        barraFerramentas.add(lblCorAtual);

        add(barraFerramentas, BorderLayout.NORTH);

        painel = new PainelDesenho();
        painel.setFocusable(true);
        add(painel, BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }

    public void setFerramentaAtual(String ferramenta) {
        this.ferramentaAtual = ferramenta;
        lblFerramenta.setText("Ferramenta: " + ferramenta);
        painel.requestFocus();
    }

    public void setCorAtualTexto(String corNome) {
        lblCorAtual.setText("(Cor: " + corNome + ")");
        painel.requestFocus();
    }

    public String getFerramentaAtual() { return ferramentaAtual; }

    public void focarPainel() { painel.requestFocus(); }
    public void setFormaTemporaria(FIGURE forma) { this.formaTemporaria = forma; }
    public void setFormaSelecionada(FIGURE forma) { this.formaSelecionada = forma; }
    public void setFormaHover(FIGURE forma) { this.formaHover = forma; }
    public void atualizarTela() { painel.repaint(); }

    public void addMouseListenerToPainel(MouseListener l) { painel.addMouseListener(l); }
    public void addMouseMotionListenerToPainel(MouseMotionListener l) { painel.addMouseMotionListener(l); }

    public void addKeyListenerToPainel(KeyListener l) {
        painel.addKeyListener(l);
        this.addKeyListener(l);
    }

    class PainelDesenho extends Panel {
        public PainelDesenho() { setBackground(Color.WHITE); }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
//cria o laço de figuras que estarão em foco
            for (int i=0; i < listaFiguras.size(); i++){
                FIGURE figura = listaFiguras.get(i):
                figura.desenhar(g);
                if(i == IndiceFoco){
                    get.setColor(Color.RED);
                    int minX = Math min(figura.getX1(), figura.getX2());
                    int minY = Math.min(figura.getY1(), figura.getY2());
                    int larg = Math.abs(figura.getX2()-figura.getX1());
                    int alt = Math.abs(figura.getY2()-figura.getY1());
                    g.drawRect(minX - 5, minY -5, larg +10, alt +10);
                    g.setColor(Color.Black) ;
                }
            }
                
            for (FIGURE forma : formas) { desenharFigura(g, forma); }
            if (formaTemporaria != null) { desenharFigura(g, formaTemporaria); }
        }

        private void desenharFigura(Graphics g, FIGURE forma) {

            g.setColor(forma.getCorPreenchimento());

            if (forma instanceof RECT) {
                RECT r = (RECT) forma;
                g.fillRect(r.getX(), r.getY(), r.getLargura(), r.getAltura());
            } else if (forma instanceof ELIP) {
                ELIP e = (ELIP) forma;
                g.fillOval(e.getX(), e.getY(), e.getLargura(), e.getAltura());
            } else if (forma instanceof TRI) {
                TRI t = (TRI) forma;
                int[] xPoints = { t.getX() + t.getLargura() / 2, t.getX() + t.getLargura(), t.getX() };
                int[] yPoints = { t.getY(), t.getY() + t.getAltura(), t.getY() + t.getAltura() };
                g.fillPolygon(xPoints, yPoints, 3);
            }

            if (forma == formaSelecionada || forma == formaHover) g.setColor(Color.RED);
            else g.setColor(Color.BLACK);

            if (forma instanceof RECT) {
                RECT r = (RECT) forma;
                g.drawRect(r.getX(), r.getY(), r.getLargura(), r.getAltura());
                if (forma == formaSelecionada || forma == formaHover) desenharVerticesBox(g, r.getX(), r.getY(), r.getLargura(), r.getAltura());
            } else if (forma instanceof ELIP) {
                ELIP e = (ELIP) forma;
                g.drawOval(e.getX(), e.getY(), e.getLargura(), e.getAltura());
                if (forma == formaSelecionada || forma == formaHover) desenharVerticesBox(g, e.getX(), e.getY(), e.getLargura(), e.getAltura());
            } else if (forma instanceof TRI) {
                TRI t = (TRI) forma;
                int[] xPoints = { t.getX() + t.getLargura() / 2, t.getX() + t.getLargura(), t.getX() };
                int[] yPoints = { t.getY(), t.getY() + t.getAltura(), t.getY() + t.getAltura() };
                g.drawPolygon(xPoints, yPoints, 3);
                if (forma == formaSelecionada || forma == formaHover) desenharVerticesBox(g, t.getX(), t.getY(), t.getLargura(), t.getAltura());
            } else if (forma instanceof LINE) {
                LINE l = (LINE) forma;
                g.drawLine(l.getX(), l.getY(), l.getX2(), l.getY2());
                if (forma == formaSelecionada || forma == formaHover) {
                    g.setColor(Color.BLUE);
                    g.fillRect(l.getX() - 3, l.getY() - 3, 6, 6);
                    g.fillRect(l.getX2() - 3, l.getY2() - 3, 6, 6);
                }
            }
        }

        private void desenharVerticesBox(Graphics g, int x, int y, int w, int h) {
            g.setColor(Color.BLUE);
            int s = 6, off = s / 2;
            g.fillRect(x - off, y - off, s, s);
            g.fillRect(x + w - off, y - off, s, s);
            g.fillRect(x + w - off, y + h - off, s, s);
            g.fillRect(x - off, y + h - off, s, s);
        }
    }
}

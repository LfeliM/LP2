package GUI;

import Forms.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    private JFrame janela;
    private JComboBox<String> comboFormas;
    private PainelDesenho painel;

    public void iniciar() {

        janela = new JFrame("Interface ");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(800, 600);
        janela.setLayout(new BorderLayout());


        JPanel barraFerramentas = new JPanel();
        barraFerramentas.setBackground(Color.LIGHT_GRAY);
        barraFerramentas.add(new JLabel("Ferramenta: "));

        comboFormas = new JComboBox<>(new String[]{"Retângulo", "Elipse", "Linha", "Triângulo"});
        barraFerramentas.add(comboFormas);

        JButton btnLimpar = new JButton("Limpar Tela");
        btnLimpar.addActionListener(e -> {
            painel.limpar();
        });
        barraFerramentas.add(btnLimpar);

        janela.add(barraFerramentas, BorderLayout.NORTH);

        painel = new PainelDesenho();
        janela.add(painel, BorderLayout.CENTER);

        janela.setLocationRelativeTo(null);
        janela.setVisible(true);
    }

    class PainelDesenho extends JPanel {
        private List<Geometry> formas = new ArrayList<>();

        private int startX, startY, currentX, currentY;
        private boolean desenhando = false;


        private Geometry formaSelecionada = null;
        private int lastX, lastY;

        public PainelDesenho() {
            setBackground(Color.WHITE);

            setFocusable(true);

            addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent e) {

                    char tecla = Character.toLowerCase(e.getKeyChar());

                    switch (tecla) {
                        case 'r':
                            comboFormas.setSelectedItem("Retângulo");
                            break;
                        case 'e':
                            comboFormas.setSelectedItem("Elipse");
                            break;
                        case 'l':
                            comboFormas.setSelectedItem("Linha");
                            break;
                        case 't':
                            comboFormas.setSelectedItem("Triângulo");
                            break;
                    }
                }
            });

            MouseAdapter mouseHandler = new MouseAdapter() {


                public void mousePressed(MouseEvent e) {

                    requestFocusInWindow();

                    if (SwingUtilities.isRightMouseButton(e)) {
                        for (int i = formas.size() - 1; i >= 0; i--) {
                            Geometry forma = formas.get(i);
                            if (forma.contem(e.getX(), e.getY())) {
                                formas.remove(i);
                                repaint();
                                break;
                            }
                        }
                        return;
                    }

                    formaSelecionada = null;

                    for (int i = formas.size() - 1; i >= 0; i--) {
                        Geometry forma = formas.get(i);
                        if (forma.contem(e.getX(), e.getY())) {
                            formaSelecionada = forma;
                            lastX = e.getX();
                            lastY = e.getY();
                            break;
                        }
                    }

                    if (formaSelecionada == null) {
                        startX = e.getX();
                        startY = e.getY();
                        currentX = startX;
                        currentY = startY;
                        desenhando = true;
                    }
                }

                public void mouseDragged(MouseEvent e) {
                    

                    if (formaSelecionada != null) {
                        int deltaX = e.getX() - lastX;
                        int deltaY = e.getY() - lastY;

                        formaSelecionada.mover(deltaX, deltaY);

                        lastX = e.getX();
                        lastY = e.getY();
                        repaint();
                    }

                    else if (desenhando) {
                        currentX = e.getX();
                        currentY = e.getY();
                        repaint();
                    }
                }

                public void mouseReleased(MouseEvent e) {

                    if (formaSelecionada != null) {
                        formaSelecionada = null;
                        repaint();
                    }

                    else if (desenhando) {
                        currentX = e.getX();
                        currentY = e.getY();
                        desenhando = false;

                        Geometry novaForma = criarFormaGeometrica();
                        if (novaForma != null) {
                            formas.add(novaForma);
                        }
                        repaint();
                    }
                }
            };

            addMouseListener(mouseHandler);
            addMouseMotionListener(mouseHandler);
        }

        public void limpar() {
            formas.clear();
            repaint();
        }

        private Geometry criarFormaGeometrica() {
            String tipo = (String) comboFormas.getSelectedItem();


            int x = Math.min(startX, currentX);
            int y = Math.min(startY, currentY);
            int largura = Math.abs(startX - currentX);
            int altura = Math.abs(startY - currentY);

            if (largura == 0 && altura == 0 && !tipo.equals("Linha")) {
                return null;
            }

            if (tipo.equals("Retângulo")) {
                return new Rect(x, y, largura, altura);

            } else if (tipo.equals("Elipse")) {
                return new Elip(x, y, largura / 2, altura / 2);

            } else if (tipo.equals("Linha")) {
                return new Line(startX, startY, currentX, currentY);

            } else if (tipo.equals("Triângulo")) {
                int x1 = x + (largura / 2);
                int y1 = y;
                int x2 = x;
                int y2 = y + altura;
                int x3 = x + largura;
                int y3 = y + altura;
                return new Tri(x1, y1, x2, y2, x3, y3);
            }

            return null;
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (Geometry forma : formas) {
                if (forma == formaSelecionada) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor(Color.BLACK);
                }

                forma.desenhar(g);
            }

            if (desenhando) {
                g.setColor(Color.RED);
                Geometry formaTemporaria = criarFormaGeometrica();
                if (formaTemporaria != null) {
                    formaTemporaria.desenhar(g);
                }
                g.setColor(Color.BLACK);
            }
        }
    }

}
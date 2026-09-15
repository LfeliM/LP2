package CONTROL;

import MODEL.FIGURE.FIGURE;
import MODEL.FIGURE.RECT;
import MODEL.FIGURE.LINE;
import MODEL.FIGURE.ELIP;
import MODEL.FIGURE.TRI;
import MODEL.FIGURE.CARRO;
import VIEW.DRAWNVIEW;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class DRAWNCONTROL {

	private DRAWNVIEW view;
	private List<FIGURE> model;

	private int startX, startY, currentX, currentY, lastX, lastY;
	private boolean desenhando = false;
	private FIGURE formaSelecionada = null;
	private int verticeSelecionado = -1;
	private Color corAtual = new Color(235, 235, 235);

	public DRAWNCONTROL(DRAWNVIEW view, List<FIGURE> model) {
		this.view = view;
		this.model = model;
		initListeners();
	}

	private void initListeners() {

		KeyAdapter keyHandler = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char tecla = Character.toLowerCase(e.getKeyChar());

				switch (tecla) {
				case 'r':
					view.setFerramentaAtual("Retângulo");
					break;
				case 'l':
					view.setFerramentaAtual("Linha");
					break;
				case 'e':
					view.setFerramentaAtual("Elipse");
					break;
				case 't':
					view.setFerramentaAtual("Triângulo");
					break;
				//cases alterados pra função do foco(commit 2) e do carro(commit 1)
				case '1':
					view.setFerramentaAtual("CARRO");
					break;
				case '2';
					/
					if(!tela.listaFiguras.isEmpty()) {
						tela.IndiceFoco = (tela.IndiceFoco + 1) % tela.listaFiguras.size();
						tela.painelDesenho.repaint();
					}
					break;
				case 'c':
					model.clear();
					view.atualizarTela();
					break;
				case '4':
					mudarCor(new Color(235, 235, 235), "Cinza");
					break;
				case '5':
					mudarCor(Color.RED, "Vermelho");
					break;
				case '6':
					mudarCor(Color.GREEN, "Verde");
					break;
				case '7':
					mudarCor(Color.BLUE, "Azul");
					break;
				case '8':
					mudarCor(Color.YELLOW, "Amarelo");
					break;
				}
			}
		};
		view.addKeyListenerToPainel(keyHandler);

		MouseAdapter mouseHandler = new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				int mx = e.getX();
				int my = e.getY();
				FIGURE figuraSobMouse = null;

				for (int i = model.size() - 1; i >= 0; i--) {
					FIGURE f = model.get(i);
					if (f.CONTACT(mx, my) || f.VERTCLICK(mx, my) != -1) {
						figuraSobMouse = f;
						break;
					}
				}
				view.setFormaHover(figuraSobMouse);
				view.atualizarTela();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				view.focarPainel();
				int mx = e.getX();
				int my = e.getY();

				if (e.getButton() == MouseEvent.BUTTON3) {
					for (int i = model.size() - 1; i >= 0; i--) {
						FIGURE f = model.get(i);
						if (f.CONTACT(mx, my) || f.VERTCLICK(mx, my) != -1) {
							if (f == formaSelecionada) {
								formaSelecionada = null;
								view.setFormaSelecionada(null);
							}
							model.remove(i);
							view.atualizarTela();
							break;
						}
					}
					return;
				}

				verticeSelecionado = -1;
				formaSelecionada = null;

				for (int i = model.size() - 1; i >= 0; i--) {
					FIGURE f = model.get(i);
					int vIdx = f.VERTCLICK(mx, my);
					if (vIdx != -1) {
						formaSelecionada = f;
						verticeSelecionado = vIdx;
						model.remove(i);
						model.add(formaSelecionada);
						break;
					}
					if (f.CONTACT(mx, my)) {
						formaSelecionada = f;
						lastX = mx;
						lastY = my;
						model.remove(i);
						model.add(formaSelecionada);
						break;
					}
				}

				view.setFormaSelecionada(formaSelecionada);

				if (formaSelecionada == null) {
					startX = mx;
					startY = my;
					currentX = mx;
					currentY = my;
					desenhando = true;
				}
				view.atualizarTela();
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				int mx = e.getX();
				int my = e.getY();

				if (verticeSelecionado != -1 && formaSelecionada != null) {
					formaSelecionada.SIZER(verticeSelecionado, mx, my);
				}
				else if (formaSelecionada != null) {
					int deltaX = mx - lastX;
					int deltaY = my - lastY;
					formaSelecionada.MOVER(deltaX, deltaY);
					lastX = mx;
					lastY = my;
				}
				else if (desenhando) {
					currentX = mx;
					currentY = my;
					view.setFormaTemporaria(criarFormaTemp());
				}
				view.atualizarTela();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				verticeSelecionado = -1;
				if (desenhando) {
					currentX = e.getX();
					currentY = e.getY();
					desenhando = false;
					view.setFormaTemporaria(null);

					FIGURE nova = criarFormaTemp();
					if (nova != null) {
						tela.listaFiguras.add(NovaFigura);

						tela.IndiceFoco = telaFiguras.size

						                  tela.painelDesenho.repaint
						                  model.add(nova);
					}
					view.atualizarTela();
				}
			}
		};

		view.addMouseListenerToPainel(mouseHandler);
		view.addMouseMotionListenerToPainel(mouseHandler);
	}

	private void mudarCor(Color novaCor, String nomeCor) {
		if (formaSelecionada != null) {
			formaSelecionada.setCorPreenchimento(novaCor);
		} else {
			corAtual = novaCor;
			view.setCorAtualTexto(nomeCor);
		}
		view.atualizarTela();
	}

	private FIGURE criarFormaTemp() {
		String tipoStr = view.getFerramentaAtual();
		FIGURE nova = null;

		if (tipoStr.equals("Linha")) {
			if (startX == currentX && startY == currentY) return null;
			nova = new LINE(startX, startY, currentX, currentY);
		} else {
			int xMin = Math.min(startX, currentX);
			int yMin = Math.min(startY, currentY);
			int largura = Math.abs(startX - currentX);
			int altura = Math.abs(startY - currentY);

			if (largura == 0 && altura == 0) return null;

			switch (tipoStr) {
			case "Carro":
				nova = new CARRO(xMin, yMin, largura, altura);
				break;
			case "Elipse":
				nova = new ELIP(xMin, yMin, largura, altura);
				break;
			case "Triângulo":
				nova = new TRI(xMin, yMin, largura, altura);
				break;
			case "Retângulo":
			default:
				nova = new RECT(xMin, yMin, largura, altura);
				break;
			}
		}

		if (nova != null) {
			nova.setCorPreenchimento(corAtual);
		}

		return nova;
	}
}

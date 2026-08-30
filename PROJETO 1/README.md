🎨 Editor de Formas Geométricas (Java Swing)Um aplicativo de desenho interativo feito em Java utilizando as bibliotecas Swing e AWT. Este projeto permite aos usuários desenhar, mover e deletar formas geométricas básicas em um painel, utilizando comandos intuitivos de mouse e atalhos de teclado.


🚀 FuncionalidadesDesenho de Múltiplas Formas: Suporte para Retângulos, Elipses, Linhas e Triângulos.Interação Dinâmica: As formas podem ser arrastadas livremente pela tela.Feedback Visual: A forma selecionada muda de cor (para azul) enquanto está sendo movida.Atalhos de Teclado: Troca rápida de ferramentas de desenho usando teclas específicas.Limpeza Rápida: Botão para limpar todo o quadro de desenho instantaneamente.


🎮 Comandos e ControlesAbaixo estão todas as formas de interagir com o aplicativo:


🖱️ Controles do MouseAçãoResultadoClique Esquerdo + Arrastar (em espaço vazio)Desenha uma nova forma baseada na ferramenta atual.Clique Esquerdo + Arrastar (sobre uma forma)Seleciona e move a forma pela tela (ela ficará com contorno azul).Clique Direito (sobre uma forma)Apaga a forma em que você clicou.


⌨️ Atalhos de TecladoCertifique-se de ter clicado na área de desenho (painel branco) para que os atalhos de teclado funcionem.TeclaFerramenta SelecionadaR ou rSeleciona o RetânguloE ou eSeleciona a ElipseL ou lSeleciona a LinhaT ou tSeleciona o Triângulo


🛠️ Interface GráficaNa barra superior de ferramentas, você encontra:Menu Suspenso (ComboBox): Permite selecionar manualmente qual forma geométrica você deseja desenhar (caso não queira usar o teclado).Botão "Limpar Tela": Apaga todos os objetos desenhados no painel de uma só vez, retornando à tela em branco.


💻 Como Executar o ProjetoCertifique-se de ter o Java Development Kit (JDK) instalado em sua máquina.Faça o clone ou baixe os arquivos deste repositório.Abra o projeto em sua IDE favorita (IntelliJ IDEA, Eclipse, VS Code, etc.).Execute a classe principal (que contém o método main e invoca Menu.iniciar()).Tecnologias Utilizadas: Java, javax.swing.*, java.awt.*

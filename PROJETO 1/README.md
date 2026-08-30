# 🎨 Editor de Formas Geométricas (Java Swing)

Um aplicativo de desenho interativo feito em Java utilizando as bibliotecas **Swing** e **AWT**. Este projeto permite aos usuários desenhar, mover e deletar formas geométricas básicas em um painel, utilizando comandos intuitivos de mouse e atalhos de teclado.

## 🚀 Funcionalidades

* **Desenho de Múltiplas Formas:** Suporte para Retângulos, Elipses, Linhas e Triângulos.
* **Interação Dinâmica:** As formas podem ser arrastadas livremente pela tela.
* **Feedback Visual:** A forma selecionada muda de cor (para azul) enquanto está sendo movida.
* **Atalhos de Teclado:** Troca rápida de ferramentas de desenho usando teclas específicas.
* **Limpeza Rápida:** Botão para limpar todo o quadro de desenho instantaneamente.

---

## 🎮 Comandos e Controles

Abaixo estão todas as formas de interagir com o aplicativo:

### 🖱️ Controles do Mouse

| Ação | Resultado |
| :--- | :--- |
| **Clique Esquerdo + Arrastar** (em espaço vazio) | Desenha uma nova forma baseada na ferramenta atual. |
| **Clique Esquerdo + Arrastar** (sobre uma forma) | Seleciona e **move** a forma pela tela (ela ficará com contorno azul). |
| **Clique Direito** (sobre uma forma) | **Apaga** a forma em que você clicou. |

### ⌨️ Atalhos de Teclado

Certifique-se de ter clicado na área de desenho (painel branco) para que os atalhos de teclado funcionem.

| Tecla | Ferramenta Selecionada |
| :---: | :--- |
| `R` ou `r` | Seleciona o **Retângulo** |
| `E` ou `e` | Seleciona a **Elipse** |
| `L` ou `l` | Seleciona a **Linha** |
| `T` ou `t` | Seleciona o **Triângulo** |

---

## 🛠️ Interface Gráfica

Na barra superior de ferramentas, você encontra:
* **Menu Suspenso (ComboBox):** Permite selecionar manualmente qual forma geométrica você deseja desenhar (caso não queira usar o teclado).
* **Botão "Limpar Tela":** Apaga todos os objetos desenhados no painel de uma só vez, retornando à tela em branco.

---

## 💻 Como Executar o Projeto

1. Certifique-se de ter o **Java Development Kit (JDK)** instalado em sua máquina.
2. Faça o clone ou baixe os arquivos deste repositório.
3. Abra o projeto em sua IDE favorita (IntelliJ IDEA, Eclipse, VS Code, etc.).
4. Execute a classe principal (que contém o método `main` e invoca `Menu.iniciar()`).

---
**Tecnologias Utilizadas:** Java, `javax.swing.*`, `java.awt.*`

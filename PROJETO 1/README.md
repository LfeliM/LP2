# 🎨 Interface Grafica

Como proposto no video da playlist do curso de LP2 e na atividade do classroom, projeto foi desenvolvido com o objetivo de cumprir o os seguintes objetivos.

- Pelo menos 4 figuras diferentes
    1. Criação e remoção
    2. Propriedades ajustáveis
    3. Posição, tamanho e z-order
    4. Cor de contorno e cor de fundo

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


**Tecnologias Utilizadas:** Java, `javax.swing.*`, `java.awt.*`

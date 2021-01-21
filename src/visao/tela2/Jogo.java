package visao.tela2;

import java.awt.GridLayout;

import javax.swing.JPanel;

import estrutura.Tabuleiro;

public class Jogo extends JPanel {
	//cria os botoes do jogo
	public Jogo(Tabuleiro tabuleiro) {
		setLayout(new GridLayout(10, 10));
		// Um botao para cada campo
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				add(new Botao(tabuleiro.matriz[i][j]));
			}
		}
	}
}

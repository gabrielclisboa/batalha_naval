package visao.tela2; //Cria um tabuleiro , cria os botoes

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import estrutura.Tabuleiro;

public class SegundaTela extends JFrame {
	public SegundaTela(int misseis) {
		Tabuleiro tabuleiro = new Tabuleiro(misseis, this);

		// Inicio da customização das bordas sinalizadoras
		JButton imgEixoX = new JButton();
		imgEixoX.setIcon(new ImageIcon(getClass().getResource("/visao/recursos/Linha.jpg")));

		imgEixoX.setOpaque(false);
		imgEixoX.setContentAreaFilled(false);
		imgEixoX.setBorderPainted(false);

		JButton imgEixoY = new JButton();
		imgEixoY.setIcon(new ImageIcon(getClass().getResource("/visao/recursos/coluna.jpg")));

		imgEixoY.setOpaque(false);
		imgEixoY.setContentAreaFilled(false);
		imgEixoY.setBorderPainted(false);

		imgEixoY.setMinimumSize(new Dimension(48, 480));
		imgEixoY.setPreferredSize(new Dimension(48, 480));
		imgEixoY.setMaximumSize(new Dimension(48, 480));

		add(imgEixoX, BorderLayout.NORTH);
		add(imgEixoY, BorderLayout.WEST);
		// Fim das bordas sinalizadoras

		// Parte em que o usuario interage
		Jogo cena = new Jogo(tabuleiro);
		cena.setPreferredSize(new Dimension(100, 100));
		add(cena, BorderLayout.CENTER);

		// Mostra as infomacoes dos disparos e do jogo
		InformacoesSegundaTela cena2 = new InformacoesSegundaTela(tabuleiro);
		cena2.setPreferredSize(new Dimension(50, 50));
		add(cena2, BorderLayout.SOUTH);

		setTitle("Batalha Naval");
		setSize(550, 630);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
}

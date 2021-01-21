package visao.tela3;

import javax.swing.*;

import java.awt.*;

public class TerceiraTela extends JFrame {
	JLabel imgLabel = new JLabel();

	public TerceiraTela(boolean resultadoDaPartida) {
		
		setTitle("Fim de Jogo");
		InformacoesTerceiraTela informacoes = new InformacoesTerceiraTela(this);

		// Adicionando a imagem de fundo
		if (resultadoDaPartida) {
			// Em caso de vit�ria
			imgLabel.setIcon(new ImageIcon(getClass().getResource("/visao/recursos/background_vitoria.png")));
		} else {
			// Em caso de derrota
			imgLabel.setIcon(new ImageIcon(getClass().getResource("/visao/recursos/background_derrota.png")));
		}
		add(imgLabel, BorderLayout.NORTH);

		add(informacoes, BorderLayout.SOUTH);
		
		pack();
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}

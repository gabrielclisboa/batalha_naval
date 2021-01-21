package visao.tela1;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PrimeiraTela extends JFrame {
	JLabel imgLabel = new JLabel();

	public PrimeiraTela() {

		// JLabel com as opcoes
		InformacoesPrimeiraTela informacoes = new InformacoesPrimeiraTela(this);

		// Adicionando a imagem de fundo
		imgLabel.setIcon(new ImageIcon(getClass().getResource("/visao/recursos/background.png")));
		add(imgLabel, BorderLayout.NORTH);

		// Parte de baixo do layout
		add(informacoes, BorderLayout.CENTER);

		setTitle("Batalha Naval");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		pack();
	}

	public static void main(String[] args) {
		new PrimeiraTela();
	}

}

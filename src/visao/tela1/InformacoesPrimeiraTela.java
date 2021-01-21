package visao.tela1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import visao.tela2.SegundaTela;

public class InformacoesPrimeiraTela extends JPanel implements MouseListener {

	JLabel dificuldadeDoJogo = new JLabel();
	PrimeiraTela tela;

	// https://www.javaprogressivo.net/2014/04/Tutorial-JCheckBox-Java-Como-Usar-Botoes-Checagem-CheckBox.html
	ButtonGroup botoes = new ButtonGroup();
	JRadioButton facil;
	JRadioButton medio;
	JRadioButton dificil;

	JButton botaoIniciar = new JButton(new ImageIcon(getClass().getResource("/visao/recursos/start.png")));

	public InformacoesPrimeiraTela(PrimeiraTela tela) {
		this.tela = tela;

		setLayout(new BorderLayout(10, 10));

		JLabel imgMissel = new JLabel();
		imgMissel.setIcon(new ImageIcon(getClass().getResource("/visao/recursos/m.png"))); // Imagem do bot�o do
																							// missel
		JPanel titulo = new JPanel();
		titulo.setLayout(new BorderLayout());
		titulo.add(dificuldadeDoJogo, BorderLayout.NORTH);

		JPanel opcoes = new JPanel(new GridLayout(3, 1));
		facil = new JRadioButton("Facil", false);
		medio = new JRadioButton("Medio", false);
		dificil = new JRadioButton("Dificil", false);
		botoes.add(facil);
		botoes.add(medio);
		botoes.add(dificil);

		//Fonte das letras
		facil.setFont(new Font("Impact", Font.PLAIN, 15));
		medio.setFont(new Font("Impact", Font.PLAIN, 15));
		dificil.setFont(new Font("Impact", Font.PLAIN, 15));

		//Cor das letras
		facil.setForeground(new Color(0, 255, 0));
		medio.setForeground(new Color(255, 215, 0));
		dificil.setForeground(new Color(255, 0, 0));

		opcoes.add(facil);
		opcoes.add(medio);
		opcoes.add(dificil);

		dificuldadeDoJogo.setText("Dificuldade do jogo:	");
		dificuldadeDoJogo.setFont(new Font("Impact", Font.PLAIN, 20));
		dificuldadeDoJogo.setForeground(new Color(51, 153, 255));
		dificuldadeDoJogo.setHorizontalAlignment(SwingConstants.CENTER);

		botaoIniciar.addMouseListener(this);
		botaoIniciar.setContentAreaFilled(false);

		add(titulo, BorderLayout.NORTH);
		add(opcoes, BorderLayout.CENTER);
		add(botaoIniciar, BorderLayout.WEST);
		add(imgMissel, BorderLayout.AFTER_LINE_ENDS);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (facil.isSelected()) {
			new SegundaTela(80);
			tela.dispose();
		} else if (medio.isSelected()) {
			new SegundaTela(50);
			tela.dispose();
		} else if (dificil.isSelected()) {
			new SegundaTela(25);
			tela.dispose();
		}
	}
	
	public void mouseClicked(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

}

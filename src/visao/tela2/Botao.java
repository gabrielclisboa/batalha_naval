package visao.tela2; //captura os eventos de click 

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import estrutura.Campo;

public class Botao extends JButton implements MouseListener {
	private Campo campo;

	public Botao(Campo campo) { // Cada botao recebe um objeto campo

		this.campo = campo;
		addMouseListener(this); // Captura evento clique

		setIcon(new ImageIcon(getClass().getResource("/visao/recursos/mar.png")));
		setBackground(new Color(47, 86, 215));

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == 1) {
			boolean resultado = campo.abrirCampo(); // Abre o campo clicado
			if (resultado) { // Se acertou um barco
				setIcon(new ImageIcon(getClass().getResource("/visao/recursos/boom.gif")));
			} else { // Se acertou o mar
				setIcon(new ImageIcon(getClass().getResource("/visao/recursos/erro.png")));
			}

			removeMouseListener(this); // Tira o evento de clique deste botao

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

package visao.tela2;//Texto la de baixo

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import estrutura.ObservadorTabuleiroAcao;
import estrutura.Tabuleiro;

public class InformacoesSegundaTela extends JPanel implements ObservadorTabuleiroAcao {
	JLabel resultadoDoTiro = new JLabel("Resultado: ");
	JLabel bombasDisponiveis = new JLabel("Numero de bombas: ");

	// Tem a qtd de bombas e o status do tiro.
	public InformacoesSegundaTela(Tabuleiro tabuleiro) {
		// setLayout(new GridLayout(1,0));

		tabuleiro.adicionarObservadorAcao(this); //Essa classe observa o tabuleiro para receber suas ações

		resultadoDoTiro.setFont(new Font("Tahoma", Font.BOLD, 20));

		bombasDisponiveis.setFont(new Font("Tahoma", Font.BOLD, 20));
		bombasDisponiveis.setForeground(new Color(255, 102, 144));

		resultadoDoTiro.setText("CLIQUE!");
		resultadoDoTiro.setForeground(Color.MAGENTA);
		bombasDisponiveis.setText("Numero de bombas: " + tabuleiro.getMisseis() + "   ");

		add(bombasDisponiveis);
		add(resultadoDoTiro);

	}
	
	//Observador tabuleiroAcao
	@Override
	public void notificarMisseis(Tabuleiro tabuleiro, boolean statusTiro, boolean destruido) {
		// A cada tiro, a informacao é atualizada
		if (destruido) {
			resultadoDoTiro.setText("NAVIO DESTRUIDO!");
			resultadoDoTiro.setForeground(Color.YELLOW);
		} else if (statusTiro) {
			resultadoDoTiro.setText("ACERTOU O TIRO!");
			resultadoDoTiro.setForeground(Color.green);
		} else {
			resultadoDoTiro.setText("ERROU O TIRO!");
			resultadoDoTiro.setForeground(Color.red);
		}

		bombasDisponiveis.setText("Numero de bombas: " + tabuleiro.getMisseis() + "   ");

	}

}

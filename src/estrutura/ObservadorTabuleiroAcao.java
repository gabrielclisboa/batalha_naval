package estrutura;

public interface ObservadorTabuleiroAcao { // Repassa o resultado dos disparos para a interface gráfica
	void notificarMisseis(Tabuleiro tabuleiro, boolean statusTiro, boolean destruido);
}

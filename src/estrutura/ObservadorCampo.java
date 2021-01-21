package estrutura;

public interface ObservadorCampo { // Interface funcional para os observadores da classe campo
	void notificarTabuleiro(Campo campo, boolean resultadoDoTiro);
}

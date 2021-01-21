package estrutura;

import java.util.ArrayList;
import java.util.List;

import visao.tela2.SegundaTela;
import visao.tela3.TerceiraTela;

public class Tabuleiro implements ObservadorCampo {
    private int misseis; // Quantidade de bombas a disposição
    public Campo[][] matriz = new Campo[10][10]; // Matriz 10x10 de campos
    SegundaTela jogoRodando; //instância da tela do jogo que virá de parâmetro na criação do tabuleiro

    public Tabuleiro(int misseis, SegundaTela segundaTela) {
        this.misseis = misseis; // A Quantidade de bombas é passada via parâmetro quando o tabuleiro é construido

        preencherCampos();
        preencheMatrizComBarcos(5);
        preencheMatrizComBarcos(4);
        preencheMatrizComBarcos(3);
        preencheMatrizComBarcos(2);

        this.jogoRodando = segundaTela;
    }

    // Observadores
    // Responsavel por repassar os resultados do disparo e a quantidade de misseis para o JPanel
    private final List<ObservadorTabuleiroAcao> observadoresAcao = new ArrayList<>();

    private void notificarObservadoresAcao(boolean statusTiro, boolean destruido) {
        for (ObservadorTabuleiroAcao observador : observadoresAcao) {
            observador.notificarMisseis(this, statusTiro, destruido);
        }
    }

    public void adicionarObservadorAcao(ObservadorTabuleiroAcao obs) {
        observadoresAcao.add(obs);
    }

    // Fim Observadores

    // Preenche os campos da matriz e adiciona o tabuleiro como seus observadores
    private void preencherCampos() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Campo campo = new Campo();
                campo.adicionarObservador(this);
                matriz[i][j] = campo;
            }
        }
    }

    // Função para preencher os espacos com os barcos.
    public void preencheMatrizComBarcos(int numeroDeCasasDoBarco) {
        int linha;
        int coluna;

        do {
            linha = (int) Math.round(Math.random() * 9);
            coluna = (int) Math.round(Math.random() * 9);
        } while (matriz[linha][coluna].getContemNavio() != 0);

        int contadorDireita = 0, contadorEsquerda = 0, contadorCima = 0, contadorBaixo = 0;
        boolean direitaLivre = false, esquerdaLivre = false, paraCimaLivre = false, paraBaixoLivre = false;

        for (int i = coluna; i <= (coluna + numeroDeCasasDoBarco - 1) && i >= 0 && i < 10; i++) {
            // fala se ele pode ser colocado no tabuleiro
            if (matriz[linha][i].getContemNavio() == 0) {
                // Aqui jÃ¡ fazemos a verificaÃ§Ã£o se hÃ¡ outros barcos nas redondezas
                if (linha > 0 && i > 0 && linha < 9 && i < 9) {
                    if (matriz[linha + 1][i].getContemNavio() == 0 && matriz[linha][i + 1].getContemNavio() == 0
                            && matriz[linha - 1][i].getContemNavio() == 0
                            && matriz[linha][i - 1].getContemNavio() == 0) {
                        if (matriz[linha - 1][i - 1].getContemNavio() == 0
                                && matriz[linha - 1][i + 1].getContemNavio() == 0
                                && matriz[linha + 1][i - 1].getContemNavio() == 0
                                && matriz[linha + 1][i + 1].getContemNavio() == 0) {
                            direitaLivre = true;
                            contadorDireita++;
                        }
                    }
                } else if (linha == 0) {
                    if (i == 0) {
                        if (matriz[linha + 1][i].getContemNavio() == 0 && matriz[linha][i + 1].getContemNavio() == 0) {
                            direitaLivre = true;
                            contadorDireita++;
                        }
                    } else if (i == 9) {
                        if (matriz[linha + 1][i].getContemNavio() == 0 && matriz[linha][i - 1].getContemNavio() == 0) {
                            direitaLivre = true;
                            contadorDireita++;
                        }
                    }
                } else if (linha == 9) {
                    if (i == 0) {
                        if (matriz[linha - 1][i].getContemNavio() == 0 && matriz[linha][i + 1].getContemNavio() == 0) {
                            direitaLivre = true;
                            contadorDireita++;
                        }
                    } else if (i == 9) {
                        if (matriz[linha - 1][i].getContemNavio() == 0 && matriz[linha][i - 1].getContemNavio() == 0) {
                            direitaLivre = true;
                            contadorDireita++;
                        }
                    }
                }
            } /* NÃ£o tem nada para mudar aqui */ else if (matriz[linha][i].getContemNavio() != 0) {
                contadorDireita++;
                direitaLivre = false;
                break;
            }
        }
        if (contadorDireita != numeroDeCasasDoBarco) {
            direitaLivre = false;
        }

        for (int i = coluna; i >= (coluna - numeroDeCasasDoBarco + 1) && i >= 0 && i < 10; i--) {
            if (matriz[linha][i].getContemNavio() == 0) {
                // Aqui jÃ¡ fazemos a verificaÃ§Ã£o se hÃ¡ outros barcos nas redondezas
                if (linha > 0 && i > 0 && linha < 9 && i < 9) {
                    if (matriz[linha + 1][i].getContemNavio() == 0 && matriz[linha][i + 1].getContemNavio() == 0
                            && matriz[linha - 1][i].getContemNavio() == 0
                            && matriz[linha][i - 1].getContemNavio() == 0) {
                        if (matriz[linha - 1][i - 1].getContemNavio() == 0
                                && matriz[linha - 1][i + 1].getContemNavio() == 0
                                && matriz[linha + 1][i - 1].getContemNavio() == 0
                                && matriz[linha + 1][i + 1].getContemNavio() == 0) {
                            esquerdaLivre = true;
                            contadorEsquerda++;
                        }
                    }
                } else if (linha == 0) {
                    if (i == 0) {
                        if (matriz[linha + 1][i].getContemNavio() == 0 && matriz[linha][i + 1].getContemNavio() == 0) {
                            esquerdaLivre = true;
                            contadorEsquerda++;
                        }
                    } else if (i == 9) {
                        if (matriz[linha + 1][i].getContemNavio() == 0 && matriz[linha][i - 1].getContemNavio() == 0) {
                            esquerdaLivre = true;
                            contadorEsquerda++;
                        }
                    }
                } else if (linha == 9) {
                    if (i == 0) {
                        if (matriz[linha - 1][i].getContemNavio() == 0 && matriz[linha][i + 1].getContemNavio() == 0) {
                            esquerdaLivre = true;
                            contadorEsquerda++;
                        }
                    } else if (i == 9) {
                        if (matriz[linha - 1][i].getContemNavio() == 0 && matriz[linha][i - 1].getContemNavio() == 0) {
                            esquerdaLivre = true;
                            contadorEsquerda++;
                        }
                    }
                }
            } /* Aqui nÃ£o tem nada para mudar */ else {
                contadorEsquerda++;
                esquerdaLivre = false;
                break;
            }
        }
        if (contadorEsquerda != numeroDeCasasDoBarco) {
            esquerdaLivre = false;
        }

        for (int i = linha; i <= (linha + numeroDeCasasDoBarco - 1) && i >= 0 && i < 10; i++) {
            if (matriz[i][coluna].getContemNavio() == 0) { /* LINHA VIRA I E I VIRA COLUNA, MUDAR COLUNA PRIMEIRO */
                // Aqui jÃ¡ fazemos a verificaÃ§Ã£o se hÃ¡ outros barcos nas redondezas
                if (i > 0 && coluna > 0 && i < 9 && coluna < 9) {
                    if (matriz[i + 1][coluna].getContemNavio() == 0 && matriz[i][coluna + 1].getContemNavio() == 0
                            && matriz[i - 1][coluna].getContemNavio() == 0
                            && matriz[i][coluna - 1].getContemNavio() == 0) {
                        if (matriz[i - 1][coluna - 1].getContemNavio() == 0
                                && matriz[i - 1][coluna + 1].getContemNavio() == 0
                                && matriz[i + 1][coluna - 1].getContemNavio() == 0
                                && matriz[i + 1][coluna + 1].getContemNavio() == 0) {
                            contadorBaixo++;
                            paraBaixoLivre = true;
                        }
                    }
                } else if (i == 0) {
                    if (coluna == 0) {
                        if (matriz[i + 1][coluna].getContemNavio() == 0
                                && matriz[i][coluna + 1].getContemNavio() == 0) {
                            contadorBaixo++;
                            paraBaixoLivre = true;
                        }
                    } else if (coluna == 9) {
                        if (matriz[i + 1][coluna].getContemNavio() == 0
                                && matriz[i][coluna - 1].getContemNavio() == 0) {
                            contadorBaixo++;
                            paraBaixoLivre = true;
                        }
                    }
                } else if (i == 9) {
                    if (coluna == 0) {
                        if (matriz[i - 1][coluna].getContemNavio() == 0
                                && matriz[i][coluna + 1].getContemNavio() == 0) {
                            contadorBaixo++;
                            paraBaixoLivre = true;
                        }
                    } else {
                        if (matriz[i - 1][coluna].getContemNavio() == 0
                                && matriz[i][coluna - 1].getContemNavio() == 0) {
                            contadorBaixo++;
                            paraBaixoLivre = true;
                        }
                    }
                }

            } /* Nada para mudar aqui para baixo */ else {
                contadorBaixo++;
                paraBaixoLivre = false;
                break;
            }
        }
        if (contadorBaixo != numeroDeCasasDoBarco) {
            paraBaixoLivre = false;
        }

        for (int i = linha; i >= (linha - numeroDeCasasDoBarco + 1) && i >= 0 && i < 10; i--) {
            if (matriz[i][coluna].getContemNavio() == 0) {
                if (i > 0 && coluna > 0 && i < 9 && coluna < 9) {
                    if (matriz[i + 1][coluna].getContemNavio() == 0 && matriz[i][coluna + 1].getContemNavio() == 0
                            && matriz[i - 1][coluna].getContemNavio() == 0
                            && matriz[i][coluna - 1].getContemNavio() == 0) {
                        if (matriz[i - 1][coluna - 1].getContemNavio() == 0
                                && matriz[i - 1][coluna + 1].getContemNavio() == 0
                                && matriz[i + 1][coluna - 1].getContemNavio() == 0
                                && matriz[i + 1][coluna + 1].getContemNavio() == 0) {
                            contadorCima++;
                            paraCimaLivre = true;
                        }
                    }
                } else if (i == 0) {
                    if (coluna == 0) {
                        if (matriz[i + 1][coluna].getContemNavio() == 0
                                && matriz[i][coluna + 1].getContemNavio() == 0) {
                            contadorCima++;
                            paraCimaLivre = true;
                        }
                    } else if (coluna == 9) {
                        if (matriz[i + 1][coluna].getContemNavio() == 0
                                && matriz[i][coluna - 1].getContemNavio() == 0) {
                            contadorCima++;
                            paraCimaLivre = true;
                        }
                    }
                } else if (i == 9) {
                    if (coluna == 0) {
                        if (matriz[i - 1][coluna].getContemNavio() == 0
                                && matriz[i][coluna + 1].getContemNavio() == 0) {
                            contadorCima++;
                            paraCimaLivre = true;
                        }
                    } else {
                        if (matriz[i - 1][coluna].getContemNavio() == 0
                                && matriz[i][coluna - 1].getContemNavio() == 0) {
                            contadorCima++;
                            paraCimaLivre = true;
                        }
                    }
                }
            } else {
                contadorCima++;
                paraCimaLivre = false;
                break;
            }
        }
        if (contadorCima != numeroDeCasasDoBarco) {
            paraCimaLivre = false;
        }

        if (direitaLivre) {
            for (int i = coluna; i <= (coluna + numeroDeCasasDoBarco - 1) && i >= 0 && i < 10; i++) {
                matriz[linha][i].setContemNavio(numeroDeCasasDoBarco);
            }
        } else if (esquerdaLivre) {
            for (int i = coluna; i >= (coluna - numeroDeCasasDoBarco + 1); i--) {
                if (i < 10 && i >= 0 && coluna < 10) {
                    matriz[linha][i].setContemNavio(numeroDeCasasDoBarco);
                }
            }
        } else if (paraCimaLivre) {
            for (int i = linha; i >= (linha - numeroDeCasasDoBarco + 1) && i >= 0 && i < 10; i--) {
                matriz[i][coluna].setContemNavio(numeroDeCasasDoBarco);
            }
        } else if (paraBaixoLivre) {
            for (int i = linha; i <= (linha + numeroDeCasasDoBarco - 1) && i >= 0 && i < 10; i++) {
                if (coluna < 10) {
                    matriz[i][coluna].setContemNavio(numeroDeCasasDoBarco);
                }
            }
        } else {
            this.preencheMatrizComBarcos(numeroDeCasasDoBarco);
        }
    }

    // Verifica se algum navio foi destruido
    public boolean verificaSeFoiDestruido(int numeroDeCasasDoBarco, Campo campo) {
        campo.setContemNavio(0);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (matriz[i][j].getContemNavio() == numeroDeCasasDoBarco) {
                    return false;
                }
            }
        }
        return true;
    }

    // Verifica se o usuario acabou o jogo
    public boolean verificaSeGanhou() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (matriz[i][j].getContemNavio() != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    //Função implementada da classe Campo
    @Override
    public void notificarTabuleiro(Campo campo, boolean resultadoDoTiro) {
        // campo foi aberto!
        misseis--; // Menos um disparo
        boolean destruido = verificaSeFoiDestruido(campo.getContemNavio(), campo); // Verifica se o navio foi
        // completamente destruido
        notificarObservadoresAcao(resultadoDoTiro, destruido); // Notifica o JPanel informacoesTela1 se o disparo foi
        // efetivo ou não.

        // Verifica se o usuario ganhou ou perdeu e inicia a ultima tela do jogo
        if (verificaSeGanhou()) {
            jogoRodando.dispose(); //a tela principal do jogo é fechada
            new TerceiraTela(true); //a tela final aparece
        } else if (misseis == 0) {
            jogoRodando.dispose();
            new TerceiraTela(false);
        }
    }

    public int getMisseis() {
        return misseis;
    }
}
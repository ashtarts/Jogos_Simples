import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Jogo extends JPanel {
    private char[][] tabuleiro;
    private char jogadorAtual;
    private JButton[][] botoes;
    private boolean contraAmigo;

    public Jogo() {
        tabuleiro = new char[3][3];
        jogadorAtual = 'X';
        inicializarTabuleiro();
        criarInterface();
        escolherModoJogo();
    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = '-';
            }
        }
    }

    private void criarInterface() {
        setLayout(new GridLayout(3, 3));
        botoes = new JButton[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton botao = new JButton();
                botao.setFont(new Font("Arial", Font.PLAIN, 48));
                botao.addActionListener(new BotaoListener(i, j));
                botoes[i][j] = botao;
                add(botao);
            }
        }
    }

    private void atualizarInterface() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                botoes[i][j].setText(Character.toString(tabuleiro[i][j]));
            }
        }
    }

    private void realizarJogada(int linha, int coluna) {
        if (tabuleiro[linha][coluna] == '-' && !jogoAcabou()) {
            tabuleiro[linha][coluna] = jogadorAtual;
            atualizarInterface();
            if (verificarVitoria()) {
                JOptionPane.showMessageDialog(null, "Jogador " + jogadorAtual + " venceu!");
                reiniciarJogo();
            } else if (verificarEmpate()) {
                JOptionPane.showMessageDialog(null, "O jogo empatou!");
                reiniciarJogo();
            } else {
                jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
                if (!contraAmigo) {
                    realizarJogadaComputador();
                }
            }
        }
    }

    private boolean verificarVitoria() {
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] == jogadorAtual && tabuleiro[1][j] == jogadorAtual && tabuleiro[2][j] == jogadorAtual) {
                return true;
            }
        }

        if (tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) {
            return true;
        }

        if (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual) {
            return true;
        }

        return false;
    }

    private boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean jogoAcabou() {
        return verificarVitoria() || verificarEmpate();
    }

    private void reiniciarJogo() {
        inicializarTabuleiro();
        jogadorAtual = 'X';
        atualizarInterface();
        escolherModoJogo();
    }

    private void escolherModoJogo() {
        Object[] options = {"Contra Amigo", "Contra Computador"};
        int escolha = JOptionPane.showOptionDialog(null,
                "Escolha o modo de jogo:",
                "Modo de Jogo",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        contraAmigo = (escolha == 0);
    }

    private void realizarJogadaComputador() {
        if (jogadorAtual == 'O') {
            boolean jogadaValida = false;

            while (!jogadaValida) {
                int linha = (int) (Math.random() * 3);
                int coluna = (int) (Math.random() * 3);

                if (tabuleiro[linha][coluna] == '-') {
                    tabuleiro[linha][coluna] = jogadorAtual;
                    jogadaValida = true;
                }
            }

            atualizarInterface();

            if (verificarVitoria()) {
                JOptionPane.showMessageDialog(null, "Jogador " + jogadorAtual + " venceu!");
                reiniciarJogo();
            } else if (verificarEmpate()) {
                JOptionPane.showMessageDialog(null, "O jogo empatou!");
                reiniciarJogo();
            } else {
                jogadorAtual = 'X';
            }
        }
    }

    private class BotaoListener implements ActionListener {
        private int linha;
        private int coluna;

        public BotaoListener(int linha, int coluna) {
            this.linha = linha;
            this.coluna = coluna;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            realizarJogada(linha, coluna);
        }
    }
    }

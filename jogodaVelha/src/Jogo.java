import javax.swing.JOptionPane;

public class Jogo {
    private char[][] tabuleiro;
    private char jogadorAtual;

    public Jogo() {
        tabuleiro = new char[3][3];
        jogadorAtual = 'X';
        inicializarTabuleiro();
    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = '-';
            }
        }
    }

    public void jogar() {
        boolean jogoAcabou = false;

        while (!jogoAcabou) {
            exibirTabuleiro();
            String entrada = JOptionPane.showInputDialog("Jogador " + jogadorAtual + ", digite a linha e coluna que deseja jogar (ex: 1 2):");

            String[] posicoes = entrada.split(" ");
            int linha = Integer.parseInt(posicoes[0]);
            int coluna = Integer.parseInt(posicoes[1]);

            if (linha < 1 || linha > 3 || coluna < 1 || coluna > 3) {
                JOptionPane.showMessageDialog(null, "Posição inválida. Tente novamente.");
                continue;
            }

            if (tabuleiro[linha - 1][coluna - 1] != '-') {
                JOptionPane.showMessageDialog(null, "Posição ocupada. Tente novamente.");
                continue;
            }

            tabuleiro[linha - 1][coluna - 1] = jogadorAtual;

            if (verificarVitoria()) {
                exibirTabuleiro();
                JOptionPane.showMessageDialog(null, "Jogador " + jogadorAtual + " venceu!");
                jogoAcabou = true;
            } else if (verificarEmpate()) {
                exibirTabuleiro();
                JOptionPane.showMessageDialog(null, "O jogo empatou!");
                jogoAcabou = true;
            } else {
                jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
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

    private void exibirTabuleiro() {
        StringBuilder builder = new StringBuilder();
        builder.append("-----\n");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                builder.append(tabuleiro[i][j]).append(" ");
            }
            builder.append("\n");
        }
        builder.append("-----");
        JOptionPane.showMessageDialog(null, builder.toString());
    }
}
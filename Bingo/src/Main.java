import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        bingo jogo = new bingo();

        while (true) {
            int opcao = JOptionPane.showOptionDialog(null,
                    "Escolha uma opção:",
                    "Jogo de Bingo",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    new String[]{"Sortear número", "Mostrar números sorteados", "Mostrar cartela", "Sair"},
                    0);

            if (opcao == 0) {
                int numeroSorteado = jogo.sorteio();
                if (numeroSorteado != -1) {
                    JOptionPane.showMessageDialog(null, "Número sorteado: " + numeroSorteado);
                }
            } else if (opcao == 1) {
                jogo.print();
            } else if (opcao == 2) {
                jogo.mostrar();
            } else if (opcao == 3) {
                break;
            }
        }
    }
}
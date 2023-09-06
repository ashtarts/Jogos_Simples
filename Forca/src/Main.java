import javax.swing.JOptionPane;



public class Main {

    public static void main(String[] args) {
        Forca jogo = new Forca();

        JOptionPane.showMessageDialog(null, "a palavra é uma fruta!");

        while (!jogo.jogoAcabou()) {
            String letraDigitada = JOptionPane.showInputDialog("Palavra: " + jogo.getPalavraOculta() +
                    "\nTentativas restantes: " + jogo.getTentativasRestantes() +
                    "\nDigite uma letra:").toUpperCase();

            if (letraDigitada.length() == 1) {
                jogo.tentarLetra(letraDigitada.charAt(0));
            }
        }

        if (jogo.getPalavraOculta().equals(jogo.palavra)) {
            JOptionPane.showMessageDialog(null, "Parabéns! Você ganhou. A palavra era: " + jogo.palavra);
        } else {
            JOptionPane.showMessageDialog(null, "Você perdeu. A palavra era: " + jogo.palavra);
        }
    }
}






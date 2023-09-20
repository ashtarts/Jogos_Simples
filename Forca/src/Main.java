import javax.swing.JOptionPane;



public class Main {

    public static void main(String[] args) {
        String[] temas = {"Frutas", "Lugares", "Nomes de Pessoas", "Cores", "Adjetivos", "Marcas", "Objetos", "Jogos", "Famosos"};
        String temaEscolhido = (String) JOptionPane.showInputDialog(null, "Escolha um tema:",
                "Escolha de Tema", JOptionPane.PLAIN_MESSAGE, null, temas, temas[0]);

        Forca jogo = new Forca(temaEscolhido);
        JOptionPane.showMessageDialog(null, "A palavra é relacionada ao tema: " + temaEscolhido);

        while (!jogo.terminou()) {
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






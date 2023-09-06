import javax.swing.JOptionPane;
import java.util.Random;

public class Forca {
    public String palavra;
    private String palavraOculta;
    private int tentativasRestantes;
    private char[] letrasTentadas;

    // Lista de palavras possíveis
    private static String[] palavras = {
            "MORANGO", "BANANA", "ABACAXI", "MANGA", "ABACATE", "AÇAI",
            "AMORA", "CAJA", "CACAU", "GOIABA", "KIWI", "LARANJA",
            "INGA", "JABUTICABA", "JENIPAPO", "MARACUJA", "PITANGA", "SIRIGUELA",
            "TAMARINDO", "TANGERINA", "CIDRA", "CUPUAÇU", "CAQUI", "FRAMBOESA"
    };

    public Forca() {
        palavra = escolherPalavraAleatoria().toUpperCase();
        palavraOculta = "";
        tentativasRestantes = 6;
        letrasTentadas = new char[26];
        inicializarPalavraOculta();
    }

    private String escolherPalavraAleatoria() {
        Random rand = new Random();
        int index = rand.nextInt(palavras.length);
        return palavras[index];
    }

    private void inicializarPalavraOculta() {
        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == ' ') {
                palavraOculta += " ";
            } else {
                palavraOculta += "_";
            }
        }
    }

    public boolean tentarLetra(char letra) {
        letra = Character.toUpperCase(letra);

        if (letra < 'A' || letra > 'Z' || letraJaTentada(letra)) {
            JOptionPane.showMessageDialog(null, "Letra inválida ou já tentada.");
            return false;
        }

        boolean letraEncontrada = false;

        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == letra) {
                palavraOculta = palavraOculta.substring(0, i) + letra + palavraOculta.substring(i + 1);
                letraEncontrada = true;
            }
        }

        letrasTentadas[letra - 'A'] = letra;

        if (!letraEncontrada) {
            tentativasRestantes--;
        }

        return true;
    }

    public boolean letraJaTentada(char letra) {
        return letrasTentadas[letra - 'A'] != 0;
    }

    public boolean jogoAcabou() {
        return tentativasRestantes == 0 || palavraOculta.equals(palavra);
    }

    public String getPalavraOculta() {
        return palavraOculta;
    }

    public int getTentativasRestantes() {
        return tentativasRestantes;
    }}
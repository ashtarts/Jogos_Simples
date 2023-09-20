import javax.swing.JOptionPane;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Forca {
    public String palavra;
    private String palavraOculta;
    private int tentativasRestantes;
    private char[] letrasTentadas;
    private String[] bonecoPalito;

    private static List<String> palavrasFrutas = Arrays.asList(
            "MORANGO", "BANANA", "ABACAXI", "MANGA", "ABACATE", "AÇAI",
            "AMORA", "CAJA", "CACAU", "GOIABA", "KIWI", "LARANJA",
            "INGA", "JABUTICABA", "JENIPAPO", "MARACUJA", "PITANGA", "SIRIGUELA",
            "TAMARINDO", "TANGERINA", "CIDRA", "CUPUAÇU", "CAQUI", "FRAMBOESA"

    );

    private static List<String> palavrasLugares = Arrays.asList(
            "PARIS", "NOVA YORK", "TOKYO", "LONDRES", "RIO DE JANEIRO",
            "VENEZA", "BERLIM", "AMSTERDAM", "CANCUN", "BORA BORA",
            "MACHU PICHU", "CAMBOJA", "TAJ MAHAL", "MARROCOS", "SRI LANKA",
            "ANTARTICA", "GRAND CANYON", "FERNANDO DE NORONHA"
    );

    private static List<String> palavrasNomesPessoas = Arrays.asList(
            "JOÃO", "MARIA", "PEDRO", "ANA", "CARLOS",
            "SOFIA", "LUIS", "ALICE", "MIGUEL", "LARA",
            "MIGUEL", "HELENA", "GABRIEL" , "EDGAR", "PAULA",
            "HEITOR", "ARTHUR", "SOPHIA", "JULIA", "CECILIA"

    );

    private static List<String> palavrasCores = Arrays.asList(
            "VERMELHO", "AZUL", "VERDE", "AMARELO", "ROSA",
            "ROXO", "LARANJA", "PRETO", "BRANCO", "CINZA",
            "SALMAO", "MARROM", "CASTANHO", "LILAS", "VINHO",
            "MOSTARDA", "CREME", "BORDO", "TURQUESA"
    );

    private static List<String> palavrasAdjetivos = Arrays.asList(
            "ALEGRE", "INTELIGENTE", "DIVERTIDO", "AMIGÁVEL", "CORAJOSO",
            "HONESTO", "ATIVO", "PACIENTE", "CALMO", "SIMPÁTICO", "PEQUENO",
            "MARAVILHOSO", "DESCONFORTAVEL", "ASPERO", "BRILAHNTE",
            "APAIXONADO", "ANGUSTIADO", "BONDOSO", "MAGRELO", "ORGANIZADO"
    );
    private static List<String> palavrasMarcas = Arrays.asList(
            "NIKE", "APPLE", "COCA-COLA", "DISNEY", "MICROSOFT",
            "MIZUNO", "ADIDAS", "ACER", "LENOVO", "SAMSUNG", "XIAOMI",
            "PEPSI", "SONY", "KINGSTON", "CALVIN KLEIN", "AEROPOSTALE",
            "NIKON", "CANON", "AUDI", "LAMBORGHINI", "FERRARI", "BUGATTI",
            "MERCEDES BENZ", "LOUIS VITTON", "YVES SAINT LAURENT", "GUCCI"
    );

    private static List<String> palavrasObjetos = Arrays.asList(
            "CARRO", "CELULAR", "RELÓGIO", "MESA", "CADEIRA", "LAMPADA",
            "COMPUTADOR", "CAMERA", "FONE DE OUVIDO", "PLAYSTATION",
            "TECLADO", "ALMOFADA", "ANCORA", "AQUECEDRO", "VENTILADOR",
            "BUMERANGUE","CALCULADORA", "CASSETETE", "DESODORANTE",
            "DOMINO", "ESCORREDOR", "FURADEIRA","IMPRESSORA", "KETCHUP"
    );

    private static List<String> palavrasJogos = Arrays.asList(
            "MARIO", "ZELDA", "FORTNITE", "MINECRAFT", "TETRIS",
            "VALORANT", "LEAGUE OF LEGENDS", " UNCHARTED", "RED DEAD REDEMPTION",
            "GRAND THEFT AUTO", " GOD OF WAR", "FINAL FANTASY", "SPIDER MAN",
            "THE SIMS", "FARCRY", "ASSASSINS CREED", "THE ELDER SCROLLS",
            "A WAY OUT", "CALL OF DUTY", " KILLZONE", "HORIZON ZERO DAWN"
    );

    private static List<String> palavrasFamosos = Arrays.asList(
            "ELVIS PRESLEY", "BEYONCE", "EINSTEIN", "LEONARDO", "OPRAH",
            "CAMILA CABELLO", "ARIANA GRANDE", "THE BEATLES", "EMINEM",
            "KATY PERRY", "LANA DEL REY", "SHAKIRA", "RIHANNA",
            "ZEZE DI CAMARGO", "TAYLOR SWIFT", "ROBERTO CARLOS", "OLIVIA RODRIGO",
            "MC LIVINHO", "MC LOMA", "MC PIPOQUINHA", "BIBI FOGOSA"
    );

    public Forca(String temaEscolhido) {
        selecionarPalavra(temaEscolhido);
        palavraOculta = "";
        tentativasRestantes = 6;
        letrasTentadas = new char[26];
        bonecoPalito = new String[7];
        fazerPalavraOculta();
    }

    private void selecionarPalavra(String tema) {
        Random rand = new Random();
        List<String> palavrasDoTema = null;

        switch (tema) {
            case "Frutas":
                palavrasDoTema = palavrasFrutas;
                break;
            case "Lugares":
                palavrasDoTema = palavrasLugares;
                break;
            case "Nomes de Pessoas":
                palavrasDoTema = palavrasNomesPessoas;
                break;
            case "Cores":
                palavrasDoTema = palavrasCores;
                break;
            case "Adjetivos":
                palavrasDoTema = palavrasAdjetivos;
                break;
            case "Marcas":
                palavrasDoTema = palavrasMarcas;
                break;
            case "Objetos":
                palavrasDoTema = palavrasObjetos;
                break;
            case "Jogos":
                palavrasDoTema = palavrasJogos;
                break;
            case "Famosos":
                palavrasDoTema = palavrasFamosos;
                break;
            default:
                palavrasDoTema = palavrasFrutas;
        }

        if (palavrasDoTema != null && !palavrasDoTema.isEmpty()) {
            palavra = palavrasDoTema.get(rand.nextInt(palavrasDoTema.size())).toUpperCase();
        } else {
            palavra = "PADRAO";
        }
    }

    private void fazerPalavraOculta() {
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

        if (letra < 'A' || letra > 'Z' || letraTentada(letra)) {
            JOptionPane.showMessageDialog(null, "Letra inválida ou já tentada.");
            return false;
        }

        boolean encontrada = false;

        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == letra) {
                palavraOculta = palavraOculta.substring(0, i) + letra + palavraOculta.substring(i + 1);
                encontrada = true;
            }
        }

        letrasTentadas[letra - 'A'] = letra;

        if (!encontrada) {
            tentativasRestantes--;

            if (tentativasRestantes >= 0) {
                System.out.println(bonecoPalito[6 - tentativasRestantes]);
            }
        }

        return true;
    }

    public boolean letraTentada(char letra) {
        return letrasTentadas[letra - 'A'] != 0;
    }

    public boolean terminou() {
        return tentativasRestantes == 0 || palavraOculta.equals(palavra);
    }

    public String getPalavraOculta() {
        return palavraOculta;
    }

    public int getTentativasRestantes() {
        return tentativasRestantes;
    }}

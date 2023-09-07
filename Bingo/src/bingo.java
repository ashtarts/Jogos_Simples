import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;

public class bingo {
    private List<Integer> sortear;
    private List<Integer> disp;
    private List<Integer> cartela;

    public bingo() {
        sortear = new ArrayList<>();
        disp = new ArrayList<>();
        cartela = new ArrayList<>();

        for (int i = 1; i <= 75; i++) {
            disp.add(i);
        }

        Collections.shuffle(disp);

        for (int i = 0; i < 25; i++) {
            cartela.add(disp.remove(0));
        }
    }

    public int sorteio() {
        if (disp.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os números já foram sorteados!");
            return -1;
        }

        int numeroSorteado = disp.remove(0);
        sortear.add(numeroSorteado);

        // Marca o número na cartela como sorteado
        marcarCartela(numeroSorteado);

        return numeroSorteado;
    }

    public void print() {
        JOptionPane.showMessageDialog(null, "Números sorteados: " + sortear);
    }

    public void mostrar() {
        StringBuilder cartelaStr = new StringBuilder("Sua cartela:\n");

        for (int i = 0; i < cartela.size(); i++) {
            int numero = cartela.get(i);
            String marcacao = numero == -1 ? "X" : Integer.toString(numero);

            cartelaStr.append(String.format("%2s ", marcacao));

            if ((i + 1) % 5 == 0) {
                cartelaStr.append("\n");
            }
        }

        JOptionPane.showMessageDialog(null, cartelaStr.toString());
    }

    public void marcarCartela(int numeroSorteado) {
        for (int i = 0; i < cartela.size(); i++) {
            if (cartela.get(i) == numeroSorteado) {
                cartela.set(i, -1); // Marca o número como sorteado
                break;
            }
        }
    }
    }
package br.com.wii.cm.visao;

import br.com.wii.cm.excecao.ExplosaoException;
import br.com.wii.cm.excecao.SairExcepetion;
import br.com.wii.cm.modelo.Tabuleiro;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class TabuleiroConsole {
    private Tabuleiro tabuleiro;
    private Scanner entrada = new Scanner(System.in);

    public TabuleiroConsole(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;

        executarJogo();
    }

    private void executarJogo() {
        try {
            boolean continuar = true;
            while (continuar) {
                ciclodoJogo();
                System.out.println("Outra partida? (S/n)");
                String resposta = entrada.nextLine();
                if ("n".equalsIgnoreCase(resposta)) {
                    continuar = false;
                } else tabuleiro.reiniciar();
            }
        } catch (SairExcepetion e) {
            System.out.println("Tchau!!!");
        } finally {
            entrada.close();
        }
    }

    private void ciclodoJogo() {
        try {
            while (!tabuleiro.objetivoAlcancado()) {
                System.out.println(tabuleiro);
                String digitado = capturarValorDigitado("digite (x, y): ");
                Iterator<Integer> xy = Arrays.stream(digitado.split(",")).map(e -> Integer.parseInt(e.trim())).iterator();

                digitado = capturarValorDigitado("1- Abrir ou 2- (Des)Marcar:");
                if(digitado.equalsIgnoreCase("1")){
                    tabuleiro.abrir(xy.next(), xy.next());
                }else if(digitado.equalsIgnoreCase("2")){
                    tabuleiro.marcar(xy.next(), xy.next());
                }
            }
            System.out.println("Voce ganhou!!!");
        } catch (ExplosaoException e) {
            System.out.println(tabuleiro);
            System.out.println("YOU LOSE");
        }
    }

    private String capturarValorDigitado(String texto) {
        System.out.println(texto);
        String digitado = entrada.nextLine();
        if ("sair".equalsIgnoreCase(digitado)) {
            throw new SairExcepetion();
        }
        return digitado;
    }
}

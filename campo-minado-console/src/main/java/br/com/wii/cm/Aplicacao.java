package br.com.wii.cm;

import br.com.wii.cm.modelo.Tabuleiro;
import br.com.wii.cm.visao.TabuleiroConsole;

public class Aplicacao {
    public static void main(String[] args) {

        Tabuleiro tabuleiro = new Tabuleiro(6, 6, 2);
        new TabuleiroConsole(tabuleiro);
    }
}

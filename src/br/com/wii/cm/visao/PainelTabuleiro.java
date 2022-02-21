package br.com.wii.cm.visao;

import br.com.wii.cm.modelo.Tabuleiro;

import javax.swing.*;
import java.awt.*;

public class PainelTabuleiro extends JPanel {
    public PainelTabuleiro(Tabuleiro tabuleiro) {
        setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));

        tabuleiro.paraCadaCampo(campo -> add(new BotaoCampo(campo)));
        tabuleiro.registrarObservador(evento -> {
            SwingUtilities.invokeLater(() -> {
                if (evento.isResultadoEvento()) {
                    JOptionPane.showMessageDialog(this, "Ganhou :D");

                } else {
                    JOptionPane.showMessageDialog(this, "Perdeu :[");
                }

                 tabuleiro.reiniciar();
            });
        });
    }
}

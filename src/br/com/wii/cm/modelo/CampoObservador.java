package br.com.wii.cm.modelo;
@FunctionalInterface
public interface CampoObservador {
    public void eventoOcorreu(Campo c, CampoEvento evento);

}

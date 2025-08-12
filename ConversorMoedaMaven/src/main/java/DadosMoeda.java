package org.example; // Certifique-se que o pacote está correto

public class Moeda {

    private String codigo;
    private String nomeFormatado;
    private String simbolo;

    // Construtor
    public Moeda(String codigo, String nomeFormatado, String simbolo) {
        this.codigo = codigo;
        this.nomeFormatado = nomeFormatado;
        this.simbolo = simbolo;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getNomeFormatado() {
        return nomeFormatado;
    }

    public String getSimbolo() {
        return simbolo;
    }

    // Setters (opcional, mas pode ser útil dependendo do uso)
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNomeFormatado(String nomeFormatado) {
        this.nomeFormatado = nomeFormatado;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    // Método toString para facilitar a visualização (opcional)
    @Override
    public String toString() {
        return "Moeda{" +
                "codigo='" + codigo + '\'' +
                ", nomeFormatado='" + nomeFormatado + '\'' +
                ", simbolo='" + simbolo + '\'' +
                '}';
    }
}
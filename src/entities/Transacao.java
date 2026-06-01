package entities;


import java.time.LocalDateTime;

import anums.TipoTransacao;

public class Transacao {
    private int id;
    private LocalDateTime dataHora;
    private double valor;
    private TipoTransacao tipo;
    private String descricao;
    
    public Transacao(int id, double valor, TipoTransacao tipo, String descricao) {
        this.id = id;
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
        this.dataHora = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public double getValor() {
        return valor;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Transacao [id=" + id + ", dataHora=" + dataHora + ", valor=" + valor + ", tipo=" + tipo + ", descricao="
                + descricao + "]";
    }
}

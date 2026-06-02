package interfaces;

import entities.Conta;

public interface OperacaoBancaria {
    void depositar(double valor);
    boolean sacar(double valor);
    void transferir(double valor, Conta contaDestino);
}

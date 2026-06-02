package services;

import java.util.ArrayList;
import java.util.List;

import anums.TipoConta;
import entities.Cliente;
import entities.Conta;
import entities.ContaCorrente;
import entities.ContaPoupanca;

public class Banco {
    private List<Conta> contas = new ArrayList<>();
    private int proximoNumero = 1;

    public void abrirConta(Cliente cliente, TipoConta tipo){
        Conta conta;
        
        if(tipo == TipoConta.CORRENTE) {
            conta = new ContaCorrente(
                proximoNumero,
                0.0,
                cliente,
                500.0
            );
        } else {
            conta = new ContaPoupanca(
                proximoNumero,
                0.0,
                cliente
            );
        }

        contas.add(conta);
        System.out.println("Conta criada com sucesso!");
        System.out.println("Tipo: " + tipo);
        System.out.println("Número da conta: " + proximoNumero);
        proximoNumero++;
    }

    public Conta buscarConta(int numero){
        for(Conta conta : contas){
            if(conta.getNumero() == numero){
                return conta;
            }
        }
        System.out.println("Conta não encontrada!");
        return null;
    }

    public List<Conta> listarContas(){
        return new ArrayList<>(contas);
    }
}

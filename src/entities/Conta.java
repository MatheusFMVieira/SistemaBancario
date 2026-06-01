package entities;

import java.util.ArrayList;
import java.util.List;

import interfaces.OperacaoBancaria;

public abstract class Conta implements OperacaoBancaria{
        private int numero;
        private double saldo;
        private Cliente titular;
        private List<Transacao> historico = new ArrayList<>();

        public Conta(int numero, double saldo, Cliente titular) {
                this.numero = numero;
                this.saldo = saldo;
                this.titular = titular;
        }

        @Override
        public abstract void sacar();

        @Override
        public void depositar() {

        }

        @Override
        public void transferir() {

        }

        public void extrato(){

        }

        public void consultarSaldo(){

        }

        public int getNumero() {
                return numero;
        }

        public double getSaldo() {
                return saldo;
        }

        public Cliente getTitular() {
                return titular;
        }

        public List<Transacao> getHistorico() {
                return historico;
        }

        protected void adicionarSaldo(double valor){
                saldo += valor;
        }

        protected void removerSaldo(double valor){
                saldo -= valor;
        }
}

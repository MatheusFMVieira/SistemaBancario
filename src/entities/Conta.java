package entities;

import java.util.ArrayList;
import java.util.List;

import anums.TipoTransacao;
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
        public boolean sacar(double valor){
                if(valor <= getSaldo()){
                        removerSaldo(valor);
                        return true;
                }
                return false;
        }

        @Override
        public void depositar(double valor) {
                adcionarSaldo(valor);
        }

        @Override
        public void transferir(double valor, Conta contaDestino) {
                if (this.sacar(valor)) {

                        contaDestino.depositar(valor);

                        this.historico.add(new Transacao(
                        1,
                        valor,
                        TipoTransacao.TRANSFERENCIA,
                        "Transferência enviada"
                        ));

                        contaDestino.getHistorico().add(new Transacao(
                        2,
                        valor,
                        TipoTransacao.TRANSFERENCIA,
                        "Transferência recebida"
                        ));

                } else {
                        System.out.println("Transferência negada");
                }
        }

        public void extrato() {
                System.out.println("===== EXTRATO BANCÁRIO =====");
                System.out.println("Titular: " + titular.getNome());
                System.out.println("Conta: " + numero);
                System.out.println("-----------------------------");
                for (Transacao t : historico) {
                        System.out.println(t);
                }
                System.out.println("-----------------------------");
                System.out.println("Saldo atual: " + saldo);
                System.out.println("=============================");
        }

        public void consultarSaldo(){
                System.out.println("Saldo da conta " + numero + ": R$ " + saldo);
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

        protected void adcionarSaldo(double valor){
                saldo += valor;
        }

        protected void removerSaldo(double valor){
                saldo -= valor;
        }
}

package entities;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(int numero, double saldo, Cliente titular) {
        super(numero, saldo, titular);
    }

    @Override
    public boolean sacar(double valor) {
        if(valor <= getSaldo()){
            removerSaldo(valor);
            return true;
        }else {
            System.out.println("Saldo insuficiente");
            return false;
        }
    }

    @Override
    public String toString() {
        return "ContaPoupanca [numero=" + getNumero() + ", saldo=" + getSaldo() + "]";
    }
}

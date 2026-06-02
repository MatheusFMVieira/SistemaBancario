package entities;

public class ContaCorrente extends Conta {
    private double limiteEspecial;

    public ContaCorrente(int numero, double saldo, Cliente titular, double limiteEspecial) {
        super(numero, saldo, titular);
        this.limiteEspecial = limiteEspecial;
    }

    @Override
    public boolean sacar(double valor) {
        if(valor <= getSaldo() + limiteEspecial){
            removerSaldo(valor);
            return true;
        }else {
            System.out.println("Saldo insuficiente");
            return false;
        }
    }

    public double getLimiteEspecial() {
        return limiteEspecial;
    }

    @Override
    public String toString() {
        return "ContaCorrente [numero=" + getNumero() + ", saldo=" + getSaldo() + ", limiteEspecial=" + limiteEspecial + "]";
    }
}

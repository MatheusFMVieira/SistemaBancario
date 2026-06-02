package ui;

import java.util.Scanner;

import anums.TipoConta;
import entities.Cliente;
import entities.Conta;
import services.Banco;

public class Menu {
    private Scanner scanner;
    private Banco banco;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.banco = new Banco();
    }

    public void exibirMenu() {
        int opcao = 0;
        while (opcao != 6) {
            System.out.println("\n===== SISTEMA BANCÁRIO =====");
            System.out.println("1 - Abrir Conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Transferência");
            System.out.println("5 - Extrato");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    abrirConta();
                    break;
                case 2:
                    depositar();
                    break;
                case 3:
                    sacar();
                    break;
                case 4:
                    transferir();
                    break;
                case 5:
                    extrato();
                    break;
                case 6:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }

    private void abrirConta() {
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.println("\nEscolha o tipo de conta:");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Poupança");
        System.out.print("Opção: ");
        int tipoConta = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf, email);
        
        if(tipoConta == 1) {
            banco.abrirConta(cliente, TipoConta.CORRENTE);
        } else if(tipoConta == 2) {
            banco.abrirConta(cliente, TipoConta.POUPANCA);
        } else {
            System.out.println("Tipo de conta inválido!");
        }
    }

    private void depositar() {
        System.out.print("Número da conta: ");
        int numero = scanner.nextInt();
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        Conta conta = banco.buscarConta(numero);
        if(conta != null && valor > 0) {
            conta.depositar(valor);
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Depósito inválido!");
        }
    }

    private void sacar() {
        System.out.print("Número da conta: ");
        int numero = scanner.nextInt();
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        Conta conta = banco.buscarConta(numero);
        if(conta != null && valor > 0) {
            if(conta.sacar(valor)) {
                System.out.println("Saque realizado com sucesso!");
            }
        } else {
            System.out.println("Saque inválido!");
        }
    }

    private void transferir() {
        System.out.print("Número da conta de origem: ");
        int numeroOrigem = scanner.nextInt();
        System.out.print("Número da conta de destino: ");
        int numeroDestino = scanner.nextInt();
        System.out.print("Valor: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        Conta contaOrigem = banco.buscarConta(numeroOrigem);
        Conta contaDestino = banco.buscarConta(numeroDestino);

        if(contaOrigem != null && contaDestino != null && valor > 0) {
            contaOrigem.transferir(valor, contaDestino);
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Transferência inválida!");
        }
    }

    private void extrato() {
        System.out.print("Número da conta: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        Conta conta = banco.buscarConta(numero);
        if(conta != null) {
            conta.extrato();
        }
    }
}

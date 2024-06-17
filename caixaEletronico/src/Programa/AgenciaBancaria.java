package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;
    
    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

        public static void operacoes(){

        System.out.println("----------------------------------------------------");
        System.out.println("Bem vindos a nossa Agencia");
        System.out.println("-------------------------------------------");
        System.out.println("******Selecione uma operação********");
        System.out.println("-----------------------------------------------------");
        System.out.println("     Opção - 01 - Criar conta   ");
        System.out.println("     Opção - 02 - Depositar"    );
        System.out.println("     Opção - 03 - Sacar"        );
        System.out.println("     Opção - 04 - Transferir"   );
        System.out.println("     Opção - 05 - Listar"       );
        System.out.println("     Opção - 06 - Sair"         );

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
            criarConta();
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
            listarContas();
                break;
            case 6:
            System.out.println("Obrigado por usar nossa agência!");
            System.exit(0);
            
            default:
            System.out.println("Opção inválida!");
            operacoes();
            break;
    
        }

    }

    public static void criarConta(){

        System.out.println("\nNome: ");
        String nome = input.nextLine();

        System.out.println("\nCPF: ");
        String cpf = input.nextLine();

        System.out.println("\nEmail: ");
        String email = input.nextLine();

        Pessoa pessoa = new Pessoa(nome, cpf, email);

        Conta conta = new Conta(pessoa);

        contasBancarias.add(conta);
        System.out.println("Sua conta foi criada com sucesso!");

        operacoes();

    }


        public static Conta encontrarConta(int numeroConta){
            Conta conta = null;
            if(contasBancarias.size() > 0){
                for(Conta c: contasBancarias) {
                    if(c.getNumeroConta() == numeroConta){
                    conta = c;
                }
            }
        }
            return conta;
    }

        public static void depositar(){
            System.out.println("Numero da Conta: ");
            int numeroConta = input.nextInt();

            Conta conta = encontrarConta(numeroConta);

            if (conta != null){
                System.out.println("Digite o valor a ser depositado: ");
                Double valorDeposito = input.nextDouble();
                conta.depositar(valorDeposito);
                System.out.println("Valor depositado com sucesso!");
            }else{
                System.out.println("--- Conta não encontrada ---");
            }
            operacoes();
        }

        public static void sacar(){
            System.out.println("Digite o numero da conta: ");
            int numeroConta = input.nextInt();

            Conta conta = encontrarConta(numeroConta);

            if (conta != null){
                System.out.println("Digite o valor a ser retirado:");
                Double valorDoSaque = input.nextDouble();
                conta.sacar(valorDoSaque);
                System.out.println("Retire o dinheiro!");
            }else{
                System.out.println("--- Conta não encontrada ---");
            
            }


        }


        public static void transferir(){
            System.out.println("Informe o número da conta do remetente: ");
            int numeroContaRemetente = input.nextInt();

            Conta contaRemetente = encontrarConta(numeroContaRemetente);

            if(contaRemetente != null){
                System.out.println("Informe o numero da conta de destino: ");
                int numeroContaDestinatario = input.nextInt();
                
                Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

                if(contaDestinatario != null){
                    System.out.println("Informe o valor a ser transferido: ");
                    Double valor = input.nextDouble();

                    contaRemetente.transferir(contaDestinatario, valor);

                }else{
                    System.out.println("A conta para deposito nao foi encontrada!");
                }
            }else{
                System.out.println("Conta para transferencia nao encontrada!");
            }

                operacoes();
        }
            public static void listarContas(){
                if(contasBancarias.size() > 0){
                    for(Conta conta : contasBancarias) {
                        System.out.println(conta);
                    }
                }else{
                    System.out.println("Não há contas cadastradas!");
                }
                operacoes();
            }




}

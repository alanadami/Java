package Programa;

import utilitarios.Utils;

public class Conta {

    private static int contadorDeContas = 1;
    
    private int numeroConta;
    private Pessoa pessoa;
    private Double saldo = 0.0;
    
    
    public Conta(Pessoa pessoa) {
        this.numeroConta = contadorDeContas;
        this.pessoa = pessoa;
        contadorDeContas += 1;
    }


    public int getNumeroConta() {
        return numeroConta;
    }


    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }


    public Pessoa getPessoa() {
        return pessoa;
    }


    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }


    public Double getSaldo() {
        return saldo;
    }


    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    
    public String toString(){
        return  "\nNumero da conta: " + this.getNumeroConta() +
                "\nNome: " + this.pessoa.getNome() +
                "\nCPF: " + this.pessoa.getcpf() +
                "\nE-mail: " + this.pessoa.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n";
    }

    public void depositar(Double valor) {
        if (valor > 0){
            setSaldo(getSaldo() + valor);
            System.out.println("Deposito realizado com sucesso!");
        }else{
            System.out.println("Não foi possível realizar o deposito!");
        }
    }

    public void sacar(Double valor){
        if (valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Retire seu dinheiro!");
        }else{
            System.out.println("Saldo insuficiente!");
        }
    }
    
    public void transferir(Conta contaParaDeposito, Double valor){
        if (valor > 0 && this.getSaldo() >= valor){
            setSaldo(getSaldo() - valor);

            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;

            System.out.println("Transferencia realizada!");
        }else{
            System.out.println("Transferencia não realizada!");
        }
    }


}

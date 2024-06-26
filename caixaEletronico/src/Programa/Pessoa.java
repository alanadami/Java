package Programa;


public class Pessoa {

 
    private static int counter = 1;
    
    private String nome;
    private String cpf;
    private String Email;
    
    //constructors

    public Pessoa(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.Email = email;
        counter += 1;
    }


    //Get and St
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getcpf() {
        return cpf;
    }
    public void setCPF(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }

    public String toString(){
        return "\nNome: " + this.getNome() +
               "\ncpf: " + this.getcpf() +
               "\nEmail: " + this.getEmail();
    }

}

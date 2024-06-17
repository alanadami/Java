import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Seja muito bem vindo. Escolha uma opção:");


        Scanner menu = new Scanner (System.in);

        int escolha = 0;

        do{
            System.out.println("1 - Saldo");
            System.out.println("2 - Saque");
            System.out.println("3 - Deposito");
            escolha = menu.nextInt();
        }while(escolha != 0);



    }
}

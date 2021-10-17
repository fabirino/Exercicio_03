package Program;
import java.util.*;

class Leitor {
    private String nome;
    private int utente;

    public Leitor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome do leitor: ");
        nome = sc.nextLine();
        System.out.println("Numero de utente: ");
        utente = sc.nextInt();
        //sc.close();
    }

    public Leitor(String nome_leitor, int n_utente){
        nome = new String(nome_leitor);
        utente = n_utente;
    }

    public String nome(){
        return nome; 
    }
}

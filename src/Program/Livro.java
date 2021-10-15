package Program;
import java.util.*;

class Livro {
    private String nome;
    private String autor;

    public Livro(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome do livro: ");
        nome = sc.nextLine();
        System.out.println("Nome do autor: ");
        autor = sc.nextLine();
        sc.close();
    }

    public Livro(String nome_livro, String nome_autor){
        nome = new String(nome_livro);
        autor = new String(nome_autor);
    }


    public String nome(){
        return nome;
    }

    public String autor(){
        return autor;
    }
}

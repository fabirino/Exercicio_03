package Program;
import java.util.*;

class Livro {
    private String nome;
    private String autor;
    private boolean requisitado;


    public Livro(){
        requisitado = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome do livro: ");
        nome = sc.nextLine();
        System.out.println("Nome do autor: ");
        autor = sc.nextLine();

    }

    public Livro(String nome_livro, String nome_autor){
        requisitado = false;
        nome = new String(nome_livro);
        autor = new String(nome_autor);
    }

    public void requisita(){
        requisitado = true;
    }

    public void devolve(){
        requisitado = false;
    }

    public String nome(){
        return nome;
    }

    public String autor(){
        return autor;
    }

    public boolean requisitado(){
        return requisitado;
    }

}

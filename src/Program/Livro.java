package Program;
import java.util.*;

class Livro {
    private String nome;
    private String autor;
    private boolean requisitado;
    private Data dtReq;
    private Data dtDev;


    public Livro(){
        requisitado = false;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome do livro: ");
        nome = sc.nextLine();
        System.out.println("Nome do autor: ");
        autor = sc.nextLine();
        sc.close();
        dtDev = new Data();
        dtReq = new Data();

    }

    public Livro(String nome_livro, String nome_autor){
        requisitado = false;
        nome = new String(nome_livro);
        autor = new String(nome_autor);
        dtDev = new Data();
        dtReq = new Data();
    }

    public void adicionaDatas(Data dR, Data dD){
        requisitado = true;
        dtReq = dR;
        dtDev = dD;
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

    public Data dataRequisicao(){
        return dtReq;
    }
}

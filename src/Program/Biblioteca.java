package Program;

import java.util.*;

public class Biblioteca {
    private List<Leitor> leitores;
    private List<Livro> livros;
    private List<Livro> requisitados;
    private List<Livro> disponiveis;

    public Biblioteca() {
        leitores = new ArrayList<Leitor>();
        livros = new ArrayList<Livro>();
        requisitados = new ArrayList<Livro>();
        disponiveis = new ArrayList<Livro>();
    }

    public void adicionaLivro() {
        livros.add(new Livro());
    }

    public void adicionaLivro(String nome, String autor) {
        livros.add(new Livro(nome, autor));
    }

    public void adicionaLeitor() {
        leitores.add(new Leitor());
    }

    public void adicionaLeitor(String nome, int n_utente) {
        leitores.add(new Leitor(nome, n_utente));
    }

    public void listaLivros() {
        System.out.println("Os livros existentes na biblioteca são: ");
        for (Livro l : livros) {
            System.out.println("-> \"" + l.nome() + "\" de " + l.autor());
        }
        System.out.println();
    }

    
    public void listaRequisitados() { // listaRequisitados(Data d)

    }

    public void listaLivrosDisponiveis() {

    }

    //TODO
    //Requisicao requisitaLivro(Leitor l, Data dtReq, Data dtDev){

    //}
    
    
    public static void main(String[] args) {
        Biblioteca b = new Biblioteca();

        b.adicionaLivro("As longas trancas do careca", "Ze");
        b.adicionaLivro("Che che princesa", "Mambo");

        int escolha;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1 - Ver lista de livros requesitados num certo dia");
            System.out.println("2 - Ver lista de livros disponiveis");
            System.out.println("3 - Requisitar um livro");
            System.out.println("0 - Sair");
            escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    b.listaRequisitados();
                    break;

                case 2:
                    b.listaLivros();
                    break;
                case 3:

                    break;

                case 0:
                    System.exit(0);
            }
        } while (escolha != 0);
        sc.close();
    }
}

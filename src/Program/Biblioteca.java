package Program;

import java.util.*;

public class Biblioteca {
    private List<Leitor> leitores;
    private List<Livro> livros;

    public Biblioteca() {
        leitores = new ArrayList<Leitor>();
        livros = new ArrayList<Livro>();
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

    public List<Livro> livros() {
        return livros;
    }

    // -----------------------------------------------------------------------

    public void listaLeitores() {
        for (int i = 0; i < leitores.size(); i++) {
            System.out.printf("%d - %s\n", i + 1, leitores.get(i).nome());
        }
    }

    public void listaLivros() {
        System.out.println("Os livros existentes na biblioteca são: ");
        for (Livro l : livros) {
            System.out.println("-> \"" + l.nome() + "\" de " + l.autor());
        }
    }

    public void listaRequisitados(Data d) { //nao esta a dar certo
        boolean existe = false;
        for (Livro l : livros) {
            if (d.dia() == l.dataRequisicao().dia() && d.mes() == l.dataRequisicao().mes() && d.ano() == l.dataRequisicao().ano()) {
                existe = true;
                System.out.println("-> \"" + l.nome() + "\" de " + l.autor());

            }
        }
        if (existe) {
            System.out.println("O(s) livro(s) requisitado(s) nesta data são: ");
            for (Livro l : livros) {
                if (d.dia() == l.dataRequisicao().dia() && d.mes() == l.dataRequisicao().mes() && d.ano() == l.dataRequisicao().ano()) {
                    System.out.println("-> \"" + l.nome() + "\" de " + l.autor());
                }
            }
        } else {
            System.out.println("Não foram encontrado livros requisitados nesse dia!");
        }
        System.out.println();
    }

    public void listaLivrosDisponiveis() {
        System.out.println("Os livros disponiveis para requisicão são: ");
        for (Livro l : livros) {
            if (!l.requisitado()) {
                System.out.println("-> \"" + l.nome() + "\" de " + l.autor());
            }
        }
        System.out.println();
    }

    void requisita(Leitor leitor, Data dtReq, Data dtDev) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indique o número do livro que vai ser requisitado");
        for (int i = 0; i < livros.size(); i++) {
            if (!livros.get(i).requisitado()) {
                System.out.printf("%d - %s\n", i + 1, livros.get(i).nome());
            }
        }

        int livro = 0;
        while (livro > livros.size() || livro < 1) {
            livro = sc.nextInt();
            if (livro > livros.size() || livro < 1) {
                System.out.println("O livro que escolheu nao existe!");
            }
        }

        // System.out.println(livros.get(livro-1).nome());

        livros.get(livro - 1).adicionaDatas(dtReq, dtDev);

        // sc.close();
    }

    // ---------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        Biblioteca b = new Biblioteca();

        b.adicionaLivro("As longas trancas do careca", "Ze");
        b.adicionaLivro("Che che princesa", "Mambo");
        b.adicionaLeitor("Fabio Santos", 2020212310);
        b.adicionaLeitor("Francisco Almeida", 2019205033);

        int escolha;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println();
            System.out.println("1 - Ver lista de livros requesitados num certo dia");
            System.out.println("2 - Ver lista de livros disponiveis");
            System.out.println("3 - Requisitar um livro");
            System.out.println("0 - Sair");
            escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("\nEscolha a data em que pretende ver os livros requisitados:");
                    Data data = new Data();
                    data.criaData();
                    b.listaRequisitados(data);
                    break;

                case 2:
                    b.listaLivrosDisponiveis();
                    break;

                case 3:
                    Data dataRequisicao = new Data();
                    System.out.println("\nData de requisicao");
                    dataRequisicao.criaData();
                    Data dataDevolucao = new Data();
                    dataDevolucao.calculaDevolucao(dataRequisicao);

                    System.out.println("\nIndique o número do leitor que vai requisitar o livro.");
                    b.listaLeitores();

                    int k = sc.nextInt();
                    System.out.println();
                    b.requisita(b.leitores.get(k - 1), dataRequisicao, dataDevolucao);
                    // requesitaLivro(leitor, dataRequisicao, dataDevolucao)
                    break;

                case 0:
                    System.exit(0);
            }
        } while (escolha != 0);
        // sc.close();
    }

}

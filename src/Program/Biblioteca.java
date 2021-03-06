package Program;

import java.util.*;

public class Biblioteca {
    private List<Leitor> leitores;
    private List<Livro> livros;
    private List<Requisicao> requisicoes;

    public Biblioteca() {
        leitores = new ArrayList<Leitor>();
        livros = new ArrayList<Livro>();
        requisicoes = new ArrayList<Requisicao>();
    }

    // funcoes para criar uma base de dados para a biblioteca
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
            System.out.printf("%d - Nome: %s \n    Número de utente: %s\n", i + 1, leitores.get(i).nome(),
                    leitores.get(i).utente());
        }
    }

    public void listaLivros() {
        System.out.println("Os livros existentes na biblioteca são: ");
        for (Livro l : livros) {
            System.out.println("-> \"" + l.nome() + "\" de " + l.autor());
        }
    }

    public void listaRequisitados(Data d) {
        boolean existe = false;
        for (Requisicao r : requisicoes) {
            if (r.dataRequisicao.dia() == d.dia() && r.dataRequisicao.mes() == d.mes()
                    && r.dataRequisicao.ano() == d.ano()) {
                existe = true;
            }
        }

        if (existe) {
            System.out.println("O(s) livro(s) requisitado(s) nesta data são: ");
            for (Requisicao r : requisicoes) {
                if (r.dataRequisicao.dia() == d.dia() && r.dataRequisicao.mes() == d.mes()
                        && r.dataRequisicao.ano() == d.ano()) {
                    r.printDados();
                }
            }
        } else {
            System.out.println("Não foram encontrados livros requisitados nesta data!");
        }
        System.out.println();
    }

    public void listaRequisicoes() {
        boolean existe = false;
        for (Livro l : livros) {
            if (l.requisitado()) {
                existe = true;
            }
        }
        if (existe) {
            for (Requisicao r : requisicoes) {
                r.printDados();
            }
        } else {
            System.out.println("Não foram encontrados registos de requisições.");
        }

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

    public Requisicao requisitaLivro(Leitor leitor, Data dtReq, Data dtDev) {
        Requisicao r = new Requisicao(leitor, dtReq, dtDev);
        Scanner sc = new Scanner(System.in);
        if (requisicoes.size() == livros.size()) {
            System.out.println("Todos os livros foram requisitados");
            return null;
        } else {
            System.out.println("Indique o número do livro que vai ser requisitado");
            for (int i = 0; i < livros.size(); i++) {
                if (!livros.get(i).requisitado()) {
                    System.out.printf("%d - \"%s\"  de %s\n", i + 1, livros.get(i).nome(), livros.get(i).autor());
                }
            }
            int livro = 0;
            while (livro > livros.size() || livro < 1) {
                livro = sc.nextInt();
                if (livro > livros.size() || livro < 1) {
                    System.out.println("O livro que escolheu nao existe!");
                }
            }
            r.adicionaLivro(livros.get(livro - 1));
            requisicoes.add(r);
        }
        // sc.close();
        return r;
    }

    public void entrega() {
        boolean existe = false;
        for (Livro l : livros) {
            if (l.requisitado()) {
                existe = true;
            }
        }
        if (existe) {
            System.out.println("\n Indique o numero do livro que vai ser devolvido: ");
            for(int i = 0; i<livros.size(); i++){
                if(livros.get(i).requisitado()){
                    System.out.println(i+1 + " - " + livros.get(i).nome());
                }
            }
            Scanner sc3 = new Scanner(System.in);
            int j = sc3.nextInt();
            if(j<0 || j>livros.size()){
                System.out.println("Não há registos desse livro na base de dados da biblioteca!");
                return;
            }else{
                if(!livros.get(j-1).requisitado()){
                    System.out.println("O livro que corresponde ao indice selecionado não está requisitado");
                    return;
                }else{
                    livros.get(j-1).devolve();
                System.out.println("O livro \"" + livros.get(j-1).nome()+ "\" foi devolvido.");
            }
                }
                
        }else{
            System.out.println("Não há livros requisitados neste momento logo não é possivel devolver um livro.");
        }
    }

    // ---------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {
        Biblioteca b = new Biblioteca();

        b.adicionaLivro("Introdução à Programação", "Orácio Silva");
        b.adicionaLivro("C in a Nutshell", "Peter Prinz");
        b.adicionaLeitor("Fabio Santos", 2020212310);
        b.adicionaLeitor("Francisco Almeida", 2019205033);

        int escolha;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println();
            System.out.println("1 - Ver lista de livros disponiveis");
            System.out.println("2 - Requisitar um livro");
            System.out.println("3 - Devolver um livro");
            System.out.println("4 - Ver lista de livros requesitados num certo dia");
            System.out.println("5 - Mostrar histórico de requisições");
            System.out.println("6 - Ver lista de leitores");
            System.out.println("7 - Adicionar um leitor");
            System.out.println("8 - Adicionar um livro");
            System.out.println("0 - Sair");

            escolha = sc.nextInt();
            switch (escolha) {
                case 1:
                    b.listaLivrosDisponiveis();
                    break;

                case 2:
                    Data dataRequisicao = new Data();
                    System.out.println("\nData de requisicao");
                    dataRequisicao.criaData();
                    Data dataDevolucao = new Data();
                    dataDevolucao.calculaDevolucao(dataRequisicao);

                    System.out.println("\nIndique o número do leitor que vai requisitar o livro.");
                    b.listaLeitores();

                    int k = sc.nextInt();
                    if (k < 0 || k > b.livros.size()) {
                        System.out.println("Não há registos desse leitor na base de dados da biblioteca!");
                    } else {
                        System.out.println();
                        b.requisitaLivro(b.leitores.get(k - 1), dataRequisicao, dataDevolucao);
                    }

                    break;

                case 3:
                    b.entrega();
                    break;

                case 4:
                    System.out.println("\nEscolha a data em que pretende ver os livros requisitados.");
                    Data data = new Data();
                    data.criaData();
                    b.listaRequisitados(data);
                    break;

                case 5:
                    b.listaRequisicoes();
                    break;

                case 6:
                    System.out.println();
                    b.listaLeitores();
                    break;

                case 7:
                    b.adicionaLeitor();
                    break;

                case 8:
                    b.adicionaLivro();
                    break;

                case 0:
                    System.exit(0);
            }
        } while (escolha != 0);
        // sc.close();
    }

}

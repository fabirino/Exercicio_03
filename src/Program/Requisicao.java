package Program;

public class Requisicao {
    Leitor leitor;
    Livro livro;
    Data dataRequisicao;
    Data dataDevolucao;

    
    public Requisicao(Leitor lt, Data dtReq, Data dtDev){
        leitor = lt;
        dataRequisicao = dtReq;
        dataDevolucao = dtDev;
    }

    public void adicionaLivro(Livro lv){
        livro = lv;
        lv.requisita();
    }

    public Data dataRequisicao(){
        return dataRequisicao;
    }

    public Livro livro(){
        return livro;
    }

    public void printDados(){
        System.out.println();
        System.out.println("Nome do livro: " + livro.nome() + " de " + livro.autor());
        System.out.println("Leitor: " + leitor.nome());
        System.out.println("Número de utente: " + leitor.utente());
        System.out.println("Data de requisição: "+ dataRequisicao.dia() + "/"+ dataRequisicao.mes() + "/" + dataRequisicao.ano());
        System.out.println("Data de devolução: " + dataDevolucao.dia() + "/" + dataDevolucao.mes() + "/" + dataDevolucao.ano());

    }

}

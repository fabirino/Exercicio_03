package Program;

import java.util.*;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data() {
        dia = 0;
        mes = 0;
        ano = 0;
    }

    public void criaData() {
        boolean correto = false;
        Scanner sc = new Scanner(System.in);
        while (!correto) {
            System.out.println("Introduza uma data (dd/mm/aaaa): ");// o formato admitido sera dia/mes/ano
            String data = sc.nextLine();
            String parts[] = data.split("/");
            if (parts.length != 3) {
                System.out.println("O formato da data deve ser dia/mes/ano!");
                continue;
            } else {
                dia = Integer.parseInt(parts[0]);
                mes = Integer.parseInt(parts[1]);
                ano = Integer.parseInt(parts[2]);

                if (dia < 1 || mes < 1 || ano < 1) {
                    System.out.println("Introduza valores positivos para a data!");
                    continue;
                }

                if(mes<0 || mes>12){
                    System.out.println("O calendário atual só tem 12 meses!");
                    continue;
                }
                
                if (dia > 28 && (mes == 2)) {
                    System.out.println("O mes de fevereiro so tem 28 dias!");
                    continue;
                } else if ((dia > 31)
                        && (mes == 1 || mes == 3 || mes == 5 | mes == 7 || mes == 8 || mes == 10 || mes == 12)) {
                    System.out.println("O mês que introduziu só tem 31 dias!");
                    continue;
                } else if (dia > 30 && (mes == 4 || mes == 6 || mes == 9 || mes == 11)) {
                    System.out.println("O mês que introduziu só tem 30 dias!");
                    continue;
                } else {
                    correto = true;
                }
            }
        }
        sc.close();
        // System.out.printf("%d/%d/%d", dia , mes, ano);
    }

    public void calculaDevolucao(Data d) { // admitindo que o leitor tem 30 dias para devolver o livro
        ano = d.ano;
        mes = d.mes + 1;

        if (d.mes == 2) { // mes de fevereiro
            dia = (d.dia + 30) % 28;
        } else if (d.mes == 1 || d.mes == 3 || d.mes == 5 || d.mes == 7 || d.mes == 8 || d.mes == 10 || d.mes == 12) {
            // meses com 31 dias
            dia = (d.dia + 30) % 31;
        } else { // meses com 30 dias
            dia = d.dia;
        }
        //excecoes
        if(d.mes ==12){
            ano = d.ano + 1;
            mes = 1;
        }
        if(d.mes ==1 && d.dia >27){
            dia %= 28;
            mes +=1;
        }
        System.out.printf("%2d/%2d/%4d", dia , mes, ano);
    }

}

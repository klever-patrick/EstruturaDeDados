package AV1.lista0FundamentosDeProgramacao;
// Questão 9: 1131 - Grenais

import java.util.Scanner;

public class Uri1131 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int inter = 0;
        int gremio = 0;
        int empates = 0;
        int total = 0;
        int novoGrenal = 1;

        do {
            if (novoGrenal == 1) {
                total++;
                int i = entrada.nextInt();
                int g = entrada.nextInt();
                if (i > g) {
                    inter++;
                } else if (g > i) {
                    gremio++;
                } else {
                    empates++;
                }
            }
            System.out.println("Novo grenal (1-sim 2-nao)");
            novoGrenal = entrada.nextInt();
        } while (novoGrenal != 2);

        System.out.println(total + " grenais");
        System.out.println("Inter:" + inter);
        System.out.println("Gremio:" + gremio);
        System.out.println("Empates:" + empates);
        if (inter > gremio) {
            System.out.println("Inter venceu mais");
        } else if (inter < gremio) {
            System.out.println("Gremio venceu mais");
        } else {
            System.out.println("Nao houve vencedor");
        }
    }
}

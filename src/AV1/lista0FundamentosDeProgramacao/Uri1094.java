package AV1.lista0FundamentosDeProgramacao;
// Questão 8: 1094 - Experiências

import java.util.Scanner;

public class Uri1094 {
    public static  void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int N = entrada.nextInt();
        int coelho = 0;
        int rato = 0;
        int sapo = 0;
        int x;
        int total;
        String cobaia;
        while(N-- > 0) {
            x = entrada.nextInt();
            cobaia = entrada.next();
            switch (cobaia) {
                case "C" -> coelho += x;
                case "R" -> rato += x;
                case "S" -> sapo += x;
            }
        }
        total = coelho + rato + sapo;
        double percentualCoelho = (100.0 * coelho) / total;
        double percentualRato = (100.0 * rato) / total;
        double percentualSapo = (100.0 * sapo) / total;
        System.out.println("Total: " + total + " cobaias");
        System.out.println("Total de coelhos: " + coelho);
        System.out.println("Total de ratos: " + rato);
        System.out.println("Total de sapos: " + sapo);
        System.out.printf("Percentual de coelhos: %.2f %%\n", percentualCoelho);
        System.out.printf("Percentual de ratos: %.2f %%\n", percentualRato);
        System.out.printf("Percentual de sapos: %.2f %%\n", percentualSapo);
    }
}

package AV1.lista0FundamentosDeProgramacao;
// Questão 2: 1064 - Positivos e Média

import java.util.Scanner;

public class Uri1064 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double valor;
        double soma = 0;
        int cont = 0;
        for (int i = 0; i < 6; i++) {
            valor = input.nextDouble();
            if (valor > 0) {
                cont++;
                soma += valor;
            }
        }
        System.out.printf("%d valores positivos\n", cont);
        System.out.printf("%.1f\n",soma/cont);
    }

}

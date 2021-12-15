package AV1.lista0FundamentosDeProgramacao;
// Questão 1: 1060 - Números Positivos

import java.util.Scanner;

public class Uri1060 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double valor;
        int cont = 0;
        for (int i = 0; i < 6; i++) {
            valor = input.nextDouble();
            if (valor > 0) {
                cont++;
            }
        }
        System.out.printf("%d valores positivos\n", cont);
    }
}
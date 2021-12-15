package AV1.lista0FundamentosDeProgramacao;
// Questão 3: 1065 - Pares entre Cinco Números

import java.util.Scanner;

public class Uri1065 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int valor;
        int cont = 0;
        for (int i = 0; i < 5; i++) {
            valor = input.nextInt();
            if (valor % 2 == 0) {
                cont++;
            }
        }
        System.out.printf("%d valores pares\n", cont);
    }
}

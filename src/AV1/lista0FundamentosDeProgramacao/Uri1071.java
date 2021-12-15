package AV1.lista0FundamentosDeProgramacao;
// Questão 5: 1071 - Soma de Impares Consecutivos I

import java.util.Scanner;

public class Uri1071 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x;
        int y;
        int soma = 0;
        int i;
        x = input.nextInt();
        y = input.nextInt();
        if (x > y) {
            for (i = x - 1; i > y; i--) {
                if (i % 2 != 0) soma += i;
            }
        } else {
            for( i = y - 1; i > x; i--){
                if (i % 2 != 0) soma += i;
            }
        }
        System.out.printf("%d\n", soma);
    }
}

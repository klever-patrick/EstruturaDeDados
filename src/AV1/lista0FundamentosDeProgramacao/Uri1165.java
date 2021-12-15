package AV1.lista0FundamentosDeProgramacao;
// Questão 15: 1165 - Número Primo

import java.util.Scanner;

public class Uri1165 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int N = entrada.nextInt();
        int X;
        int cont;
        for (int i = 0; i < N; i++) {
            cont = 0;
            X = entrada.nextInt();
            for (int j = 2; j < X; j++) {
                if (X % j == 0) cont++;
            }
            if (cont == 0) {
                System.out.println(X + " eh primo");
            } else System.out.println(X + " nao eh primo");
        }
    }
}

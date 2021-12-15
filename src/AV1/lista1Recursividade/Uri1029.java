package AV1.lista1Recursividade;
// Questão 2: 1029 - Fibonacci, Quantas Chamadas?

import java.util.Scanner;

public class Uri1029 {
    static int contador, call;
    static int fibonacci(int n) {
        if (n == 0) {
            call++;
            return 0;
        }
        else if (n == 1) {
            call++;
            contador++;
            return 1;
        } else {
            call++;
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        int n, x;

        Scanner entrada = new Scanner(System.in);
        n = entrada.nextInt();
        for (int i = 0; i < n; ++i) {
            contador = 0;
            call = 0;
            x = entrada.nextInt();
            fibonacci(x);
            System.out.printf("fib(%d) = %d calls = %d\n", x, call - 1, contador);
        }
    }
}

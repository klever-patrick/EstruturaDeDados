package AV1.lista0FundamentosDeProgramacao;
// Questão 11: 1151 - Fibonacci Fácil

import java.util.Scanner;

public class Uri1151 {
    public static int calculaFibonacci(int qtdTermos) {
        int fibonacci = 0;
        int anterior = 0;
        for (int i = 1; i <= qtdTermos; i++) {
            if (i == 1) {
                fibonacci = 1;
                anterior = 0;
            } else {
                fibonacci += anterior;
                anterior = fibonacci - anterior;
            }
        }
        return fibonacci;
    }
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int N = entrada.nextInt();
        for (int i = 0; i < N - 1; i++) {
            System.out.print(calculaFibonacci(i) + " ");
        }
        System.out.println(calculaFibonacci(N - 1));
    }
}

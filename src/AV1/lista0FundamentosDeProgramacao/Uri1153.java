package AV1.lista0FundamentosDeProgramacao;
// Questão 12: 1153 - Fatorial Simples

import java.util.Scanner;

public class Uri1153 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numero;
        int fatorial = 1;
        do {
            numero = entrada.nextInt();
        } while (numero <= 0 || numero >= 13);

        for (int i = 1; i <= numero; i++) {
            fatorial *= i;
        }
        if (numero == 1) fatorial = 1;
        System.out.println(fatorial);
    }
}

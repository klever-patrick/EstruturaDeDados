package AV1.lista0FundamentosDeProgramacao;
// Questão 6: 1072 - Intervalo 2

import java.util.Scanner;

public class Uri1072 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();
        int[] x = new int[n];
        int in = 0;
        int out = 0;
        for (int i = 0; i < x.length; i++) {
            x[i] = entrada.nextInt();
            if (x[i] >= 10 && x[i] <= 20) in++;
            else out++;
        }
        System.out.println(in + " in");
        System.out.println(out + " out");
    }
}

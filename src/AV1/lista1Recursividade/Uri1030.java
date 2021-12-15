package AV1.lista1Recursividade;
// Questão 3: 1030 - A Lenda de Flavious Josephus

import java.util.Scanner;

public class Uri1030 {
    public static int josephus(int n, int k){
        if (n == 1) {
            return 1;
        } else {
            return (josephus(n - 1, k) + k - 1) % n + 1;
        }
    }

    public static void main(String[] args) {
        int n, k, sobrevivente;
        Scanner entrada = new Scanner(System.in);
        int nc = entrada.nextInt();

        for(int i = 1; i <= nc; ++i) {
            n = entrada.nextInt();
            k = entrada.nextInt();
            sobrevivente = josephus(n,k);
            System.out.println("Case " + i + ": " + sobrevivente);
        }
        entrada.close();
    }
}

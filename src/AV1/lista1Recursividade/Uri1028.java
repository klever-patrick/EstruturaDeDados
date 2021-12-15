package AV1.lista1Recursividade;
// Questão 1: 1028 - Figurinhas

import java.util.Scanner;

public class Uri1028 {
    public static int figurinhas(int f1, int f2) {
        if(f2 == 0) {
            return f1;
        } else {
            return figurinhas(f2, (f1 % f2));
        }
    }

    public static void main(String[] args) {
        int f1, f2, resultadoMDC;

        Scanner entrada = new Scanner(System.in);
        int n = entrada.nextInt();

        for(int i = 1; i <= n ; ++i){
            f1 = entrada.nextInt();
            f2 = entrada.nextInt();
            resultadoMDC = figurinhas(f1, f2);
            System.out.println(resultadoMDC);
        }
        entrada.close();
    }
}

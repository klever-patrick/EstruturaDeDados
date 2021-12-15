package AV1.lista0FundamentosDeProgramacao;
// Questão 7: 1080 - Maior e Posição

import java.util.Scanner;

public class Uri1080 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int maior = 0;
        int posicao = 0;
        for (int i = 1; i <= 100; i++) {
            int valor = entrada.nextInt();
            if (maior <= valor) {
                posicao = i;
                maior = valor;
            }
        }
        System.out.println(maior);
        System.out.println(posicao);
    }
}

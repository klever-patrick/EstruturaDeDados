package AV2.lista4Filas;
// Questão 1: 1110 - Jogando Cartas Fora

import java.util.Scanner;

public class Uri1110 {
    public static class No {
        int valor;
        No proximo;

        public No(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    public static class Fila {
        No primeiro;
        No ultimo;
        int tamanho;

        public Fila() {
            this.primeiro = null;
            this.ultimo = null;
            this.tamanho = 0;
        }

        public int tamanho() {
            return tamanho;
        }

        public boolean vazio() {
            return tamanho == 0;
        }

        public void enfileirar(int valor) {
            No novo = new No(valor);
            if (vazio()) {
                primeiro = novo;
            } else {
                ultimo.proximo = novo;
            }
            ultimo = novo;
            tamanho++;
        }

        public void desenfileirar() {
            if (!vazio()) {
                No temporario = primeiro;
                primeiro = primeiro.proximo;
                temporario.proximo = null;
            }
            tamanho--;
        }

        public int front() {
            return this.primeiro.valor;
        }

    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numeros;

        while (true) {
            Fila fila = new Fila();
            numeros = entrada.nextInt();
            if (numeros == 0) {
                entrada.close();
                break;
            }
            for (int i = 1; i <= numeros; i++) {
                fila.enfileirar(i);
            }

            System.out.print("Discarded cards: ");

            while (fila.tamanho() > 1) {
                if (fila.tamanho() != 2) {
                    System.out.print(fila.front() + ", ");
                }
                else {
                    System.out.print(fila.front());
                }
                fila.desenfileirar();
                fila.enfileirar(fila.front());
                fila.desenfileirar();
            }
            System.out.println();
            System.out.println("Remaining card: " + fila.front());

        }
    }
}

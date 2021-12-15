package AV2.lista4Filas;
// Questão 2: 1548 - Fila do Recreio

import java.util.Scanner;

public class Uri1548 {
    public static class No {
        int valor;
        int prioridade;
        No anterior;
        No proximo;

        public No(int valor, int prioridade) {
            this.valor = valor;
            this.prioridade = prioridade;
            this.anterior = null;
            this.proximo = null;
        }
    }

    public static class FilaDePrioridade {
        No primeiro;
        No ultimo;
        int tamanho;

        public FilaDePrioridade() {
            this.primeiro = null;
            this.ultimo = null;
            this.tamanho = 0;
        }

        public void enfileirar(int valor, int prioridade) {
            No novo = new No(valor, prioridade);
            if (primeiro == null) {
                primeiro = novo;
                ultimo = novo;
            }
            else if (novo.prioridade > primeiro.prioridade) {
                novo.proximo = primeiro;
                primeiro.anterior = novo;
                primeiro = novo;
            }
            else if (novo.prioridade <= ultimo.prioridade) {
                ultimo.proximo = novo;
                novo.anterior = ultimo;
                ultimo = novo;
            } else {

                No atual = primeiro;
                while (atual != null && novo.prioridade <= atual.prioridade) {
                    atual = atual.proximo;
                }

                assert atual != null;
                atual.anterior.proximo = novo;
                novo.anterior = atual.anterior;
                atual.anterior = novo;
                novo.proximo = atual;

            }
            tamanho++;
        }

    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int qtdCasos = Integer.parseInt(entrada.next());
        int indiceNotas = 1;
        int qtdNaotrocas = 0;

        for(int i = 0; i < qtdCasos; i++) {

            FilaDePrioridade fila = new FilaDePrioridade();
            int qtdAlunos = Integer.parseInt(entrada.next());
            entrada.nextLine();
            String[] v = entrada.nextLine().split(" ");
            int[] notas = new int[qtdAlunos];

            for (int j = 0; j <  qtdAlunos; j++) {
                notas[j] = Integer.parseInt(v[j]);
            }
            for (int nota : notas) {
                fila.enfileirar(indiceNotas, nota);
                indiceNotas++;
            }
            int z = 0;
            for (No atual = fila.primeiro; atual != null; atual = atual.proximo) {
                if (notas[z] == atual.prioridade) {
                    qtdNaotrocas++;
                }
                z++;
            }
            System.out.println(qtdNaotrocas);
            indiceNotas = 1;
            qtdNaotrocas = 0;
        }
        entrada.close();
    }
}

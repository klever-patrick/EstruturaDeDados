package AV2.lista4Filas;
// Questão 3: 2460 - Fila

import java.util.Scanner;

public class Uri2460 {
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
            else if (novo.prioridade < primeiro.prioridade) {
                novo.proximo = primeiro;
                primeiro.anterior = novo;
                primeiro = novo;
            }
            else if (novo.prioridade >= ultimo.prioridade) {
                ultimo.proximo = novo;
                novo.anterior = ultimo;
                ultimo = novo;
            } else {
                No atual = primeiro;
                while (atual != null && novo.prioridade >= atual.prioridade) {
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

        public void exibir() {
            for (No atual = primeiro; atual != null; atual = atual.proximo) {
                if (atual.proximo == null) {
                    System.out.print(atual.valor);
                } else {
                    System.out.print(atual.valor + " ");
                }
            }
            System.out.println();
        }


        public boolean estaNaFila(int valor) {
            for (No atual = primeiro; atual != null; atual = atual.proximo) {
                if (atual.valor == valor) {
                    return true;
                }
            }
            return false;
        }

    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int qtdPessoas = Integer.parseInt(entrada.next());
        int ordemDeChegada = 0;

        FilaDePrioridade fila = new FilaDePrioridade();
        entrada.nextLine();

        String[] v = entrada.nextLine().split(" ");

        int[] pessoas = new int[qtdPessoas];

        for (int i = 0; i < v.length; i++) {
            pessoas[i] = Integer.parseInt(v[i]);
        }

        for (int pessoa : pessoas) {
            fila.enfileirar(pessoa, ordemDeChegada);
            ordemDeChegada++;
        }


        int qtdSaida = entrada.nextInt();
        entrada.nextLine();
        String[] vetor = entrada.nextLine().split(" ");
        int[] pessoasSairam = new int[qtdSaida];

        for (int j = 0; j < vetor.length; j++) {
            pessoasSairam[j] = Integer.parseInt(vetor[j]);
        }

        FilaDePrioridade filaSaida = new FilaDePrioridade();
        ordemDeChegada = 0;
        for (int pessoa : pessoasSairam) {
            filaSaida.enfileirar(pessoa, ordemDeChegada);
            ordemDeChegada++;
        }

        FilaDePrioridade filaFinal = new FilaDePrioridade();
        for (No atual = fila.primeiro; atual != null; atual = atual.proximo) {
            if (!filaSaida.estaNaFila(atual.valor)) {
                filaFinal.enfileirar(atual.valor, atual.prioridade);
            }
        }

        filaFinal.exibir();

        entrada.close();
    }
}

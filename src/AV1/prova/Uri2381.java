package AV1.prova;
// Questão 2: 2381 - Lista de Chamada

import java.util.Scanner;

public class Uri2381 {
    public static class No {
        public String nome;
        public No proximo;

        public No(String nome) {
            this.nome = nome;
            proximo = null;
        }
    }

    public static class ListaDinamicaOrdenada {
        private No primeiro;
        private No ultimo;

        public ListaDinamicaOrdenada() {
            primeiro = null;
            ultimo = null;
        }

        public void adicionarOrdenado(String nome) {
            No novo = new No(nome);

            if (primeiro == null) {
                primeiro = novo;
                ultimo = novo;
            }
            else if (novo.nome.compareToIgnoreCase(primeiro.nome) < 0) {
                novo.proximo = primeiro;
                primeiro = novo;
            }
            else if (novo.nome.compareToIgnoreCase(ultimo.nome) > 0) {
                ultimo.proximo = novo;
                ultimo = novo;
            } else {
                No anterior = null;
                No atual = primeiro;

                while (atual != null && novo.nome.compareToIgnoreCase(atual.nome) > 0) {
                    anterior = atual;
                    atual = atual.proximo;
                }

                anterior.proximo = novo;
                novo.proximo = atual;
            }
        }

        public void exibir() {
            No atual = primeiro;

            while (atual != null) {
                System.out.println(atual.nome);
                atual = atual.proximo;
            }

            System.out.println();
        }

        public void sortear(int sorteado) {
            No atual = primeiro;

            for(int i = 0; i < sorteado; i++) {
                if(i == sorteado - 1) {
                    System.out.println(atual.nome);

                } else {
                    atual = atual.proximo;
                }
            }
        }
    }
    public static void main(String[] args) {
        ListaDinamicaOrdenada lista = new ListaDinamicaOrdenada();

        Scanner entrada = new Scanner(System.in);
        String alunos = entrada.nextLine();

        String[] separacao = alunos.split(" ");
        int qtdAlunos = Integer.parseInt(separacao[0]);

        for(int i = 0; i < qtdAlunos; i++) {
            lista.adicionarOrdenado(entrada.next());
        }

        // lista.exibir();
        int alunoSorteado = Integer.parseInt(separacao[1]);
        lista.sortear(alunoSorteado);
    }
}

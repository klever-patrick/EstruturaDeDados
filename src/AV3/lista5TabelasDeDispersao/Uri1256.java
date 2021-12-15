package AV3.lista5TabelasDeDispersao;
// Questão 1: 1256 - Tabelas Hash

import java.util.Scanner;

public class Uri1256 {
    public static class No {
        int valor;
        No proximo;

        public No(int valor) {
            this.valor = valor;
            proximo = null;
        }
    }

    public static class ListaDinamica {
        No primeiro;
        No ultimo;

        public ListaDinamica() {
            primeiro = null;
            ultimo = null;
        }

        public void adicionarFinal(int valor) {
            No novo = new No(valor);

            if (primeiro == null) {
                primeiro = novo;
            } else {
                ultimo.proximo = novo;
            }
            ultimo = novo;
        }

        public void exibir() {
            if (primeiro == null) {
                System.out.print("\\");
            }
            for (No atual = primeiro; atual != null; atual = atual.proximo) {
                System.out.print(atual.valor + " -> ");
                if (atual.proximo == null) {
                    System.out.print("\\");
                }
            }
            System.out.println();
        }

    }

    public static class ClosedHash {
        ListaDinamica[] tabela;

        public ClosedHash(int tamanho) {
            tabela = new ListaDinamica[tamanho];
        }

        public int calcularPosicao(int valor) {
            return valor % tabela.length;
        }

        public void put(int valor) {
            int posicao = calcularPosicao(valor);
            if (tabela[posicao] == null) {
                tabela[posicao] = new ListaDinamica();
            }
            tabela[posicao].adicionarFinal(valor);
        }

        public void exibirHash() {
            for (int i = 0; i < tabela.length; i++) {
                if (tabela[i] != null) {
                    System.out.print(i + " -> ");
                    tabela[i].exibir();
                } else {
                    ListaDinamica ajuda = new ListaDinamica();
                    System.out.print(i + " -> ");
                    ajuda.exibir();
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int qtdCasos = Integer.parseInt(entrada.next());
        entrada.nextLine();

        int contador = 0;

        while (contador < qtdCasos) {
            String[] linha = entrada.nextLine().split(" ");
            int qtdEnderecos = Integer.parseInt(linha[0]);
            int qtdChaves = Integer.parseInt(linha[1]);

            String[] chaves = entrada.nextLine().split(" ");
            int[] intChaves = new int[chaves.length];

            ClosedHash h = new ClosedHash(qtdEnderecos);

            for (int i = 0; i < qtdChaves; i++) {
                intChaves[i] = Integer.parseInt(chaves[i]);
                h.put(intChaves[i]);
            }

            h.exibirHash();
            if (contador != (qtdCasos - 1)) {
                System.out.println();
            }

            contador++;
        }

    }
}

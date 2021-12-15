package AV3.lista5TabelasDeDispersao;
// Questão 2: 1257 - Array Hash

import java.util.Scanner;

public class Uri1257 {
    static Scanner entrada = new Scanner(System.in);

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

        public int calcularPosicao(int qtdLinhas) {
            int posicao = 0;
            char[] linha;
            for (int i = 0; i < qtdLinhas; i++) {
                linha = entrada.next().toCharArray();
                for (int j = 0; linha[j] != '\0'; j++) {
                    posicao += linha[j] - 65 + i + j;
                    if (j == linha.length - 1) {
                        break;
                    }
                }
            }
            return posicao;
        }

        public void put(int valor) {
            int posicao = calcularPosicao(valor);
            if (tabela[posicao] == null) {
                tabela[posicao] = new ListaDinamica();
                tabela[posicao].adicionarFinal(valor);
            } else {
                tabela[posicao].adicionarFinal(valor);
            }
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
        int qtdCasos = Integer.parseInt(entrada.next());
        entrada.nextLine();

        int qtdLinhas;
        for (int i = 0; i < qtdCasos; i++) {
            qtdLinhas = Integer.parseInt(entrada.next());
            System.out.println(new ClosedHash(50000).calcularPosicao(qtdLinhas));
        }

    }
}

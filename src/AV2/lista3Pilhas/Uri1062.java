package AV2.lista3Pilhas;
// Questão 1: 1062 - Trilhos

import java.util.Scanner;

public class Uri1062 {
    public static class No {
        int valor;
        No proximo;

        public No(int valor) {
            this.valor = valor;
        }
    }

    public static class Pilha {
        No topo;
        int tamanho;

        public Pilha() {
            topo = null;
            tamanho = 0;
        }

        public int tamanho() {
            return tamanho;
        }

        public boolean vazio() {
            return tamanho == 0;
        }

        public void empilhar(int valor) {
            No novo = new No(valor);
            novo.proximo = topo;
            topo = novo;
            tamanho++;
        }

        public int desempilhar() {
            if (vazio()) {
                System.out.println("Pilha vazia.");
            }
            int retorno = topo.valor;
            topo = topo.proximo;
            tamanho--;
            return  retorno;
        }

        public int topo() {
            if (vazio()) {
                System.out.println("Pilha vazia.");
            }
            return topo.valor;
        }

        public void exibir() {
            for (No atual = topo; atual != null; atual = atual.proximo) {
                System.out.println(atual.valor);
            }
        }
    }

    public static class NoFila {
        int valor;
        NoFila proximo;

        public NoFila(int valor) {
            this.valor = valor;
            this.proximo = null;
        }
    }

    public static class Fila {
        NoFila primeiro;
        NoFila ultimo;
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
            NoFila novo = new NoFila(valor);
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
                NoFila temporario = primeiro;
                primeiro = primeiro.proximo;
                temporario.proximo = null;
            }
            tamanho--;
        }

        public void exibir() {
            for (NoFila atual = primeiro; atual != null; atual = atual.proximo) {
                System.out.print(atual.valor + " ");
            }
            System.out.println();
        }

        public int obterElemento(int indice) {
            int contador = 0;
            for (NoFila atual = primeiro; atual != null; atual = atual.proximo) {
                if (indice == contador) {
                    return atual.valor;
                }
                contador++;
            }
            return 0;
        }

    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        while (true) {

            int qtdVagoes = Integer.parseInt(entrada.next());
            entrada.nextLine();

            if (qtdVagoes == 0) {
                break;
            }


            Fila filaEntrada = new Fila();
            for (int i = 1; i <= qtdVagoes; i++) {
                filaEntrada.enfileirar(i);
            }


            while (filaEntrada.obterElemento(0) != 0) {

                String[] linhaSaida = entrada.nextLine().split(" ");
                int[] vagoesSaida = new int[qtdVagoes];

                if (linhaSaida[0].equals("0")) {
                    System.out.println();
                    break;
                }


                for (int i = 0; i < qtdVagoes; i++) {
                    vagoesSaida[i] = Integer.parseInt(linhaSaida[i]);
                }

                Fila filaSaida = new Fila();
                for (int i = 0; i < vagoesSaida.length; i++) {
                    filaSaida.enfileirar(vagoesSaida[i]);
                }

                Pilha pilha = new Pilha();
                int vagaoSaida = 0;
                int vagaoEntrada = 0;

                while (true) {
                    if ((!pilha.vazio()) && (vagaoSaida < qtdVagoes) && (pilha.topo() == filaSaida.obterElemento(vagaoSaida))) {
                        pilha.desempilhar();
                        vagaoSaida++;
                    } else if (vagaoEntrada < qtdVagoes) {
                        pilha.empilhar(filaEntrada.obterElemento(vagaoEntrada));
                        vagaoEntrada++;
                    } else {
                        break;
                    }
                }
                if (pilha.tamanho() == 0) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }

            }

        }

    }
}

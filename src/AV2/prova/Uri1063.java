package AV2.prova;
// Questão 1: 1063 - Trilhos Novamente... Traçando Movimentos

import java.util.Scanner;

public class Uri1063 {
    public static class No {
        char valor;
        No proximo;

        public No(char valor) {
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

        public void empilhar(char valor) {
            No novo = new No(valor);
            novo.proximo = topo;
            topo = novo;
            tamanho++;
        }

        public char desempilhar() {
            if (vazio()) {
                System.out.println("Pilha vazia.");
            }
            char retorno = topo.valor;
            topo = topo.proximo;
            tamanho--;
            return  retorno;
        }

        public char topo() {
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
        char valor;
        NoFila proximo;

        public NoFila(char valor) {
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

        public void enfileirar(char valor) {
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

        public char obterElemento(int indice) {
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

            String linha = entrada.nextLine();
            char[] vagoes = linha.toCharArray();

            Fila filaEntrada = new Fila();
            for (int i = 0; i < vagoes.length; i++) {
                if (vagoes[i] != ' ') {
                    filaEntrada.enfileirar(vagoes[i]);
                }

            }

            String linhaSaida = entrada.nextLine();
            char[] vagoesSaida = linhaSaida.toCharArray();

            Fila filaSaida = new Fila();
            for (int i = 0; i < vagoesSaida.length; i++) {
                if (vagoesSaida[i] != ' ') {
                    filaSaida.enfileirar(vagoesSaida[i]);
                }
            }

            Pilha pilha = new Pilha();
            int vagaoSaida = 0;
            int vagaoEntrada = 0;

            while (true) {
                if ((!pilha.vazio()) && (vagaoSaida < qtdVagoes) && (pilha.topo() == filaSaida.obterElemento(vagaoSaida))) {
                    pilha.desempilhar();
                    System.out.print("R");
                    vagaoSaida++;
                } else if (vagaoEntrada < qtdVagoes) {
                    pilha.empilhar(filaEntrada.obterElemento(vagaoEntrada));
                    System.out.print("I");
                    vagaoEntrada++;
                } else {
                    break;
                }
            }
            if (pilha.tamanho() == 0) {
                System.out.println();
            } else {
                System.out.println(" Impossible");
            }

        }
    }
}

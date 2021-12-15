package AV2.lista3Pilhas;
// Questão 2: 1068 - Balanço de Parênteses I

import java.util.Scanner;

public class Uri1068 {
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

        public boolean vazia() {
            return tamanho == 0;
        }

        public void empilhar(char valor) {
            No novo = new No(valor);
            novo.proximo = topo;
            topo = novo;
            tamanho++;
        }

        public char desempilhar() {
            if(vazia()) {
                System.out.println("Pilha vazia");
            }
            char retorno = topo.valor;
            topo = topo.proximo;
            tamanho--;
            return retorno;
        }

        public char topo() {
            if(vazia()) {
                System.out.println("Pilha vazia");
            }
            return topo.valor;
        }

        public void exibir() {
            for(No atual = topo; atual != null; atual = atual.proximo) {
                System.out.println(atual.valor);
            }
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String linha;

        while (entrada.hasNext()){
            Pilha pilha = new Pilha();
            linha = entrada.nextLine();
            for (int i = 0; i < linha.length(); i++) {
                if (linha.charAt(i) == '(') {
                    pilha.empilhar('(');
                }

                if (linha.charAt(i) == ')') {
                    if (!pilha.vazia()) {
                        pilha.desempilhar();
                    } else {
                        pilha.empilhar(')');
                    }
                }
            }

            if (pilha.vazia()) {
                System.out.println("correct");
            } else {
                System.out.println("incorrect");
            }

        }

        entrada.close();
    }
}

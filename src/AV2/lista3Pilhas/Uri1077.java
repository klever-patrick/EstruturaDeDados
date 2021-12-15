package AV2.lista3Pilhas;
// Questão 3: 1077 - Infixa para Posfixa

import java.util.Scanner;

public class Uri1077 {
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
            if(vazio()) {
                System.out.println("Pilha vazia.");
            }
            char retorno = topo.valor;
            topo = topo.proximo;
            tamanho--;
            return retorno;
        }


        public char topo() {
            if(vazio()) {
                System.out.println("Pilha vazia.");
            }
            return topo.valor;
        }

        public void exibir() {
            for(No atual = topo; atual != null; atual = atual.proximo) {
                System.out.println(atual.valor);
            }
        }

        public int precedencia(char valor) {
            return switch (valor) {
                case '+', '-' -> 1;
                case '*', '/' -> 2;
                case '^' -> 3;
                default -> -1;
            };
        }

        public static String infixaParaPosfixa(String expressao) {
            StringBuilder resultado = new StringBuilder();

            Pilha pilha = new Pilha();

            for (int i = 0; i < expressao.length(); i++) {
                char caractere = expressao.charAt(i);

                if (Character.isLetterOrDigit(caractere)) {
                    resultado.append(caractere);
                }

                else if (caractere == '(') {
                    pilha.empilhar(caractere);
                }

                else if (caractere == ')') {

                    while (!pilha.vazio() && pilha.topo() != '(') {
                        resultado.append(pilha.desempilhar());
                    }
                    pilha.desempilhar();

                } else {
                    while (!pilha.vazio() && pilha.precedencia(caractere) <= pilha.precedencia(pilha.topo())) {
                        resultado.append(pilha.desempilhar());
                    }
                    pilha.empilhar(caractere);
                }
            }

            while (!pilha.vazio()) {
                if (pilha.topo() == '(') {
                    return "Expressão inválida.";
                }

                resultado.append(pilha.desempilhar());
            }

            return resultado.toString();
        }

    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int qtdCasos = entrada.nextInt();

        for (int i = 0; i < qtdCasos; i++) {
            String expressao = entrada.next();
            System.out.println(Pilha.infixaParaPosfixa(expressao));
        }
    }
}

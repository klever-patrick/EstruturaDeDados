package AV3.lista6Arvores;
// Questão 1: 1195 - Árvore Binária de Busca

import java.util.Scanner;

public class Uri1195 {
    public static class NoArvore {
        int valor;
        NoArvore esquerda;
        NoArvore direita;
        boolean visitado;

        public NoArvore(int valor) {
            this.valor = valor;
            this.esquerda = null;
            this.direita = null;
            this.visitado = false;
        }
    }

    public static class ArvoreBinariaBusca {
        NoArvore raiz;

        public ArvoreBinariaBusca() {
            raiz = null;
        }

        public void adicionar(int valor) {
            if (raiz == null) {
                raiz = new NoArvore(valor);
            }
            else {
                adicionar(valor, raiz);
            }
        }

        private void adicionar(int valor, NoArvore raiz) {
            if (valor < raiz.valor) {
                if (raiz.esquerda == null) {
                    raiz.esquerda = new NoArvore(valor);
                }
                else {
                    adicionar(valor, raiz.esquerda);
                }
            }
            else if (valor > raiz.valor) {
                if (raiz.direita == null) {
                    raiz.direita = new NoArvore(valor);
                }
                else {
                    adicionar(valor, raiz.direita);
                }
            }
        }

        public void exibirPreOrdem() {
            if (raiz != null) {
                exibirPreOrdem(raiz);
                System.out.println();
            }
        }

        private void exibirPreOrdem(NoArvore raiz) {
            System.out.print(" " + raiz.valor);

            if (raiz.esquerda != null) {
                exibirPreOrdem(raiz.esquerda);
            }

            if (raiz.direita != null) {
                exibirPreOrdem(raiz.direita);
            }
        }

        public void exibirEmOrdem() {
            if (raiz != null) {
                exibirEmOrdem(raiz);
                System.out.println();
            }
        }

        private void exibirEmOrdem(NoArvore raiz) {
            if (raiz.esquerda != null) {
                exibirEmOrdem(raiz.esquerda);
            }

            System.out.print(" " + raiz.valor );

            if (raiz.direita != null) {
                exibirEmOrdem(raiz.direita);
            }
        }

        public void exibirPosOrdem() {
            NoArvore temporario = raiz;
            while (temporario != null && !temporario.visitado) {
                if (temporario.esquerda != null && !temporario.esquerda.visitado) {
                    temporario = temporario.esquerda;
                }
                else if (temporario.direita != null && !temporario.direita.visitado) {
                    temporario = temporario.direita;
                } else {
                    System.out.print(" " + temporario.valor);
                    temporario.visitado = true;
                    temporario = raiz;
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int qtdCasos = Integer.parseInt(entrada.next());
        entrada.nextLine();

        for (int contador = 1; contador <= qtdCasos; contador++) {
            ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
            int tamanhoArvore = Integer.parseInt(entrada.next());
            entrada.nextLine();
            String[] vetorValores = entrada.nextLine().split(" ");

            for (int i = 0; i < tamanhoArvore; i++) {
                arvore.adicionar(Integer.parseInt(vetorValores[i]));
            }
            System.out.println("Case "+ contador + ":");
            System.out.print("Pre.:");
            arvore.exibirPreOrdem();
            System.out.print("In..:");
            arvore.exibirEmOrdem();
            System.out.print("Post:");
            arvore.exibirPosOrdem();
            System.out.println();
        }
        entrada.close();
    }
}
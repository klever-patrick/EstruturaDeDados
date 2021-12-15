package AV3.lista6Arvores;
// Questão 2: 1861 - O Hall dos Assassinos

import java.util.Scanner;

public class Uri1861 {
    public static class NoArvore {
        String palavra;
        int qtdAssasinatos;

        NoArvore esquerda;
        NoArvore direita;

        public NoArvore(String palavra) {
            this.palavra = palavra;
            this.esquerda = null;
            this.direita = null;
            this.qtdAssasinatos = 0;
        }
    }
    public static class ArvoreBinariaBusca {
        NoArvore raiz;
        ArvoreBinariaBusca assassinados;

        public ArvoreBinariaBusca() {
            raiz = null;
        }

        public void adicionar(String palavra) {

            if (raiz == null) {
                raiz = new NoArvore(palavra);
            } else {
                adicionar(palavra, raiz);
            }
            incrementarAssassinatos(raiz, palavra);
        }

        public void adicionar(String palavra, NoArvore raiz) {
            if (palavra.compareTo(raiz.palavra) < 0) {
                if (raiz.esquerda == null) {
                    raiz.esquerda = new NoArvore(palavra);
                } else {
                    adicionar(palavra, raiz.esquerda);
                }
            }
            else if (palavra.compareTo(raiz.palavra) > 0) {
                if (raiz.direita == null) {
                    raiz.direita = new NoArvore(palavra);
                } else {
                    adicionar(palavra, raiz.direita);
                }
            }
        }

        public void exibirEmOrdem() {
            if (raiz != null) {
                exibirEmOrdem(raiz);
            }
        }

        public void exibirEmOrdem(NoArvore raiz) {
            if (raiz.esquerda != null) {
                exibirEmOrdem(raiz.esquerda);
            }

            if (!assassinados.pesquisar(raiz.palavra)) {
                System.out.print(raiz.palavra);
                System.out.println(" " + raiz.qtdAssasinatos);
            }

            if (raiz.direita != null) {
                exibirEmOrdem(raiz.direita);
            }
        }

        public boolean pesquisar(String palavra) {
            if (raiz == null) {
                return false;
            }
            else {
                return pesquisar(palavra, raiz);
            }
        }

        private boolean pesquisar(String palavra, NoArvore raiz) {
            if (palavra.equals(raiz.palavra)) {
                return true;
            }
            else if (palavra.compareTo(raiz.palavra) < 0) {
                if (raiz.esquerda == null) {
                    return false;
                }
                else {
                    return pesquisar(palavra, raiz.esquerda);
                }
            }
            else if (palavra.compareTo(raiz.palavra) > 0) {
                if (raiz.direita == null) {
                    return false;
                }
                else {
                    return pesquisar(palavra, raiz.direita);
                }
            }

            return false;
        }

        public void incrementarAssassinatos(NoArvore raiz, String palavra) {
            if (raiz == null || raiz.palavra.equals(palavra)) {
                assert raiz != null;
                raiz.qtdAssasinatos++;
            }
            if (palavra.compareTo(raiz.palavra) > 0) {
                incrementarAssassinatos(raiz.direita, palavra);
            }
            if (palavra.compareTo(raiz.palavra) < 0) {
                incrementarAssassinatos(raiz.esquerda, palavra);
            }
        }
    }

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        ArvoreBinariaBusca assassinos = new ArvoreBinariaBusca();
        ArvoreBinariaBusca assassinados = new ArvoreBinariaBusca();


        assassinos.assassinados = assassinados;
        while (entrada.hasNextLine()) {
            String[] v = entrada.nextLine().split(" ");
            assassinados.adicionar(v[1]);
            assassinos.adicionar(v[0]);
        }
        entrada.close();

        System.out.println("HALL OF MURDERERS");
        assassinos.exibirEmOrdem();

    }
}

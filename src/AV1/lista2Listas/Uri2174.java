package AV1.lista2Listas;
// Questão 1: 2174 - Coleção de Pomekon

import java.util.Scanner;

public class Uri2174 {
    public static class No {
        String pokemon;
        No proximo;
        No anterior;

        public No(String pokemon) {
            this.pokemon = pokemon;
        }
    }

    public static class ListaDuplamenteEncadeada {
        No primeiro;
        No ultimo;
        int tamanho;


        public ListaDuplamenteEncadeada() {
            this.primeiro = null;
            this.ultimo = null;
            this.tamanho = 0;
        }

        public boolean vazio() {
            return tamanho == 0;
        }

        public void adicionarComeco(String pokemon) {
            if (!verificarPokemon(pokemon)) {
                No novo = new No(pokemon);
                if (vazio()) {
                    ultimo = novo;
                } else {
                    primeiro.anterior = novo;
                }
                novo.proximo = primeiro;
                primeiro = novo;
                tamanho++;
            }
        }

        public boolean verificarPokemon(String pokemonRepetido) {
            No atual = primeiro;
            String verificacao;
            if (vazio()) {
                return false;
            } else {
                while (atual != null) {
                    verificacao = atual.pokemon;
                    atual = atual.proximo;
                    if (verificacao.equals(pokemonRepetido)) {
                        return true;
                    }
                }
            }
            return false;
        }

    }

    public static void main(String[] args) {
        ListaDuplamenteEncadeada lista = new ListaDuplamenteEncadeada();
        Scanner entrada = new Scanner(System.in);
        int qtdPomekon = Integer.parseInt(entrada.nextLine());
        for (int i = 0; i < qtdPomekon; i++) {
            lista.adicionarComeco(entrada.nextLine());
        }
        System.out.printf("Falta(m) %d pomekon(s).\n",(151 - lista.tamanho));
    }

}

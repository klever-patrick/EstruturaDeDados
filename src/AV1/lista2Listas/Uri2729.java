package AV1.lista2Listas;
// Questão 2: 2729 - Lista de Compras

import java.util.Scanner;

public class Uri2729 {
    public static class No {
        String item;
        No proximo;
        No anterior;

        public No(String item) {
            this.item = item;
            proximo = null;
            anterior = null;
        }
    }

    public static class Lista {
        No primeiro;
        No ultimo;
        int tamanho;

        public Lista() {
            this.primeiro = null;
            this.ultimo = null;
            this.tamanho = 0;
        }

        public void inserir(String item) {
            No novo= new No(item);
            novo.item = item;
            novo. proximo = null;

            if(!removerRepetidos(novo.item)) {
                if(primeiro == null) {
                    primeiro = novo;
                    ultimo = novo;
                    primeiro.anterior = null;
                    return;
                }
                else if (novo.item.compareTo(primeiro.item) < 0) {
                    novo.anterior = null;
                    primeiro.anterior = novo;
                    novo.proximo = primeiro;
                    primeiro = novo;
                    return;
                }
                else if (novo.item.compareTo(ultimo.item) > 0) {
                    novo.anterior = ultimo;
                    ultimo.proximo = novo;
                    ultimo = novo;
                    return;
                }

                No temporario = primeiro.proximo;
                while (temporario.item.compareTo(novo.item) < 0) {
                    temporario = temporario.proximo;
                }

                (temporario.anterior).proximo = novo;
                novo.anterior = temporario.anterior;
                temporario.anterior = novo;
                novo.proximo = temporario;

                tamanho++;
            }

        }

        public void esvaziarLista() {
            primeiro = null;
            ultimo = null;
            tamanho = 0;
        }

        public void exibir() {

            if(primeiro == null) {
                return;
            }

            No atual = primeiro;
            while (atual != null) {

                if(atual == ultimo) {
                    System.out.print(atual.item);
                } else {
                    System.out.print(atual.item + " ");
                }
                atual = atual.proximo;
            }
        }

        public boolean removerRepetidos(String item) {
            No atual = primeiro;
            String auxiliar;

            if (atual == null) {
                return false;
            } else {
                while (atual != null) {
                    auxiliar = atual.item;
                    atual = atual.proximo;
                    if (auxiliar.equals(item)) {
                        return true;
                    }
                }
            }
            return false;
        }

    }

    public static void main(String[] args) {

        Lista lista = new Lista();
        Scanner entrada = new Scanner(System.in);

        int qtdListas = entrada.nextInt();
        entrada.nextLine();

        String[] itens;

        for(int contador = 1; contador <= qtdListas; contador++) {

            itens = entrada.nextLine().split(" ");

            for (String item : itens) {
                lista.inserir(item);
            }
            lista.exibir();
            lista.esvaziarLista();
            System.out.println();
        }
        entrada.close();
    }
}

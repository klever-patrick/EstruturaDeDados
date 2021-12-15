package AV1.lista0FundamentosDeProgramacao;
// Questão 10: 1134 - Tipo de Combustível

import java.util.Scanner;

public class Uri1134 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int alcool = 0;
        int gasolina = 0;
        int diesel = 0;


        int codigo = entrada.nextInt();

        while (codigo != 4) {
            switch (codigo) {
                case 1 -> alcool++;
                case 2 -> gasolina++;
                case 3 -> diesel++;
            }
            codigo = entrada.nextInt();
        }

        System.out.println("MUITO OBRIGADO");
        System.out.println("Alcool: " + alcool);
        System.out.println("Gasolina: " + gasolina);
        System.out.println("Diesel: " + diesel);
    }
}

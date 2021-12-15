package AV1.lista0FundamentosDeProgramacao;
// Questão 14: 1156 - Sequência S II

public class Uri1156 {
    public static void main(String[] args) {
        double S = 1;
        double numerador;
        double i;
        for (numerador = 3, i = 2;  numerador <= 39; numerador+=2, i *= 2) S += numerador / i;
        System.out.printf("%.2f\n",S);
    }
}

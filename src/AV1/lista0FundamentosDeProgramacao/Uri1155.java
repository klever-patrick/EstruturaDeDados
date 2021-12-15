package AV1.lista0FundamentosDeProgramacao;
// Questão 13: 1155 - Sequência S

public class Uri1155 {
    public static void main(String[] args) {
        double s;
        double S = 0;
        for (double i = 1; i <= 100; i++) {
            s = 1 / i;
            S += s;
        }
        System.out.printf("%.2f\n", S);
    }
}

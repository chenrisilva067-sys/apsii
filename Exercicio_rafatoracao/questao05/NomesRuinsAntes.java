package questao05;

/**
 * ANTES: funciona, mas ninguém entende o que doIt(), process(), a, x1 e temp fazem.
 */
public class NomesRuinsAntes {

    public double doIt(double a, double x1) {
        double temp = a * x1;
        return temp;
    }

    public double process(double a) {
        double temp = doIt(a, 0.18);
        return a + temp;
    }
}

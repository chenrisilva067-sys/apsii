package Exercicio4;

public class Triangulo implements FiguraGeometrica {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double calculaArea() {
        return (this.base * this.altura) / 2;
    }

    public String getNomeFigura() {
        return "Triângulo";
    }

    @Override
    public String toString() {
        return getNomeFigura() + " [base=" + base + ", altura=" + altura + ", área=" + calculaArea() + "]";
    }
}
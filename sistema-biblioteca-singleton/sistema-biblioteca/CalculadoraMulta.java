/**
 * Abstração para o cálculo de multa por atraso.
 *
 * Permite criar novas regras de multa (ex.: multa progressiva, isenção para
 * alunos) sem alterar a classe Biblioteca (Princípio Aberto/Fechado).
 */
public interface CalculadoraMulta {
    double calcular(long diasDeAtraso);
}

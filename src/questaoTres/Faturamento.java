package questaoTres;

public class Faturamento {
    private int dia;
    private double valor;

    public Faturamento(int dia, double valor) {
        this.dia = dia;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}

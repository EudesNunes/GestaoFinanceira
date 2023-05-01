import java.time.LocalDate;

public class Ganho {
    private TipoGanho tipodeGanho;
    private LocalDate data;
    private double valor;

    public Ganho(TipoGanho tipodeGanho, LocalDate data, double valor) {
        this.tipodeGanho = tipodeGanho;
        this.data = data;
        this.valor = valor;
    }

    public TipoGanho getTipodeGanho() {
        return tipodeGanho;
    }

    public LocalDate getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }
}

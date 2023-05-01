import java.time.LocalDate;

public class Gasto {
    private TipoGasto tipodeGasto;
    private LocalDate data;
    private double valor;
    private  FormaPagamento formaPag;

    public Gasto(TipoGasto tipodeGasto, LocalDate data, double valor, FormaPagamento formaPag) {
        this.tipodeGasto = tipodeGasto;
        this.data = data;
        this.valor = valor;
        this.formaPag = formaPag;
    }

    public TipoGasto getTipodeGasto() {
        return tipodeGasto;
    }

    public LocalDate getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public FormaPagamento getFormaPag() {
        return formaPag;
    }
}

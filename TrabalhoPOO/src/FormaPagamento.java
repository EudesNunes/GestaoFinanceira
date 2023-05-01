public enum FormaPagamento {
    CREDITO(1,"CREDITO"),
    DEBITO(2,"DEBITO"),
    PIX(3,"PIX"),
    CHEQUE(4,"CHEQUE"),
    BOLETO(5,"BOLETO");

    private final int valor;
    private final String descricao;

    FormaPagamento(int valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
    public static FormaPagamento getByNumero(int numero) {
        for (FormaPagamento forma : FormaPagamento.values()) {
            if (forma.valor == numero) {
                return forma;
            }
        }
        return null;
    }
}

public enum TipoGasto {
    ALIMENTACAO(1,"ALIMENTACAO"),
    TRANSPORTE(2,"TRANSPORTE"),
    SAUDE(3,"SAUDE"),
    IMPOSTO(4,"IMPOSTO"),
    HABITACAO(5,"HABITACAO"),
    ENTRETENIMENTO(6,"ENTRETENIMENTO");

    private final int valor;
    private final String descricao;

    TipoGasto(int valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
    public static TipoGasto getByNumero(int numero) {
        for (TipoGasto tipo : TipoGasto.values()) {
            if (tipo.valor == numero) {
                return tipo;
            }
        }
        return null;
    }
}

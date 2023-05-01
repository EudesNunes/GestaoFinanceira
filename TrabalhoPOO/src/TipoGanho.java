public enum TipoGanho {
    SALARIO(1,"SALARIO"),
    FREELANCER(2,"FREELANCER"),
    DIVIDENDOS(3,"DIVIDENDOS");

    private final int valor;
    private final String descricao;

    TipoGanho(int valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }
    public static TipoGanho getByNumero(int numero) {
        for (TipoGanho tipo : TipoGanho.values()) {
            if (tipo.valor == numero) {
                return tipo;
            }
        }
        return null;
    }

    public int getValor() {
        return valor;
    }

    public String getDescricao() {
        return descricao;
    }
}

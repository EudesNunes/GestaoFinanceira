import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Gestao {
    private List<Ganho>  ganhos;
    private  List<Gasto> gastos;

    public Gestao() {
        this.ganhos = new ArrayList<>();
        this.gastos = new ArrayList<>();
    }


    //region Geral
    public double calcularSaldoTotal() {
        return calcularGanhosTotal() - calcularGastosTotal();
    }

    //endregion


    //region Ganhos
    public List<Ganho> getGanhos() {
        return ganhos;
    }
    public void adicionarGanho(Ganho ganho) {
        ganhos.add(ganho);
    }

    public double calcularGanhosTotal() {
        double total = 0.0;
        for (Ganho ganho : ganhos) {
            total += ganho.getValor();
        }
        return total;
    }
    public List<Ganho> gerarRelatorioGanhosTipo(int ano, int mes, TipoGanho tipo) {
        List<Ganho> ganhomes = new ArrayList<>();
        for (Ganho ganho : ganhos) {
            LocalDate dataganho = ganho.getData();
            if(dataganho.getYear() == ano && dataganho.getMonthValue() == mes && ganho.getTipodeGanho() == tipo){
                ganhomes.add(ganho);
            }
        }
        return ganhomes;
    }
    public List<Ganho> gerarRelatorioGanhosTipo(int ano, int mes) {
        List<Ganho> ganhomes = new ArrayList<>();
        for (Ganho ganho : ganhos) {
            LocalDate dataganho = ganho.getData();
            if(dataganho.getYear() == ano && dataganho.getMonthValue() == mes){
                ganhomes.add(ganho);
            }
        }
        return ganhomes;
    }
    public double SomaGanhosEspecificos(List<Ganho> valores){
        double total = 0.0;
        for (Ganho ganho : valores) {
            total += ganho.getValor();
        }
        return total;
    };
    //endregion


    //region Gastos
    public List<Gasto> getGastos() {
        return gastos;
    }
    public void adicionarGasto(Gasto gasto) {
        gastos.add(gasto);
    }

    public double calcularGastosTotal() {
        double total = 0.0;
        for (Gasto gasto : gastos) {
            total += gasto.getValor();
        }
        return total;
    }
    public List<Gasto> gerarRelatorioGastoTipo(int ano, int mes, TipoGasto tipo) {
        List<Gasto> gastomes = new ArrayList<>();
        for (Gasto gasto : gastos) {
            LocalDate datagasto = gasto.getData();
            if(datagasto.getYear() == ano && datagasto.getMonthValue() == mes && gasto.getTipodeGasto() == tipo){
                gastomes.add(gasto);
            }
        }
        return gastomes;
    }
    public List<Gasto> gerarRelatorioGasto(int ano, int mes) {
        List<Gasto> gastomes = new ArrayList<>();
        for (Gasto gasto : gastos) {
            LocalDate datagasto = gasto.getData();
            if(datagasto.getYear() == ano && datagasto.getMonthValue() == mes){
                gastomes.add(gasto);
            }
        }
        return gastomes;
    }
    public double SomaGastoEspecificos(List<Gasto> valores){
        double total = 0.0;
        for (Gasto gasto : valores) {
            total += gasto.getValor();
        }
        return total;
    };
    //endregion

}

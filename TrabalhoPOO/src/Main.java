import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gestao gestao = new Gestao();
        boolean continuar = true;


        System.out.println("Bem-vindo !");

        while (continuar){
            //region inicio
            System.out.println("Selecione a opção desejada:");
            System.out.println("1 - Registrar ganhos mensais");
            System.out.println("2 - Registrar gastos mensais");
            System.out.println("3 - Relatório com todos os ganhos do mês agrupados pelo tipo de ganho");
            System.out.println("4 - Relatório com todos os gastos do mês agrupados pelo tipo de gasto");
            System.out.println("5 - Relatório geral");
            System.out.println("6 - Relatório total de gastos e ganhos por mês");
            System.out.println("7 - Sair");

            var digito = scanner.nextInt();
            System.out.println("----------------------------");
            //endregion

            switch (digito) {
                case 1 -> {
                    //region Ganhos mensais
                    boolean continuarGanho = true;
                    while (continuarGanho) {
                        System.out.println("Ganhos mensais");

                        System.out.println("Escolha o tipo de ganho:");
                        for (TipoGanho value : TipoGanho.values()) {
                            System.out.printf("%d - %s%n", value.getValor(), value.getDescricao());
                        }
                        TipoGanho tipo = TipoGanho.getByNumero(scanner.nextInt());
                        try {
                        LocalDate data = Utils.SolicitarData();

                        System.out.println("Digite o valor do ganho:");
                        double valorGanho = scanner.nextDouble();

                        gestao.adicionarGanho(new Ganho(tipo, data, valorGanho));
                        } catch (Exception e) {
                            System.out.println("Erro: " + e.getMessage());
                        }

                        int escolha = Utils.ContinuarSair();
                        if (escolha == 2) {
                            continuarGanho = false;
                        } else if (escolha == 3) {
                            continuarGanho = false;
                            continuar = false;
                            System.out.println("Saindo...");
                        }
                    }
                    //endregion

                }
                case 2 -> {
                    //region Gastos mensais
                    boolean continuarGastos = true;
                    while (continuarGastos) {
                        System.out.println("Gastos mensais");

                        System.out.println("Digite qual o tipo de Gasto");
                        for (TipoGasto value : TipoGasto.values()) {
                            System.out.printf("%d - %s%n", value.getValor(), value.getDescricao());
                        }
                        TipoGasto tipo = TipoGasto.getByNumero(scanner.nextInt());

                        try {
                            LocalDate data = Utils.SolicitarData();

                            System.out.println("Digite o valor:");
                            double valorGasto = scanner.nextDouble();

                            System.out.println("Digite qual a forma de pagamento");
                            for (FormaPagamento value : FormaPagamento.values()) {
                                System.out.printf("%d - %s%n", value.getValor(), value.getDescricao());
                            }
                            FormaPagamento forma = FormaPagamento.getByNumero(scanner.nextInt());

                            gestao.adicionarGasto(new Gasto(tipo, data, valorGasto, forma));
                        } catch (Exception e) {
                            System.out.println("Erro: " + e.getMessage());
                        }

                        int escolha = Utils.ContinuarSair();
                        if (escolha == 2) {
                            continuarGastos = false;
                        } else if (escolha == 3) {
                            continuarGastos = false;
                            continuar = false;
                            System.out.println("Saindo...");
                        }
                    }
                    //endregion

                }
                case 3 -> {
                    //region Relatório de Ganhos mensais
                    boolean continuarRelatorio = true;
                    while (continuarRelatorio) {
                        System.out.println("Relatório de Ganhos mensais");
                        System.out.println("Digite o ano (exemplo: 2023):");
                        int ano = scanner.nextInt();
                        System.out.println("Digite o mês (exemplo: 04):");
                        int mes = scanner.nextInt();
                        System.out.println("----------------------------");
                        System.out.printf("Seus ganhos do ano %d e mês %d%n", ano, mes);
                        List<Ganho> lista = new ArrayList<>();
                        for (TipoGanho value : TipoGanho.values()) {
                            List<Ganho> listaTipo = gestao.gerarRelatorioGanhosTipo(ano, mes, value);
                            if(!listaTipo.isEmpty()) {
                                lista.addAll(listaTipo);
                                System.out.println("----------------------------");
                                System.out.println(value.getDescricao());
                                for (Ganho gn : listaTipo) {

                                    System.out.printf("Data: %s | Valor: R$ %.2f | Tipo: %s%n", gn.getData(), gn.getValor(), gn.getTipodeGanho());
                                }
                                System.out.printf("Total de Ganhos: R$ %.2f%n", gestao.SomaGanhosEspecificos(listaTipo));
                                System.out.println("----------------------------");
                            }
                        }

                        System.out.printf("Total de Ganhos no mês: R$ %.2f%n", gestao.SomaGanhosEspecificos(lista));

                        int escolha = Utils.ContinuarSair();
                        if (escolha == 2) {
                            continuarRelatorio = false;
                        } else if (escolha == 3) {
                            continuarRelatorio = false;
                            continuar = false;
                            System.out.println("Saindo...");
                        }

                    }
                    //endregion
                }
                case 4 -> {
                    //region Relatório de Gasto mensais
                    boolean continuarRelatorioGasto = true;
                    while (continuarRelatorioGasto) {
                        System.out.println("Relatório de Gasto mensais");
                        System.out.println("Digite o ano (exemplo: 2023):");
                        int ano = scanner.nextInt();
                        System.out.println("Digite o mês (exemplo: 04):");
                        int mes = scanner.nextInt();
                        System.out.println("----------------------------");

                        System.out.printf("Seus gastos do ano %d e mês %d:%n", ano, mes);

                        List<Gasto> lista = new ArrayList<>();
                        for (TipoGasto value : TipoGasto.values()) {
                            List<Gasto> listaTipo = gestao.gerarRelatorioGastoTipo(ano, mes, value);
                            lista.addAll(listaTipo);
                            if(!listaTipo.isEmpty()) {

                                System.out.println("----------------------------");
                                System.out.println(value.getDescricao());
                                for (Gasto gt : listaTipo) {

                                    System.out.printf("Data: %s | Valor: R$ %.2f | Tipo: %s | Forma de Pagamento: %s%n",
                                            gt.getData(), gt.getValor(), gt.getTipodeGasto(), gt.getFormaPag());
                                }
                                System.out.printf("Total de gastos: R$ %.2f%n", gestao.SomaGastoEspecificos(listaTipo));
                                System.out.println("----------------------------");
                            }
                        }
                        System.out.printf("Total de gastos no mês: R$ %.2f%n", gestao.SomaGastoEspecificos(lista));

                        int escolha = Utils.ContinuarSair();
                        if (escolha == 2) {
                            continuarRelatorioGasto = false;
                        } else if (escolha == 3) {
                            continuarRelatorioGasto = false;
                            continuar = false;
                            System.out.println("Saindo...");
                        }

                    }
                    //endregion
                }
                case 5 -> {
                    //region Relatorio Geral
                    boolean continuarSaldo = true;
                    while (continuarSaldo) {
                        System.out.println("----------------------------");
                        System.out.println("Relatorio Geral");
                        System.out.println("Ganhos Gerais");
                        for (Ganho gn : gestao.getGanhos()) {
                            System.out.printf("Data: %s | Valor: R$ %.2f | Tipo: %s%n",
                                    gn.getData(), gn.getValor(), gn.getTipodeGanho());
                            System.out.println("----------");
                        }
                        System.out.println("----------------------------");
                        System.out.println("Gastos Gerais");
                        for (Gasto gt : gestao.getGastos()) {
                            System.out.printf("Data: %s | Valor: R$ %.2f | Tipo: %s | Forma de Pagamento: %s%n",
                                    gt.getData(), gt.getValor(), gt.getTipodeGasto(), gt.getFormaPag());
                            System.out.println("----------");
                        }
                        System.out.println("----------------------------");
                        System.out.printf("Ganhos Totais: R$ %.2f%n", gestao.calcularGanhosTotal());
                        System.out.printf("Gastos Totais: R$ %.2f%n", gestao.calcularGastosTotal());
                        System.out.printf("Saldo Total: R$ %.2f%n", gestao.calcularSaldoTotal());


                        int escolha = Utils.ContinuarSair();
                        if (escolha == 2) {
                            continuarSaldo = false;
                        } else if (escolha == 3) {
                            continuarSaldo = false;
                            continuar = false;
                            System.out.println("Saindo...");
                        }

                    }
                    //endregion
                }
                case 6 -> {
                    //region Relatorio Total
                    boolean continuarTotal = true;
                    while (continuarTotal) {
                        System.out.println("Relatório Total");
                        System.out.println("Digite o ano (exemplo: 2023):");
                        int ano = scanner.nextInt();
                        double totalganhoano = 0;
                        double totalgastoano = 0;
                        for (int mes = 1; mes <= 12; mes++) {
                            System.out.println("----------------------------");
                            System.out.printf("No mês %s%n", mes);

                            double totalmes = 0;
                            double totalganho = 0;
                            double totalgasto = 0;

                            // Somando ganhos do mês e do ano
                            for (Ganho gn : gestao.getGanhos()) {
                                if (gn.getData().getMonthValue() == mes && gn.getData().getYear() == ano) {
                                    totalganho += gn.getValor();
                                    totalmes += gn.getValor();

                                }
                            }
                            totalganhoano += totalganho;
                            System.out.printf("Valor Ganho R$ %.2f%n", totalganho);

                            // Subtraindo gastos do mês e somando gastos do ano
                            for (Gasto gt : gestao.getGastos()) {
                                if (gt.getData().getMonthValue() == mes && gt.getData().getYear() == ano) {
                                    totalmes -= gt.getValor();
                                    totalgasto += gt.getValor();
                                }
                            }
                            totalgastoano += totalgasto;
                            System.out.printf("Valor Gasto R$ %.2f%n", totalgasto);

                            System.out.println("--------");

                            System.out.printf("Subtotal R$ %.2f%n", totalmes);

                        }
                        System.out.println("----------------------------");


                        System.out.printf("Ganhos Totais: R$ %.2f%n", totalganhoano);
                        System.out.printf("Gastos Totais: R$ %.2f%n", totalgastoano);
                        System.out.printf("Saldo Total: R$ %.2f%n", totalganhoano - totalgastoano);
                        System.out.println("----------------------------");

                        int escolha = Utils.ContinuarSair();
                        if (escolha == 2) {
                            continuarTotal = false;
                        } else if (escolha == 3) {
                            continuarTotal = false;
                            continuar = false;
                            System.out.println("Saindo...");
                        }
                    }
                    //endregion
                }
                case 7 -> {
                    continuar = false;
                    System.out.println("Saindo!");
                }
                default -> System.out.println("Opção Inválida");
            }

        }


    }
}
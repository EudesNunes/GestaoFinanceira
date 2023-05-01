import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Utils {
    public static LocalDate SolicitarData() {
        Scanner scanner = new Scanner(System.in);
        boolean cont = true;
        while (cont) {
            try {
                System.out.println("Digite qual o Ano: XXXX");
                String ANO = scanner.next();
                System.out.println("Digite qual o mes: XX");
                String MES = scanner.next();
                System.out.println("Digite qual o dia; XX");
                String DIA = scanner.next();
                DateTimeFormatter parserData = DateTimeFormatter.ofPattern("uuuuMMdd");

                LocalDate data = LocalDate.parse(ANO + MES + DIA, parserData);
                cont = false;
                return data;
            } catch (Exception ex) {
                System.out.println(ex);
                System.out.println("Data invalida, tente novamente:");
                cont = true;
            }
        }
        return LocalDate.now();
    }


    public static int ContinuarSair(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite:");
        System.out.println("1 - Continuar?");
        System.out.println("2 - Outras opções:");
        System.out.println("3 - Sair:");
        var novoDigito = scanner.nextInt();
        switch (novoDigito) {
            case 1: return  1;
            case 2: return  2;
            default:
                return  3;
        }
    }

}
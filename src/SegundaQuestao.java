import java.util.Scanner;

public class SegundaQuestao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número para verificar: ");
        int numeroInformado = scanner.nextInt();

        int a = 0;
        int b = 1;
        boolean pertence = (numeroInformado == a || numeroInformado == b);
        while (b <= numeroInformado) {
            int proximo = a + b;
            a = b;
            b = proximo;

            if (b == numeroInformado) {
                pertence = true;
                break;
            }
        }

        if (pertence) {
            System.out.printf("O número %d pertence à sequência de Fibonacci.", numeroInformado);
        } else {
            System.out.printf("O número %d NÃO pertence à sequência de Fibonacci.", numeroInformado);
        }
        scanner.close();
    }
}

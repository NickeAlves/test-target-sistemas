import java.util.Scanner;

public class QuintaQuestao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string para converte-lá: ");
        String stringInserida = scanner.nextLine();

        String stringInvertida = "";

        for (int i = stringInserida.length() - 1; i >= 0; i--) {
            stringInvertida += stringInserida.charAt(i);
        }
        System.out.println("String invertida: " + stringInvertida);
        scanner.close();
    }
}

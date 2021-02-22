import java.util.Scanner;
import java.util.Arrays;

public class Shell {
    public static void main(String[] args) {
        System.out.println("Javython 1.0.0");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(">>> ");
            String input = scanner.nextLine();
            System.out.println(Arrays.toString(Lexer.analyze(input)));
        }
    }
}

import java.util.Scanner;
import java.util.Arrays;

public class Shell {
    public static void main(String[] args) {
        System.out.println("Javython 1.0.0");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(">>> ");
            String input = scanner.nextLine();
            if (input.equals("quit()")) break;
            
            Lexer lexer = new Lexer(input);
            TokenError te = lexer.makeTokens();
            Token[] tokens = te.getTokens();
            Error error = te.getError();
            
            if (error != null) System.out.println(error);
            else System.out.println(Arrays.toString(tokens));
        }
        scanner.close();
    }
}

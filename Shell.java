import java.util.Scanner;

public class Shell {
    public static void main(String[] args) {
        System.out.println("Javython 1.0.0");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(">>> ");
            String input = scanner.nextLine();
        }
    }
}

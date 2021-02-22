public class Lexer {
    public static String[] analyze(String input) {
        String[] tokens = input.split("[*-/]");
        return tokens;
    }
}

import java.util.ArrayList;

public class Lexer {
    public static ArrayList<String> analyze(String input) {
        final char[] MATHOPS = {'+', '-', '*', '/'};
        ArrayList<String> tokens = new ArrayList<String>();
        String curr = "";
        boolean foundOp = false;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            for (int op = 0; op < MATHOPS.length; op++) {
                if (c == MATHOPS[op]) {
                    tokens.add(curr);
                    tokens.add("" + c);
                    curr = "";
                    foundOp = true;
                    break;
                }
            }

            if (c == ' ') continue;

            if (!foundOp) curr += c;
            foundOp = false;
        }

        tokens.add(curr);
        return tokens;
    }
}

import java.util.ArrayList;

public class Lexer {
    private final String TT_INT    = "INT";
    private final String TT_FLOAT  = "FLOAT";
    private final String TT_PLUS   = "PLUS";
    private final String TT_MINUS  = "MINUS";
    private final String TT_MUL    = "MUL";
    private final String TT_DIV    = "DIV";
    private final String TT_LPAREN = "LPAREN";
    private final String TT_RPAREN = "RPAREN";

    private String text;
    private int pos;
    private char currentChar;

    public Lexer(String text) {
        this.text = text;
        this.pos = -1;
        this.currentChar = 0;
        advance();
    }

    private void advance() {
        pos++;
        if (pos < text.length()) currentChar = text.charAt(pos);
        else currentChar = 0;
    }

    public TokenError makeTokens() {
        ArrayList<Token> tokensList = new ArrayList<Token>();
        while (currentChar != 0) {
            if (currentChar == ' ' || currentChar == '\t') advance();
            else if (Character.isDigit(currentChar) || currentChar == '.') {
                tokensList.add(makeNumber());
            } else if (currentChar == '+') {
                tokensList.add(new Token(TT_PLUS));
                advance();
            } else if (currentChar == '-') {
                tokensList.add(new Token(TT_MINUS));
                advance();
            } else if (currentChar == '*') {
                tokensList.add(new Token(TT_MUL));
                advance();
            } else if (currentChar == '/') {
                tokensList.add(new Token(TT_DIV));
                advance();
            } else {
                String c = "'" + currentChar + "'";
                this.advance();
                return new TokenError(new Token[0], new IllegalCharacterError(c));
            }
        }

        Token[] tokens = new Token[tokensList.size()];
        for (int i = 0; i < tokensList.size(); i++) {
            tokens[i] = tokensList.get(i);
        }        
        
        return new TokenError(tokens, null);
    }

    private Token makeNumber() {
        String numString = "";
        int dots = 0;

        while (currentChar != 0 && (Character.isDigit(currentChar) || currentChar == '.')) {
            if (currentChar == '.') {
                if (dots >= 1) break;
                dots++;
                numString += '.';
            } else {
                numString += currentChar;
            }
            advance();
        }

        if (dots == 0) return new Token(TT_INT, Integer.parseInt(numString));
        else return new Token(TT_FLOAT, Double.parseDouble(numString));
    }
}

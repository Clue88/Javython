public class TokenError {
    private Token[] tokens;
    private Error error;

    public TokenError(Token[] tokens, Error error) {
        this.tokens = tokens;
        this.error = error;
    }

    public Token[] getTokens() {
        return tokens;
    }

    public Error getError() {
        return error;
    }
}

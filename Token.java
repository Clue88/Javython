public class Token {
    private String type;
    private Object value;

    public Token(String type) {
        this.type = type;
        this.value = null;
    }

    public Token(String type, Object value) {
        this.type = type;
        this.value = value;
    }

    public String toString() {
        if (this.value != null) return type + ":" + value;
        else return type;
    }
}

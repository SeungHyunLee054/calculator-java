package type;

public enum Operator {
    PLUS("+"), Minus("-"), MULTIPLE("*"), DIVIDE("/"), MOD("%");

    private final String mathSymbol;

    Operator(String mathSymbol) {
        this.mathSymbol = mathSymbol;
    }

    public String getMathSymbol() {
        return mathSymbol;
    }

    public static Operator fromMathSymbol(String mathSymbol) {
        for (Operator op : Operator.values()) {
            if (op.getMathSymbol().equals(mathSymbol)) {
                return op;
            }
        }

        throw new IllegalArgumentException();
    }
}

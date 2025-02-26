package type;

public enum Operator {
    PLUS("+"), MINUS("-"), MULTIPLE("*"), DIVIDE("/"), MODULO("%"),
    EXPONENT("^"), LOG("log");

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

        throw new IllegalArgumentException("연산자를 잘못 입력하였습니다.");
    }
}

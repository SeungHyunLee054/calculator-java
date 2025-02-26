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

    // 입력받은 연산자가 enum에 정의된 연산자와 일치하는지 확인하는 메서드, 일치하지 않다면 예외 처리
    public static Operator fromMathSymbol(String mathSymbol) {
        for (Operator op : Operator.values()) {
            if (op.getMathSymbol().equals(mathSymbol)) {
                return op;
            }
        }

        throw new IllegalArgumentException("연산자를 잘못 입력하였습니다.");
    }
}

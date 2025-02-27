package type;

import calculator.function.*;

public enum OperatorFuncDiv {
    PLUS("+", new Addiction<>()), MINUS("-", new Subtraction<>()),
    MULTIPLE("*", new Multiplication<>()), DIVIDE("/", new Division<>()),
    MODULO("%", new Modulo<>()), EXPONENT("^", new Exponentiation<>()),
    LOG("log", new Logarithm<>()),
    ;

    private final String mathSymbol;
    private final Operation<? extends Number> operation;

    OperatorFuncDiv(String mathSymbol, Operation<? extends Number> operation) {
        this.mathSymbol = mathSymbol;
        this.operation = operation;
    }

    // 입력받은 연산자가 enum에 정의된 연산자와 일치하는지 확인하는 메서드, 일치하지 않다면 예외 처리
    public static OperatorFuncDiv fromMathSymbol(String mathSymbol) {
        for (OperatorFuncDiv op : OperatorFuncDiv.values()) {
            if (op.getMathSymbol().equals(mathSymbol)) {
                return op;
            }
        }

        throw new IllegalArgumentException("연산자를 잘못 입력하였습니다.");
    }

    public Operation<? extends Number> getOperation() {
        return operation;
    }

    public String getMathSymbol() {
        return mathSymbol;
    }
}


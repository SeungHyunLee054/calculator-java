import calculator.Calculator;
import io.InputOutputValue;
import parsing.Parsing;
import type.Operator;

public class Main {
    public static void main(String[] args) {
        Calculator<Number> calculator = new Calculator<>();
        InputOutputValue ioVal = new InputOutputValue();
        System.out.println("exit 입력 시 종료");

        do {
            // 정수 또는 실수 값을 scan
            InputOutputValue value = ioVal.scanVariable();
            if (value.isFlag()) {
                break;
            }

            // 연산자 값을 scan
            InputOutputValue operator = ioVal.scanOperator();
            if (operator.isFlag()) {
                break;
            }

            Operator op;
            try {
                op = Operator.fromMathSymbol(operator.getOperator());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            try {
                Number numX = Parsing.parseNumber(value.getX());
                Number numY = Parsing.parseNumber(value.getY());
                calculator.setValue(numX, numY, op);
                Number result = calculator.calculate();

                System.out.println("result = " + result);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                continue;
            }

            try {
                Number largestResult = calculator.getLargestResult();
                System.out.println("largestResult = " + largestResult);
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }

        } while (true);

        ioVal.closeScanner();
    }
}

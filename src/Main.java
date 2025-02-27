import calculator.Calculator;
import io.InputValue;
import parsing.Parsing;
import type.Operator;

public class Main {
    // 기능 분리를 사용하지 않은 실행
    public static void main(String[] args) {
        Calculator<Number> calculator = new Calculator<>();
        InputValue inputVal = new InputValue();
        System.out.println("exit 입력 시 종료");

        do {
            // 정수 또는 실수 값을 scan
            InputValue value;
            try {
                value = inputVal.scanVariable();
                if (value.isExitFlag()) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                continue;
            }

            // 연산자 값을 scan
            InputValue operator = inputVal.scanOperator();
            if (operator.isExitFlag()) {
                break;
            }

            // 입력받은 연산자가 enum에서 정의한 연산자와 같은지 확인 및 enum class 반환
            Operator op;
            try {
                op = Operator.fromMathSymbol(operator.getOperator());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            // 계산 및 결과 값 반환
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

            // 계산된 결과값 중 가장 큰 값 반환
            try {
                Number largestResult = calculator.getLargestResult();
                System.out.println("largestResult = " + largestResult);
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }

        } while (true);

        inputVal.closeScanner();
    }
}

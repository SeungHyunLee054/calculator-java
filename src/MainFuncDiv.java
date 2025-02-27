import calculator.CalculatorFuncDiv;
import io.InputValue;
import parsing.Parsing;
import type.OperatorFuncDiv;

public class MainFuncDiv {
    public static void main(String[] args) {
        CalculatorFuncDiv<Number> calculator = new CalculatorFuncDiv<>();
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
            OperatorFuncDiv op;
            try {
                op = OperatorFuncDiv.fromMathSymbol(operator.getOperator());
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


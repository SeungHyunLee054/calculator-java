import calculator.Calculator;
import parsing.Parsing;
import type.Operator;

import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String EXIT = "exit";
        Scanner scanner = new Scanner(System.in);
        Calculator<Number> calculator = new Calculator<>();
        System.out.println("exit 입력 시 종료");

        do {
            System.out.print("첫 번째 정수또는 실수 값을 입력해 주세요 : ");
            String x = scanner.next();
            if (EXIT.equals(x)) {
                System.out.println("계산기를 종료합니다.");
                break;
            }
            System.out.print("두 번째 정수또는 실수 값을 입력해 주세요 : ");
            String y = scanner.next();
            if (EXIT.equals(y)) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

            System.out.print("연산자를 입력해 주세요 : ");
            String operator = scanner.next();

            if (EXIT.equals(operator)) {
                System.out.println("계산기를 종료합니다.");
                break;
            }

            Operator op;
            try {
                op = Operator.fromMathSymbol(operator);
            } catch (Exception e) {
                System.out.println("연산자를 잘못 입력하였습니다.");
                continue;
            }

            try {
                Number numX = Parsing.parseNumber(x);
                Number numY = Parsing.parseNumber(y);
                calculator.setValue(numX, numY, op);
                Number result = calculator.calculate();

                System.out.println("result = " + result);
            } catch (Exception e) {
                System.out.println("0으로 나눌 수 없습니다.");
                continue;
            }

            System.out.println("가장 큰 값 : " + calculator.getResultList().stream()
                    .max(Comparator.comparingDouble(Number::doubleValue))
                    .orElseGet(() -> Double.NaN));
        } while (true);

        scanner.close();
    }
}

package io;

import java.util.Scanner;

public class InputOutputValue {
    private final Scanner scanner = new Scanner(System.in);
    private final String EXIT = "exit";
    private String x;
    private String y;
    private String operator;
    private boolean exitFlag;

    public InputOutputValue() {
    }

    public InputOutputValue(String x, String y, boolean exitFlag) {
        this.x = x;
        this.y = y;
        this.exitFlag = exitFlag;
    }

    public InputOutputValue(String operator, boolean exitFlag) {
        this.operator = operator;
        this.exitFlag = exitFlag;
    }

    public InputOutputValue scanVariable() {
        System.out.print("첫 번째 정수 또는 실수 값을 입력해 주세요 : ");
        x = scanner.next();

        // 종료 키워드가 입력되었는지 확인
        if (isExit(x)) {
            return new InputOutputValue(null, null, true);
        }

        // 숫자가 입력되었는지 확인
        validateNumber(x);

        System.out.print("두 번째 정수 또는 실수 값을 입력해 주세요 : ");
        y = scanner.next();

        // 종료 키워드가 입력되었는지 확인
        if (isExit(y)) {
            return new InputOutputValue(x, null, true);
        }

        // 숫자가 입력되었는지 확인
        validateNumber(y);

        return new InputOutputValue(x, y, false);
    }

    public InputOutputValue scanOperator() {
        System.out.print("연산자를 입력해 주세요(+, -, *, /, %, ^, log) : ");
        operator = scanner.next();

        // 종료 키워드가 입력되었는지 확인
        if (isExit(operator)) {
            return new InputOutputValue(null, true);
        }

        return new InputOutputValue(operator, false);
    }

    public void closeScanner() {
        scanner.close();
    }

    public String getX() {
        return x;
    }

    public String getY() {
        return y;
    }

    public String getOperator() {
        return operator;
    }

    public boolean isExitFlag() {
        return exitFlag;
    }

    private void validateNumber(String str) {
        if (!str.chars().allMatch(Character::isDigit)) {
            throw new NumberFormatException("숫자를 입력해 주세요.");
        }
    }

    private boolean isExit(String str) {
        if (EXIT.equals(str)) {
            System.out.println("계산기를 종료합니다.");
            return true;
        }

        return false;
    }

}

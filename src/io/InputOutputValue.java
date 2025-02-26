package io;

import java.util.Scanner;

public class InputOutputValue {
    private final Scanner scanner = new Scanner(System.in);
    private final String EXIT = "exit";
    private String x;
    private String y;
    private String operator;
    private boolean flag;

    public InputOutputValue() {
    }

    public InputOutputValue(String x, String y, boolean flag) {
        this.x = x;
        this.y = y;
        this.flag = flag;
    }

    public InputOutputValue(String operator, boolean flag) {
        this.operator = operator;
        this.flag = flag;
    }

    public InputOutputValue scanVariable() {
        System.out.print("첫 번째 정수 또는 실수 값을 입력해 주세요 : ");
        x = scanner.next();
        if (isExit(x)) {
            return new InputOutputValue(null, null, true);
        }

        System.out.print("두 번째 정수 또는 실수 값을 입력해 주세요 : ");
        y = scanner.next();
        if (isExit(y)) {
            return new InputOutputValue(x, null, true);
        }

        return new InputOutputValue(x, y, false);
    }

    public InputOutputValue scanOperator() {
        System.out.print("연산자를 입력해 주세요(+, -, *, /, %, ^, log) : ");
        operator = scanner.next();
        if (isExit(operator)) {
            return new InputOutputValue(null, true);
        }

        return new InputOutputValue(operator, false);
    }

    public void closeScanner() {
        scanner.close();
    }

    private boolean isExit(String str) {
        if (EXIT.equals(str)) {
            System.out.println("계산기를 종료합니다.");
            return true;
        }

        return false;
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

    public boolean isFlag() {
        return flag;
    }
}

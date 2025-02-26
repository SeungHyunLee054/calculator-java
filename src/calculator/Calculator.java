package calculator;


import type.Operator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Calculator<T extends Number> {
    private T x;
    private T y;
    private Operator operator;
    private List<T> resultList = new ArrayList<>();

    public Calculator() {
    }

    public T calculate() {
        double doubleX = x.doubleValue();
        double doubleY = y.doubleValue();

        double result = switch (operator) {
            case PLUS -> doubleX + doubleY;
            case MINUS -> doubleX - doubleY;
            case MULTIPLE -> doubleX * doubleY;
            case DIVIDE -> {
                if (doubleY == 0) {
                    throw new ArithmeticException("분모가 0이 될 수 없습니다.");
                }
                yield doubleX / doubleY;
            }
            case MOD -> {
                if (doubleY == 0) {
                    throw new ArithmeticException("분모가 0이 될 수 없습니다.");
                }
                yield doubleX % doubleY;
            }
            case EXPONENT -> Math.pow(doubleX, doubleY);
            case LOG -> {
                if (doubleX == 0 || doubleY == 0) {
                    throw new ArithmeticException("0의 로그값은 정의되지 않습니다.");
                }
                yield Math.log(doubleX) / Math.log(doubleY);
            }
        };

        T genericResult = (T) Double.valueOf(result);
        resultList.add(genericResult);
        return genericResult;
    }

    public T getLargestResult() {
        return resultList.stream()
                .max(Comparator.comparingDouble(Number::doubleValue))
                .orElseThrow(() -> new NullPointerException("저장된 결과값이 없습니다."));
    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public T removeFirstElement() {
        return this.resultList.remove(0);
    }

    public void setValue(T x, T y, Operator operator) {
        this.x = x;
        this.y = y;
        this.operator = operator;
    }
}

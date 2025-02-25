package calculator;


import type.Operator;

import java.util.ArrayList;
import java.util.List;

public class Calculator<T extends Number> {
    private T x;
    private T y;
    private Operator operator;
    private List<Number> resultList = new ArrayList<>();

    public Calculator() {
    }

    public Number calculate() {
        boolean isInteger = (x instanceof Integer && y instanceof Integer);
        double doubleX = x.doubleValue();
        double doubleY = y.doubleValue();

        double result = switch (operator) {
            case PLUS -> doubleX + doubleY;
            case Minus -> doubleX - doubleY;
            case MULTIPLE -> doubleX * doubleY;
            case DIVIDE -> {
                if (doubleY == 0) {
                    throw new ArithmeticException();
                }
                yield doubleX / doubleY;
            }
            case MOD -> {
                if (doubleY == 0) {
                    throw new ArithmeticException();
                }
                yield doubleX % doubleY;
            }
        };

        if (isInteger) {
            resultList.add((int) result);
            return (int) result;
        } else {
            resultList.add(result);
            return result;
        }
    }

    public List<Number> getResultList() {
        return resultList;
    }

    public void setResultList(List<Number> resultList) {
        this.resultList = resultList;
    }

    public void setValue(T x, T y, Operator operator) {
        this.x = x;
        this.y = y;
        this.operator = operator;
    }
}

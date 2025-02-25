package calculator;


import type.Operator;

import java.util.ArrayList;
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

        T genericResult = (T) Double.valueOf(result);
        resultList.add(genericResult);
        return genericResult;
    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    public void removeResultList(int index) {
        this.resultList.remove(index);
    }

    public void setValue(T x, T y, Operator operator) {
        this.x = x;
        this.y = y;
        this.operator = operator;
    }
}

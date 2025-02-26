package calculator;


import type.Operator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Genric으로 변수를 입력 받는데 숫자 값이 사용될 것이므로 Number를 extends하여 범위를 좁힘
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
                // 분모의 값이 0이라면 예외 처리
                if (doubleY == 0) {
                    throw new ArithmeticException("분모가 0이 될 수 없습니다.");
                }
                yield doubleX / doubleY;
            }
            case MODULO -> {
                // 분모의 값이 0이라면 예외 처리
                if (doubleY == 0) {
                    throw new ArithmeticException("분모가 0이 될 수 없습니다.");
                }
                yield doubleX % doubleY;
            }
            case EXPONENT -> Math.pow(doubleX, doubleY);
            case LOG -> {
                // log에 0값이 입력되었다면 예외 처리
                if (doubleX == 0 || doubleY == 0) {
                    throw new ArithmeticException("0의 로그값은 정의되지 않습니다.");
                }
                yield Math.log(doubleX) / Math.log(doubleY);
            }
        };

        // Generic type으로 반환하기 위해서 Wrapper class로 변환 후 강제 형변환
        T genericResult = (T) Double.valueOf(result);

        // 결과값 저장
        resultList.add(genericResult);
        return genericResult;
    }

    public T getLargestResult() {
        // 저장된 결과 값 중 가장 큰 값을 찾는 stream, 만약 값이 없다면 예외 처리
        return resultList.stream()
                .max(Comparator.comparingDouble(Number::doubleValue))
                .orElseThrow(() -> new NullPointerException("저장된 결과값이 없습니다."));
    }

    // 결과 값 리스트 게터
    public List<T> getResultList() {
        return resultList;
    }

    // 결과 값 리스트 세터
    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    // 저장된 결과 값 중 가장 먼저 입력된 값을 제거하는 메서드, 만약 값이 없다면 예외 처리
    public T removeFirstElement() {
        if (resultList.isEmpty()) {
            throw new NullPointerException("저장된 결과값이 없습니다.");
        }

        return this.resultList.remove(0);
    }

    public void setValue(T x, T y, Operator operator) {
        this.x = x;
        this.y = y;
        this.operator = operator;
    }
}

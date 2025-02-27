package calculator;

import calculator.function.Operation;
import type.OperatorFuncDiv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CalculatorFuncDiv<T extends Number> {
    private T x;
    private T y;
    private OperatorFuncDiv operator;
    private List<T> resultList = new ArrayList<>();


    public CalculatorFuncDiv() {
    }

    public T calculate() {
        // enum에 정의된 function 구현체 정보를 가져옴
        Operation<T> operation = (Operation<T>) operator.getOperation();

        // Functional interface를 통해 구현체 실행
        T result = operation.execute(x, y);

        resultList.add(result);
        return result;
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

    public void setValue(T x, T y, OperatorFuncDiv operator) {
        this.x = x;
        this.y = y;
        this.operator = operator;
    }
}

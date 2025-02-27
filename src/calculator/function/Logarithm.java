package calculator.function;

public class Logarithm<T extends Number> implements Operation<T> {
    @Override
    public T execute(T x, T y) {
        if (x.doubleValue() == 0 || y.doubleValue() == 0) {
            throw new ArithmeticException("0의 로그값은 정의되지 않습니다.");
        }
        double result = Math.log(x.doubleValue()) / Math.log(y.doubleValue());

        return (T) Double.valueOf(result);
    }
}

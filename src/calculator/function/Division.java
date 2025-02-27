package calculator.function;

public class Division<T extends Number> implements Operation<T> {
    @Override
    public T execute(Number x, Number y) {
        if (y.doubleValue() == 0) {
            throw new ArithmeticException("분모가 0이 될 수 없습니다.");
        }
        double result = x.doubleValue() / y.doubleValue();

        return (T) Double.valueOf(result);
    }
}

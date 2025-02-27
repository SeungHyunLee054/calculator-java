package calculator.function;

public class Multiplication<T extends Number> implements Operation<T> {
    @Override
    public T execute(T x, T y) {
        double result = x.doubleValue() * y.doubleValue();

        return (T) Double.valueOf(result);
    }
}

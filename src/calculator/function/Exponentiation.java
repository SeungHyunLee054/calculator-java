package calculator.function;

public class Exponentiation<T extends Number> implements Operation<T> {
    @Override
    public T execute(T x, T y) {
        double result = Math.pow(x.doubleValue(), y.doubleValue());

        return (T) Double.valueOf(result);
    }
}

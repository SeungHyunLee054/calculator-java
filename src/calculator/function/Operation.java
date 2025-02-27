package calculator.function;

@FunctionalInterface
public interface Operation<T extends Number> {
    T execute(T x, T y);
}

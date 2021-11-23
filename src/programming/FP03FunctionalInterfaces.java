package programming;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class FP03FunctionalInterfaces {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        IntPredicate isEvenPredicate = x -> 0 == x % 2;
        Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return 0 == x % 2;
            }
        };

        IntUnaryOperator squareFunction = x -> x * x;
        UnaryOperator<Integer> squareFunction2 = new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };

        IntConsumer soutConsumer = System.out::println;
        Consumer<Integer> soutConsumer2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer x) {
                System.out.println(x);
            }
        };

        numbers.stream().filter(isEvenPredicate2).map(squareFunction2).forEach(soutConsumer2);
    }

}

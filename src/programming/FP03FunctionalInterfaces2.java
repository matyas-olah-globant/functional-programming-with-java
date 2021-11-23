package programming;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP03FunctionalInterfaces2 {
    private static final Random GEN = new Random();

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        Predicate<Integer> isEvenPredicate = (Integer x) -> 0 == x % 2;
        Function<Integer, Integer> squareFunction = x -> x * x;
        Function<Integer, String> stringOutputFunction = x -> x + " ";
        Consumer<Integer> soutConsumer = x -> System.out.println(x);
        BinaryOperator<Integer> sumBinaryOperator = (x, y) -> x + y;

        // numbers.stream().filter(isEvenPredicate).map(squareFunction).forEach(soutConsumer);
        int sum = numbers.stream().reduce(0, sumBinaryOperator);
        // System.out.println(sum);

        //No input -> Return Something
        Supplier<Integer> randomIntegerSupplier = () -> {
            GEN.nextInt();
            return GEN.nextInt(1000);
        };
        // System.out.println(randomIntegerSupplier.get());

        UnaryOperator<Integer> unaryOperator = x -> 3 * x;
        // System.out.println(unaryOperator.apply(10));

        BiPredicate<Integer, String> biPredicate = (n, s) -> n < s.length();
        // System.out.println(biPredicate.test(10, "in28minutes"));

        BiFunction<Integer, String, String> biFunction = (n, s) -> n + " " + s;
        // System.out.println(biFunction.apply(15, "in28minutes"));

        BiConsumer<Integer, String> biConsumer = (n, s) -> {
            System.out.println(n);
            System.out.println(s);
        };
        // biConsumer.accept(25, "in28Minutes");

        IntBinaryOperator intBinaryOperator = (x, y) -> x + y;
        System.out.println(intBinaryOperator.applyAsInt(11, 14));

        /*
        //IntBinaryOperator
        //IntConsumer
        //IntFunction
        //IntPredicate
        //IntSupplier
        //IntToDoubleFunction
        //IntToLongFunction
        //IntUnaryOperator

        //Long, Double, Int
        */
    }

}

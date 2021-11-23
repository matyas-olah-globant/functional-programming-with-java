package programming;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class FP03BehaviorParameterization {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        // filterAndPrint(numbers, x -> 0 == x % 2);
        // filterAndPrint(numbers, x -> 0 != x % 2);
        filterAndPrint(numbers, x -> 0 == x % 3);

        UnaryOperator<Integer> mappingFunction = x -> x * x;
        List<Integer> squaredNumbers = mapAndCreateNewList(numbers, mappingFunction);
        List<Integer> cubedNumbers = mapAndCreateNewList(numbers, x -> x * x * x);
        List<Integer> doubledNumbers = mapAndCreateNewList(numbers, x -> x + x);
        System.out.println(doubledNumbers);
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream().filter(predicate).forEach(System.out::println);
    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers,
            UnaryOperator<Integer> mappingFunction) {
        return numbers.stream().map(mappingFunction).toList();
    }

}

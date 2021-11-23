package programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class FP03Exercises {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        // Exercise 12
        // BinaryOperator<Integer> sumBinaryOperator = Integer::sum;
        // BinaryOperator<Integer> sumBinaryOperator = (x , y) -> x + y;
        BinaryOperator<Integer> sumBinaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a + b;
            }
        };
        int sum = numbers.stream().reduce(0, sumBinaryOperator);
        System.out.println(sum + "\n");

        // Exercise 13
        List<Integer> squaredNumbers = mapAndCreateNewList(numbers, x -> x * x);
        System.out.println(squaredNumbers);
    }

    private static List<Integer> mapAndCreateNewList(List<Integer> numbers,
            UnaryOperator<Integer> mappingFunction) {
        return numbers.stream().map(mappingFunction).toList();
    }

}

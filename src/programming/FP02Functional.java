package programming;

import java.util.List;

public class FP02Functional {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        // int sum = addListFunctional(numbers);
        int sum = numbers.stream().reduce(0, (x, y) -> x + y * y);
        System.out.println(sum);

        List<Integer> squaredNumbers = squareList(numbers);
        System.out.println(squaredNumbers);
    }

    /*
    private static int sum(int aggregate, int nextNumber) {
        // System.out.println(aggregate + " " + nextNumber);
        return aggregate + nextNumber;
    }
    */

    private static int addListFunctional(List<Integer> numbers) {
        // Stream of number -> One result value
        // Combine them into one result => One Value
        // 0 and FP02Functional::sum
        return numbers.stream()
                //.parallel()
                //.reduce(0, FP02Functional::sum);
                //.reduce(0, (x, y) -> x + y);
                .reduce(0, Integer::sum);
    }

    private static List<Integer> squareList(List<Integer> numbers) {
        return numbers.stream().map(x -> x * x).toList();
    }

}

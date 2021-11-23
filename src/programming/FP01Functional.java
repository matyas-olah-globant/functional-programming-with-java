package programming;

import java.util.List;

public class FP01Functional {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        // printAllNumbersInListFunctional(numbers);
        // printEvenNumbersInListFunctional(numbers);
        printSquaresOfEvenNumbersInListFunctional(numbers);
    }

    /*
    private static void print(int number) {
        System.out.println(number);
    }

    private static boolean isEven(int number) {
        return 0 == number % 2;
    }
    */

    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        // What to do?
        numbers.forEach(System.out::println); // Method Reference
    }

    // number -> number % 2 == 0
    private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
        // What to do?
        numbers.stream() // Convert to Stream
                //.filter(FP01Functional::isEven) // Filter - Only Allow Even Numbers
                .filter(number -> 0 == number % 2) // Lambda Expression
                .forEach(System.out::println); // Method Reference
    }

    private static void printSquaresOfEvenNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream() // Convert to Stream
                .filter(number -> 0 == number % 2) // Lambda Expression
                .map(number -> number * number) // Mapping - x -> x * x
                .forEach(System.out::println); // Method Reference
    }

}

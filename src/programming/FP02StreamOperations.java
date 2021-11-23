package programming;

import java.util.Comparator;
import java.util.List;

public class FP02StreamOperations {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        List<Integer> squaredNumbers = numbers.stream().map(number -> number * number).toList();
        List<Integer> evenNumbersOnly = numbers.stream().filter(x -> x % 2 == 0).toList();
        int cubeSum = numbers.stream().reduce(0, (x, y) -> x * x + y * y);
        int greatest = numbers.stream().reduce(Integer.MIN_VALUE, (x, y) -> x > y ? x : y);

        // numbers.stream().distinct().sorted().forEach(System.out::println);

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS",
                "PCF", "Azure", "Docker", "Kubernetes");
        // courses.stream().sorted().forEach(System.out::println);
        // courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        // courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        courses.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
    }

}

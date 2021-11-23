package programming;

import java.util.List;

public class FP01Exercises {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        // Exercise 1
        numbers.stream().filter(n -> 0 != n % 2).forEach(System.out::println);
        System.out.println();

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS",
                "PCF", "Azure", "Docker", "Kubernetes");
        // Exercise 2
        courses.forEach(System.out::println);
        System.out.println();
        // Exercise 3
        courses.stream().filter(c -> c.contains("Spring")).forEach(System.out::println);
        System.out.println();
        // Exercise 4
        courses.stream().filter(c -> 4 <= c.length()).forEach(System.out::println);
        System.out.println();

        // Exercise 5
        numbers.stream().filter(n -> 0 != n % 2).map(n -> n * n * n).forEach(System.out::println);
        System.out.println();

        // Exercise 6
        courses.stream().map(c -> c + " " + c.length()).forEach(System.out::println);
        System.out.println();
    }

}

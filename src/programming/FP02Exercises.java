package programming;

import java.util.List;

public class FP02Exercises {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        // Exercise 7
        // int sum7 = numbers.stream().map(x -> x * x).reduce(0, Integer::sum);
        int sum7 = numbers.stream().reduce(0, (x, y) -> x + y * y);
        System.out.println(sum7 + "\n");
        // Exercise 8
        // int sum8 = numbers.stream().map(x -> x * x * x).reduce(0, Integer::sum);
        int sum8 = numbers.stream().reduce(0, (x, y) -> x + y * y * y);
        System.out.println(sum8 + "\n");
        // Exercise 9
        int sum9 = numbers.stream().filter(x -> 0 != x % 2).reduce(0, Integer::sum);
        System.out.println(sum9 + "\n");
        // Exercise 10
        List<Integer> evenNumbersOnly = numbers.stream().filter(x -> 0 == x % 2).toList();
        System.out.println(evenNumbersOnly + "\n");

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
        // Exercise 11
        List<Integer> courseTitleLengths = courses.stream().map(String::length).toList();
        System.out.println(courseTitleLengths);
    }

}

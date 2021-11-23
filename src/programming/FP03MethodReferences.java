package programming;

import java.util.List;
import java.util.function.Supplier;

public class FP03MethodReferences {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS",
                "PCF", "Azure", "Docker", "Kubernetes");

        courses.stream()
                //.map(str -> str.toUpperCase())
                .map(String::toUpperCase)
                .forEach(FP03MethodReferences::print);
        Supplier<String> supplier = String::new;
    }

    private static void print(String str) {
        System.out.println(str);
    }

}

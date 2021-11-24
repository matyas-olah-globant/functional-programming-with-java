package programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP04CustomClass {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
                new Course("Spring Boot", "Framework", 95, 18000),
                new Course("API", "Microservices", 97, 22000),
                new Course("Microservices", "Microservices", 96, 25000),
                new Course("FullStack", "FullStack", 91, 14000),
                new Course("AWS", "Cloud", 92, 21000),
                new Course("Azure", "Cloud", 99, 21000),
                new Course("Docker", "Cloud", 92, 20000),
                new Course("Kubernetes", "Cloud", 91, 20000));

        // allMatch, noneMatch, anyMatch
        Predicate<Course> reviewScoreGreaterThan95Predicate = course -> 95 < course.reviewScore();
        Predicate<Course> reviewScoreGreaterThan90Predicate = course -> 90 < course.reviewScore();
        Predicate<Course> reviewScoreLessThan90Predicate = course -> 90 > course.reviewScore();
        System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));
        System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));
        System.out.println(courses.stream().anyMatch(reviewScoreLessThan90Predicate));
        System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan95Predicate));

        Comparator<Course> comparingByNoOfStudentsIncreasing =
                Comparator.comparingInt(Course::noOfStudents);
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsIncreasing).toList());
        // [FullStack:14000:91, Spring Boot:18000:95, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, AWS:21000:92, Azure:21000:99, API:22000:97, Microservices:25000:96]

        Comparator<Course> comparingByNoOfStudentsDecreasing =
                Comparator.comparingInt(Course::noOfStudents).reversed();
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsDecreasing).toList());
        // [Microservices:25000:96, API:22000:97, AWS:21000:92, Azure:21000:99, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]

        Comparator<Course> comparingByNoOfStudentsAndNoOfReviews = Comparator
                .comparingInt(Course::noOfStudents)
                .thenComparingInt(Course::reviewScore)
                .reversed();
        System.out.println(courses.stream().sorted(comparingByNoOfStudentsAndNoOfReviews).toList());
        // [Microservices:25000:96, API:22000:97, Azure:21000:99, AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]

        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsAndNoOfReviews).limit(5).toList());
        // [Microservices:25000:96, API:22000:97, Azure:21000:99, AWS:21000:92, Spring:20000:98]

        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsAndNoOfReviews).skip(3).toList());
        // [AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95, FullStack:14000:91]

        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudentsAndNoOfReviews).skip(3).limit(5).toList());
        // [AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95]

        System.out.println(courses);
        // [Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96, FullStack:14000:91, AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91]
        System.out.println(courses.stream().takeWhile(c -> 95 <= c.reviewScore()).toList());
        // [Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96]
        System.out.println(courses.stream().dropWhile(c -> 95 <= c.reviewScore()).toList());
        // [FullStack:14000:91, AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91]

        System.out.println(courses.stream().max(comparingByNoOfStudentsAndNoOfReviews));
        // Optional[FullStack:14000:91]
        System.out.println(courses.stream().min(comparingByNoOfStudentsAndNoOfReviews));
        // Optional[Microservices:25000:96]

        System.out.println(courses.stream()
                .filter(reviewScoreLessThan90Predicate).min(comparingByNoOfStudentsAndNoOfReviews));
        // Optional.empty
        System.out.println(courses.stream()
                .filter(reviewScoreLessThan90Predicate).min(comparingByNoOfStudentsAndNoOfReviews)
                .orElse(new Course("Kubernetes", "Cloud", 91, 20000)));
        // Kubernetes:20000:91

        System.out.println(courses.stream().filter(reviewScoreLessThan90Predicate).findFirst());
        // Optional.empty
        System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate).findFirst());
        // Optional[Spring:20000:98]
        System.out.println(courses.stream().filter(reviewScoreGreaterThan95Predicate).findAny());
        // Optional[Spring:20000:98]

        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::noOfStudents).sum());
        // 88000
        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::noOfStudents)
                .average());
        // OptionalDouble[22000.0]
        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::noOfStudents).count());
        // 4
        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::noOfStudents).max());
        // OptionalInt[25000]
        System.out.println(courses.stream()
                .filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::noOfStudents).min());
        // OptionalInt[20000]

        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::category)));
        // {Cloud=[AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91],
        //  FullStack=[FullStack:14000:91],
        //  Microservices=[API:22000:97, Microservices:25000:96],
        //  Framework=[Spring:20000:98, Spring Boot:18000:95]}

        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::category, Collectors.counting())));
        // {Cloud=4, FullStack=1, Microservices=2, Framework=2}

        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::category,
                Collectors.maxBy(Comparator.comparing(Course::reviewScore)))));
        // {Cloud=Optional[Azure:21000:99], FullStack=Optional[FullStack:14000:91], Microservices=Optional[API:22000:97], Framework=Optional[Spring:20000:98]}

        System.out.println(courses.stream().collect(Collectors.groupingBy(Course::category,
                Collectors.mapping(Course::name, Collectors.toList()))));
        // {Cloud=[AWS, Azure, Docker, Kubernetes], FullStack=[FullStack], Microservices=[API, Microservices], Framework=[Spring, Spring Boot]}

        Predicate<Course> reviewScoreGreaterThan95Predicate2 =
                createPredicateWithCutoffReviewScore(95);
        Predicate<Course> reviewScoreGreaterThan90Predicate2 =
                createPredicateWithCutoffReviewScore(90);
    }

    private static Predicate<Course> createPredicateWithCutoffReviewScore(int cutoffReviewScore) {
        return course -> cutoffReviewScore < course.reviewScore();
    }

}

record Course(String name, String category, int reviewScore, int noOfStudents) {
    @Override
    public String toString() {
        return name + ":" + noOfStudents + ":" + reviewScore;
    }
}

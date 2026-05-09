import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) {
        List<Integer> oddNumbers = filterOddNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println("1. Odd numbers: " + oddNumbers);

        double average = findAverage(Arrays.asList(1.5, 2.5, 3.5, 4.5));
        System.out.println("2. Average value: " + average);

        List<String> sortedAlphabetically = sortStringsAlphabetically(
                Arrays.asList("Banana", "Apple", "Orange", "Mango"));
        System.out.println("3. Alphabetically sorted strings: " + sortedAlphabetically);

        int sumEven = sumOfEvenNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        System.out.println("4. Sum of even numbers: " + sumEven);

        long factorial = calculateFactorial(5);
        System.out.println("5. Factorial of 5: " + factorial);

        long[] multAndSum = multiplyAndSum(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("6. Multiplication: " + multAndSum[0] + ", Sum: " + multAndSum[1]);

        List<Integer> squares = squareOfNumbers(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println("7. Squares of numbers: " + squares);

        List<String> sortedByLength = sortStringsByLength(Arrays.asList("A", "Apple", "Banana", "Pie"));
        System.out.println("8. Strings sorted by length (ascending): " + sortedByLength);

        long wordCount = countWords("This is a test sentence to check word count");
        System.out.println("9. Number of words in the sentence: " + wordCount);

        String firstNonEmpty = findFirstNonEmptyString(Arrays.asList("", "   ", null, "Hello", "World"));
        System.out.println("10. First non-empty string: " + firstNonEmpty);

        boolean allStartWithCapital = checkAllStringsStartWithCapital(Arrays.asList("Apple", "Banana", "Cherry"));
        System.out.println(
                "11. Do all strings start with a capital letter (Apple, Banana, Cherry): " + allStartWithCapital);

        Integer secondLargest = findSecondLargest(Arrays.asList(10, 5, 20, 20, 15));
        System.out.println("12. Second largest number: " + secondLargest);

        Integer largestEven = findLargestEvenNumber(Arrays.asList(3, 7, 2, 8, 5, 10, 9));
        System.out.println("13. Largest even number: " + largestEven);
    }

    public static List<Integer> filterOddNumbers(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 != 0).collect(Collectors.toList());
    }

    public static double findAverage(List<Double> numbers) {
        return numbers.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public static List<String> sortStringsAlphabetically(List<String> strings) {
        return strings.stream().sorted().collect(Collectors.toList());
    }

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    public static long calculateFactorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Number must be non-negative");
        return LongStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b);
    }

    public static long[] multiplyAndSum(List<Integer> numbers) {
        long multiply = numbers.stream().mapToLong(Integer::longValue).reduce(1, (a, b) -> a * b);
        long sum = numbers.stream().mapToLong(Integer::longValue).sum();
        return new long[] { multiply, sum };
    }

    public static List<Integer> squareOfNumbers(List<Integer> numbers) {
        return numbers.stream().map(n -> n * n).collect(Collectors.toList());
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    public static long countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty())
            return 0;
        return Arrays.stream(sentence.trim().split("\\s+")).count();
    }

    public static String findFirstNonEmptyString(List<String> strings) {
        return strings.stream().filter(s -> s != null && !s.trim().isEmpty()).findFirst().orElse(null);
    }

    public static boolean checkAllStringsStartWithCapital(List<String> strings) {
        if (strings == null || strings.isEmpty())
            return false;
        return strings.stream().allMatch(s -> s != null && !s.isEmpty() && Character.isUpperCase(s.charAt(0)));
    }

    public static Integer findSecondLargest(List<Integer> numbers) {
        return numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
    }

    public static Integer findLargestEvenNumber(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).max(Integer::compareTo).orElse(null);
    }
}

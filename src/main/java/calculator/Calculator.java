package calculator;

import java.util.List;

public class Calculator {

    public static Integer sum(List<PositiveNumber> numbers) {
        return extractValues(numbers).stream().mapToInt(Number::intValue).sum();
    }

    private static List<Integer> extractValues(List<PositiveNumber> numbers) {
        return numbers.stream().map(PositiveNumber::getValue).toList();
    }
}

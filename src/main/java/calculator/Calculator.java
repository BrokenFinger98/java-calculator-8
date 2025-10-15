package calculator;

import java.util.List;

public class Calculator {

    public static Double sum(List<PositiveNumber> numbers) {
        return extractValues(numbers).stream().mapToDouble(Number::doubleValue).sum();
    }

    private static List<Number> extractValues(List<PositiveNumber> numbers) {
        return numbers.stream().map(PositiveNumber::getValue).toList();
    }
}

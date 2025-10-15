package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Printer.printStartSentence();
        final String input = Console.readLine();
        List<PositiveNumber> numbers = InputParser.parse(input);
        PositiveNumbers positiveNumbers = new PositiveNumbers(numbers);

        int sum = positiveNumbers.sum();
        Printer.printResultSentence(sum);
    }
}

package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println(Printer.startSentence());
        final String input = Console.readLine();
        List<PositiveNumber> numbers = InputParser.parse(input);
        PositiveNumbers positiveNumbers = new PositiveNumbers(numbers);

        int sum = positiveNumbers.sum();
        System.out.println(Printer.resultSentence(sum));
    }
}

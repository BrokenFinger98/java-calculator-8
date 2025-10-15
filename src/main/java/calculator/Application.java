package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Printer.printStartSentence();
        final String input = Console.readLine();
        List<PositiveNumber> numbers = InputParser.parse(input);
        Double sum = Calculator.sum(numbers);
        Printer.printResultSentence(sum);
        return;
    }
}

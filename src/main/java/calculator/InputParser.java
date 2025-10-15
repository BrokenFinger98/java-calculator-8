package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputParser {

    private static final String DEFAULT_DELIMITER1 = ",";
    private static final String DEFAULT_DELIMITER2 = ":";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    public static List<PositiveNumber> parse(String input) {
        if (isBlank(input)) {
            return List.of();
        }

        if (Character.isDigit(input.charAt(0))) {
            return defaultParse(input);
        }

        return customParse(input);
    }

    private static List<PositiveNumber> defaultParse(String input) {
        String[] strings = input.split(DEFAULT_DELIMITER1 + "|" + DEFAULT_DELIMITER2);
        return stringsToPositiveNumbers(strings, new ArrayList<>());
    }

    private static List<PositiveNumber> customParse(String input) {
        if (!input.startsWith(CUSTOM_DELIMITER_PREFIX) || !input.contains(CUSTOM_DELIMITER_SUFFIX)) {
            throw new IllegalArgumentException("Failed to parse input: " + input);
        }

        int index = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        String customDelimiter = input.substring(2, index);
        String[] strings = input.substring(index + 2).split(customDelimiter);
        return stringsToPositiveNumbers(strings, new ArrayList<>());
    }

    private static List<PositiveNumber> stringsToPositiveNumbers(String[] strings, List<PositiveNumber> numbers) {
        return Arrays.stream(strings).map(s -> new PositiveNumber(Integer.parseInt(s))).toList();
    }

    private static void isNumbers(String string) {
        for (char c : string.toCharArray()) {
            if (Character.isDigit(c)) {
                throw new IllegalArgumentException("Invalid string: " + string);
            }
        }
    }

    private static boolean isBlank(String string) {
        return string == null || string.isEmpty();
    }
}

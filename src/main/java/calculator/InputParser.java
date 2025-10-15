package calculator;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    private static final String DEFAULT_DELIMITER1 = ",";
    private static final String DEFAULT_DELIMITER2 = ":";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    public static List<PositiveNumber> parse(String input) {
        if (isBlank(input)) {
            return new ArrayList<>();
        }

        if (isNumber(input.charAt(0))) {
            return defaultParse(input);
        }

        return customParse(input);
    }

    private static List<PositiveNumber> defaultParse(String input) {
        String[] strings = input.split(DEFAULT_DELIMITER1 + DEFAULT_DELIMITER2);
        return stringsToPositiveNumbers(strings);
    }

    private static List<PositiveNumber> customParse(String input) {
        if (!input.startsWith(CUSTOM_DELIMITER_PREFIX) || !input.contains(CUSTOM_DELIMITER_SUFFIX)) {
            throw new IllegalArgumentException("Failed to parse input: " + input);
        }

        int index = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        String customDelimiter = input.substring(2, index);
        String[] strings = input.substring(index + 2).split(customDelimiter);
        return stringsToPositiveNumbers(strings);
    }

    private static List<PositiveNumber> stringsToPositiveNumbers(String[] strings) {
        List<PositiveNumber> result = new ArrayList<>();
        for (String string : strings) {
            isValid(string);
            System.out.println(string);
            result.add(new PositiveNumber(Integer.parseInt(string)));
        }
        return result;
    }

    private static void isValid(String token) {
        for (char c : token.toCharArray()) {
            if (!isNumber(c)) {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }
    }

    private static boolean isBlank(String string) {
        return string == null || string.trim().isEmpty();
    }

    private static boolean isNumber(Character character) {
        return character >= '0' && character <= '9';
    }
}

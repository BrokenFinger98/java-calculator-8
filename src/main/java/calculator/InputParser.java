package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputParser {

    private static final String DEFAULT_DELIMITER1 = ",";
    private static final String DEFAULT_DELIMITER2 = ":";
    private static final String DEFAULT_REGEX = DEFAULT_DELIMITER1 + "|" + DEFAULT_DELIMITER2;

    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    public static List<PositiveNumber> parse(String input) {
        if (isBlank(input)) {
            return List.of();
        }

        if (hasCustomDelimiter(input)) {
            return parseWithCustomDelimiter(input);
        }

        return parseWithDefaultDelimiters(input);
    }

    private static List<PositiveNumber> parseWithDefaultDelimiters(String input) {
        String[] strings = input.split(DEFAULT_REGEX);
        validateAllNumeric(strings);
        return toPositiveNumbers(strings);
    }

    private static List<PositiveNumber> parseWithCustomDelimiter(String input) {
        int index = input.indexOf(CUSTOM_DELIMITER_SUFFIX);
        if (index < 0) {
            throw new IllegalArgumentException("Invalid custom delimiter pattern: " + input);
        }

        String rawDelimiter = input.substring(CUSTOM_DELIMITER_PREFIX.length(), index);
        String quoted = Pattern.quote(rawDelimiter);
        String body = input.substring(index + CUSTOM_DELIMITER_SUFFIX.length());

        if (isBlank(body)) {
            return List.of();
        }

        String[] strings = body.split(quoted);
        validateAllNumeric(strings);
        return toPositiveNumbers(strings);
    }

    private static List<PositiveNumber> toPositiveNumbers(String[] strings) {
        return Arrays.stream(strings)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .map(PositiveNumber::new).toList();
    }

    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private static void validateAllNumeric(String[] strings) {
        Arrays.stream(strings)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .forEach(InputParser::assertDigitsOnly);
    }

    private static void assertDigitsOnly(String string) {
        if (!string.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("Invalid number: " + string);
        }
    }

    private static boolean isBlank(String string) {
        return string == null || string.trim().isEmpty();
    }
}

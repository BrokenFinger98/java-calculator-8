package calculator;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    private static final String DEFAULT_DELIMITER1 = ",";
    private static final String DEFAULT_DELIMITER2 = ":";
    private static final String CUSTOM_DELIMITER_PREFIX = "//";
    private static final String CUSTOM_DELIMITER_SUFFIX = "\\n";

    public static List<PositiveNumber> parse(String input) {
        if (input == null || input.isEmpty()) {
            return new ArrayList<>();
        }

        char startCharacter = input.charAt(0);
        if (startCharacter >= '0' && startCharacter <= '9') {
            return defaultParse(input);
        }

        return customParse(input);
    }

    private static List<PositiveNumber> defaultParse(String input) {
        String[] tokens = input.split(DEFAULT_DELIMITER1 + DEFAULT_DELIMITER2);
        List<PositiveNumber> result = new ArrayList<>();
        for (String token : tokens) {
            isValid(token);
            result.add(new PositiveNumber(Double.parseDouble(token)));
        }
        return result;
    }

    private static List<PositiveNumber> customParse(String input) {
        if (!input.startsWith(CUSTOM_DELIMITER_PREFIX) || !input.contains(CUSTOM_DELIMITER_SUFFIX)) {
            throw new IllegalArgumentException("Failed to parse input: " + input);
        }

        int index = input.indexOf(CUSTOM_DELIMITER_SUFFIX);

        String customDelimiter = input.substring(3, index + 1);
        String[] tokens = input.substring(index + 3).split(customDelimiter);
        List<PositiveNumber> result = new ArrayList<>();
        for (String token : tokens) {
            isValid(token);
            result.add(new PositiveNumber(Double.parseDouble(token)));
        }
        return result;
    }

    private static void isValid(String token) {
        for (char c : token.toCharArray()) {
            if (!((c >= '0' && c <= '9') || c == '.')) {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }
    }
}

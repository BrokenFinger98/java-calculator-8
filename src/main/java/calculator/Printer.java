package calculator;

public class Printer {

    private static final String START_SENTENCE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_PREFIX = "결과 : ";

    public static void printStartSentence() {
        System.out.println(START_SENTENCE);
    }

    public static void printResultSentence(Double sum) {
        System.out.println(RESULT_PREFIX + sum);
    }

    private Printer() {
    }
}

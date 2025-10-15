package calculator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Printer {

    private static final String START_SENTENCE = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_PREFIX = "결과 : ";
    private static BufferedWriter writer;

    private Printer() {
    }

    private static Printer getInstance() {
        if (writer == null) {
            writer = new BufferedWriter(new OutputStreamWriter(System.out));
        }
        return new Printer();
    }

    public void printStartSentence() throws IOException {
        writer.append(START_SENTENCE).append("\n");
        writer.flush();
    }

    public void printResultSentence(Double sum) throws IOException {
        writer.append(RESULT_PREFIX).append(sum.toString()).append("\n");
        writer.flush();
        writer.close();
    }
}

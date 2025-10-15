package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrinterTest {

    @Test
    @DisplayName("애플리케이션 시작 문장를 반환한다.")
    void startSentence() {
        // when
        String startSentence = Printer.startSentence();

        // then
        assertThat(startSentence).isEqualTo("덧셈할 문자열을 입력해 주세요.");
    }

    @Test
    @DisplayName("결과 문장을 반환한다.")
    void resultSentence() {
        // given
        int sum = 10;

        // when
        String resultSentence = Printer.resultSentence(sum);

        // then
        assertThat(resultSentence).isEqualTo("결과 : " + sum);
    }
}

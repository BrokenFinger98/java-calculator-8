package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositiveNumberTest {

    @Test
    @DisplayName("양수를 생성한다.")
    void positiveNumber() {
        // given
        int number = 1;

        // when
        PositiveNumber positiveNumber = new PositiveNumber(number);

        // then
        assertThat(positiveNumber).isNotNull();
    }

    @Test
    @DisplayName("음수를 가지고 PositiveNumber 생성하면 IllegalArgumentException이 발생한다.")
    void positiveNumber_withNegativeNumber_throwsException() {
        // given
        int number = -1;

        // when & then
        assertThatThrownBy(() -> new PositiveNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Negative number");
    }

    @Test
    @DisplayName("입력 받는 정수에 posiviteNumber의 value를 더한 값을 반환한다.")
    void addTo() {
        // given
        int number1 = 0;
        int number2 = 1;
        PositiveNumber positiveNumber = new PositiveNumber(number2);

        // when
        int result = positiveNumber.addTo(number1);
        
        // then
        assertThat(result).isEqualTo(number1 + number2);
    }
}

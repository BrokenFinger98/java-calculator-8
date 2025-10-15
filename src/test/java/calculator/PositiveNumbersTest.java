package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositiveNumbersTest {

    @Test
    @DisplayName("PositiveNumbers를 생성한다.")
    void positiveNumbers() {
        // given
        List<PositiveNumber> numbers = new ArrayList<>();

        // when
        PositiveNumbers positiveNumbers = new PositiveNumbers(numbers);

        // then
        assertThat(positiveNumbers).isNotNull();
    }

    @Test
    @DisplayName("positiveNumbers의 합을 반환한다.")
    void sum() {
        // given
        int number1 = 1;
        int number2 = 2;
        PositiveNumber positiveNumber1 = new PositiveNumber(number1);
        PositiveNumber positiveNumber2 = new PositiveNumber(number2);
        List<PositiveNumber> numbers = new ArrayList<>();

        numbers.add(positiveNumber1);
        numbers.add(positiveNumber2);

        PositiveNumbers positiveNumbers = new PositiveNumbers(numbers);

        // when
        int sum = positiveNumbers.sum();

        // then
        assertThat(sum).isEqualTo(number1 + number2);
    }
}

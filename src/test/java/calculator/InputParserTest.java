package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputParserTest {

    @Test
    @DisplayName("기본 구분자(, :)로 구분된 문자열을 분리하여 양수들을 반환한다.")
    void parseWithDefaultDelimiters() {
        // given
        String input = "1,2:3";

        // when
        List<PositiveNumber> numbers = InputParser.parse(input);

        // then
        assertThat(numbers).isNotNull();
        assertThat(numbers).hasSize(3);
    }

    @Test
    @DisplayName("기본 구분자(, :)로 구분되고 공백을 가진 문자열을 분리하여 양수들을 반환한다.")
    void parseWithDefaultDelimitersAndSpaces() {
        // given
        String input = "1, 2: 3";

        // when
        List<PositiveNumber> numbers = InputParser.parse(input);

        // then
        assertThat(numbers).isNotNull();
        assertThat(numbers).hasSize(3);
    }

    @Test
    @DisplayName("기본 구분자(, :)로 구분된 문자열에 숫자가 아닌 문자가 포함되면 예외가 발생한다.")
    void parseWithDefaultDelimitersAndNotNumbers() {
        // given
        String input = "a, b: 3";

        // when & then
        assertThatThrownBy(() -> InputParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("Invalid number: ");
    }

    @Test
    @DisplayName("커스텀 구분자로 구분된 문자열을 분리하여 양수들을 반환한다.")
    void parseWithCustomDelimiter() {
        // given
        String input = "//;\\n1;2;3";

        // when
        List<PositiveNumber> numbers = InputParser.parse(input);

        // then
        assertThat(numbers).isNotNull();
        assertThat(numbers).hasSize(3);
    }

    @Test
    @DisplayName("커스텀 구분자로 구분된 문자열을 분리하여 양수들을 반환한다.")
    void parseWithCustomDelimiterAndSpaces() {
        // given
        String input = "//;\\n 1; 2;3 ";

        // when
        List<PositiveNumber> numbers = InputParser.parse(input);

        // then
        assertThat(numbers).isNotNull();
        assertThat(numbers).hasSize(3);
    }

    @Test
    @DisplayName("커스텀 구분자로 구분된 문자열을 분리하여 양수들을 반환한다.")
    void parseWithInvalidCustomDelimiterSuffix() {
        // given
        String input = "//;// 1; 2;3 ";

        // when & then
        assertThatThrownBy(() -> InputParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("Invalid custom delimiter pattern: " + input);
    }
}

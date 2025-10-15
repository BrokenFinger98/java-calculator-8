package calculator;

import java.util.List;

public class PositiveNumbers {

    private final List<PositiveNumber> positiveNumbers;

    public PositiveNumbers(List<PositiveNumber> positiveNumbers) {
        this.positiveNumbers = positiveNumbers;
    }

    public int sum() {
        int sum = 0;
        for (PositiveNumber positiveNumber : positiveNumbers) {
            sum = positiveNumber.addTo(sum);
        }
        return sum;
    }
}

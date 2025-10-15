package calculator;

public class PositiveNumber {
    private final Integer value;

    public PositiveNumber(Integer number) {
        isPositive(number);
        this.value = number;
    }

    public Integer getValue() {
        return value;
    }

    private void isPositive(Integer number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative number");
        }
    }
}

package calculator;

public class PositiveNumber {
    private final Number value;

    public PositiveNumber(Number number) {
        isPositive(number);
        this.value = number;
    }

    public Number getValue() {
        return value;
    }

    private void isPositive(Number number) {
        if (number.doubleValue() < 0) {
            throw new IllegalArgumentException("Negative number");
        }
    }
}

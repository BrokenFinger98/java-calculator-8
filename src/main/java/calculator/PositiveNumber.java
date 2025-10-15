package calculator;

public class PositiveNumber {
    private final Number value;

    public PositiveNumber(Number number) {
        isPositive(number);
        this.value = number;
    }

    public void isPositive(Number number) {
        if (number.doubleValue() < 0) {
            throw new IllegalArgumentException("Negative number");
        }
    }

    public Number getValue() {
        return value;
    }
}

package calculator;

public class PositiveNumber {
    private final Double value;

    public PositiveNumber(Number number) {
        isPositive(number);
        this.value = number.doubleValue();
    }

    public void isPositive(Number number) {
        if (number.doubleValue() < 0) {
            throw new IllegalArgumentException("Negative number");
        }
    }

    public Double getValue() {
        return value;
    }

    public String getValueAsString() {
        return String.valueOf(value);
    }
}

package calculator;

public class PositiveNumber {
    private final int value;

    public PositiveNumber(int number) {
        isNegative(number);
        this.value = number;
    }

    public int addTo(int number) {
        return value + number;
    }

    private void isNegative(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative number");
        }
    }
}

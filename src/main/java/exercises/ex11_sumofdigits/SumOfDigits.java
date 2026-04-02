package exercises.ex11_sumofdigits;

public class SumOfDigits {
    public static int sumOfDigits(long number) {
        if (number < 0) throw new IllegalArgumentException();
        if (number < 10) return (int)number;

        var lastDigit = number % 10;
        var rest = number / 10;

        return sumOfDigits(rest + lastDigit);
        // return sumOfDigits(sumOfDigits(rest) + lastDigit);
    }
}

package exercises.ex08_gepast_betalen_bis;

import java.util.List;

public class GepastBetalenBis {

    public static int countChange(int amount, List<Integer> coinValues) {
        if (amount == 0) return 1;
        if (amount < 0) return 0;
        if (coinValues.isEmpty()) return 0;

        var first = coinValues.getFirst();
        var rest = coinValues.subList(1, coinValues.size());

        return countChange(amount - first, coinValues) +
                countChange(amount, rest);
    }
}

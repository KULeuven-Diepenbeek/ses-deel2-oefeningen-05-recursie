package exercises.ex07_gepast_betalen;

import java.util.List;

public class GepastBetalen {

    public static boolean kanGepastBetalen(int bedrag, List<Integer> munten) {
        if (bedrag < 0) return false;
        if (bedrag == 0) return true;
        // dus bedrag > 0
        if (munten.isEmpty()) return false;

        var first = munten.getFirst();
        var rest = munten.subList(1, munten.size());

        return kanGepastBetalen(bedrag - first, rest) ||
                kanGepastBetalen(bedrag, rest);
    }
}

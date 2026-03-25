package exercises.ex07_gepast_betalen;

import java.util.List;

public class GepastBetalen {

    public static boolean kanGepastBetalen(int bedrag, List<Integer> munten) {
        if (bedrag < 0) return false; // we kunnen geen negatief bedrag betalen
        if (bedrag == 0) return true; // we kunnen steeds niets betalen
        if (munten.isEmpty()) return false; // zonder munten kunnen we niets betalen

        var eersteMunt = munten.getFirst();
        var andereMunten = munten.subList(1, munten.size());

        // er zijn 2 opties:
        // - we gebruiken de eerste munt uit de lijst WEL
        //   het nog te betalen bedrag verlagen we met de waarde van de eerste munt
        //   munt mag niet meer gebruikt worden, dus recursieve oproep met enkel de andere munten
        // - we gebruiken de eerste munt uit de lijst NIET
        //   we moeten nu nog het volledige bedrag kunnen betalen met de andere munten
        return kanGepastBetalen(bedrag - eersteMunt, andereMunten) ||
                kanGepastBetalen(bedrag, andereMunten);
    }
}

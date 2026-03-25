package exercises.ex08_gepast_betalen_bis;

import java.util.List;

public class GepastBetalenBis {

    public static int countChange(int bedrag, List<Integer> muntWaarden) {
        if (bedrag < 0) return 0; // er is geen enkele manier om een negatief bedrag te betalen
        if (bedrag == 0) return 1; // er is exact 1 manier om niets te betalen, namelijk geen munten gebruiken
        if (muntWaarden.isEmpty()) return 0; // er is geen enkele manier om een strikt positief bedrag te betalen zonder munten

        var eersteMunt = muntWaarden.getFirst();
        var andereMunten = muntWaarden.subList(1, muntWaarden.size());

        // 2 opties:
        // - we gebruiken de eerste muntwaarde WEL (dus minstens 1 keer)
        // - we gebruiken de eerste muntwaarde NIET
        return countChange(bedrag - eersteMunt, muntWaarden) +
                countChange(bedrag, andereMunten);
    }
}

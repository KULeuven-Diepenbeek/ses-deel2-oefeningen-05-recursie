package exercises.ex12_vliegtuigreis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Vliegtuigreis {

    record Item(String name, int weight, int value) {}

    public static List<Item> pack(List<Item> options, int maxWeight) {
        if (maxWeight <= 0 || options.isEmpty()) return new ArrayList<>();

        var firstItem = options.getFirst();
        var otherItems = options.subList(1, options.size());

        // 2 opties voor eerste item:
        // - eerste item gaat niet mee (=> nog toegelaten gewicht blijft hetzelfde)
        // - eerste item gaat mee (als het minder weegt dan toegelaten) (=> nog toegelaten gewicht verlagen)

        var bestOptionWithoutFirstItem = pack(otherItems, maxWeight);
        var valueWithoutFirst = bestOptionWithoutFirstItem.stream().mapToInt(Item::value).sum();

        if (firstItem.weight <= maxWeight) {
            var bestOptionWithFirstItem = pack(otherItems, maxWeight - firstItem.weight());
            bestOptionWithFirstItem.add(firstItem);
            var valueWithFirst = bestOptionWithFirstItem.stream().mapToInt(Item::value).sum();
            if (valueWithFirst >= valueWithoutFirst)
                return bestOptionWithFirstItem;
        }

        return bestOptionWithoutFirstItem;
    }
}

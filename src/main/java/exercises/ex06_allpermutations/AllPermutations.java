package exercises.ex06_allpermutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPermutations {
    public static <T> Set<List<T>> allPermutations(List<T> elements) {
        if (elements.isEmpty()) return Set.of(List.of());

        var first = elements.getFirst();
        var rest = elements.subList(1, elements.size());

        var permRest = allPermutations(rest);
        var resultSet = new HashSet<List<T>>();
        for (var lst : permRest) {
            for (int i = 0; i <= lst.size(); i++) {
                var newLst = new ArrayList<>(lst);
                newLst.add(i, first);
                resultSet.add(newLst);
            }
        }
        return resultSet;
    }

}

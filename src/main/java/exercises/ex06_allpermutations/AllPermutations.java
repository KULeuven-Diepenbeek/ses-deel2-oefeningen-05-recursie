package exercises.ex06_allpermutations;

import java.util.*;

public class AllPermutations {
    public static <T> Set<List<T>> allPermutations(List<T> elements) {
        if (elements.isEmpty()) return Collections.singleton(Collections.emptyList());
        //                             ^-- er is 1 permutatie van een lege lijst, namelijk een lege lijst
        var first = elements.getFirst();
        var permutationsWithoutFirst = allPermutations(elements.subList(1, elements.size()));
        var result = new HashSet<List<T>>();
        for (var permutation : permutationsWithoutFirst) {
            for (int i = 0; i <= permutation.size(); i++) {
                //             ^-- opgelet: <= (en niet <)
                var permutationWithFirst = new ArrayList<>(permutation);
                permutationWithFirst.add(i, first);
                result.add(permutationWithFirst);
            }
        }
        return result;
    }

}

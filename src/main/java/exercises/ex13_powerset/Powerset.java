package exercises.ex13_powerset;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Powerset {

    public static <T> Set<Set<T>> powerset(Set<T> s) {
        if (s.isEmpty()) return Collections.singleton(s);

        var element = s.iterator().next();
        var rest = new HashSet<>(s);
        rest.remove(element);

        var powsetOfRest = powerset(rest);
        var result = new HashSet<>(powsetOfRest);
        for (var powsetElement : powsetOfRest) {
            var setToAdd = new HashSet<>(powsetElement);
            setToAdd.add(element);
            result.add(setToAdd);
        }
        return result;
    }

}

package exercises.ex09_allprefixes;

import java.util.HashSet;
import java.util.Set;

public class AllPrefixes {

    public static Set<String> allPrefixes(String str) {
        if (str.isEmpty()) return new HashSet<>(Set.of(""));

        var prefix = str.substring(0, str.length() - 1);
        var result = allPrefixes(prefix);
        result.add(str);

        return result;
    }
}

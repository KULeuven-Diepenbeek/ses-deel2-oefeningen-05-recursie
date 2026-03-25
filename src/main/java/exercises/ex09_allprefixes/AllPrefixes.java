package exercises.ex09_allprefixes;

import java.util.HashSet;
import java.util.Set;

public class AllPrefixes {

    public static Set<String> allPrefixes(String str) {
        // lege string heeft 1 prefix, namelijk de lege string
        if (str.isEmpty()) return new HashSet<>(Set.of(""));

        // alle prefixen van str = alle prefixen van str zonder de laatste letter + str zelf
        var strZonderLaatste = str.substring(0, str.length() - 1);
        var result = allPrefixes(strZonderLaatste);
        result.add(str);

        return result;
    }
}

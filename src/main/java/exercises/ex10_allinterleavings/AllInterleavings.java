package exercises.ex10_allinterleavings;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllInterleavings {
    public static Set<String> allInterleavings(String s1, String s2) {
        if (s1.isEmpty()) return Set.of(s2);
        if (s2.isEmpty()) return Set.of(s1);

        var firstOfs1 = s1.charAt(0);
        var restOfs1 = s1.substring(1);
        var firstOfs2 = s2.charAt(0);
        var restOfs2 = s2.substring(1);

        // alle interleavings van s1 en s2 kunnen opgedeeld worden in 2 groepen:
        // - de interleavings die beginnen met het eerste karakter van s1
        // - de interleavings die beginnen met het eerste karakter van s2

        // implementatie met streams:
        return Stream.concat(
                allInterleavings(restOfs1, s2).stream()
                        .map(i -> firstOfs1 + i),
                allInterleavings(s1, restOfs2).stream()
                        .map(i -> firstOfs2 + i)
        ).collect(Collectors.toSet());

        // versie zonder streams
//        var result = new HashSet<String>();
//        for (var interleaving : allInterleavings(restOfs1, s2)) {
//            result.add(firstOfs1 + interleaving);
//        }
//        for (var interleaving : allInterleavings(s1, restOfs2)) {
//            result.add(firstOfs2 + interleaving);
//        }
//        return result;
    }


}

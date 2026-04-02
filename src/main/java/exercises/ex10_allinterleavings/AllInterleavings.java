package exercises.ex10_allinterleavings;

import java.util.HashSet;
import java.util.Set;

public class AllInterleavings {

    public static Set<String> allInterleavings(String s1, String s2) {
        IO.println("s1: " + s1 + " - s2: " + s2);
        if (s1.isEmpty()) return Set.of(s2);
        if (s2.isEmpty()) return Set.of(s1);

        var firstS1 = s1.charAt(0);
        var restS1 = s1.substring(1);
        var firstS2 = s2.charAt(0);
        var restS2 = s2.substring(1);

        var result = new HashSet<String>();
        for (var il : allInterleavings(restS1, s2)) {
            result.add(firstS1 + il);
        }
        for (var il : allInterleavings(s1, restS2)) {
            result.add(firstS2 + il);
        }
        return result;
    }

    static void main() {
        allInterleavings("ABC", "xyz");
    }

}

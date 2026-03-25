package exercises.ex18_sort;

import java.util.Collections;
import java.util.List;

public class Sorter {

    public static <T extends Comparable<T>> void sort(List<T> list) {
        // dit is een recursieve versie van INSERTION SORT
        if (list.size() <= 1) return;

        // sorteer de hele lijst behalve het eerste element
        var listExceptFirst = list.subList(1, list.size());
        sort(listExceptFirst);

        // schuif het eerste element op naar de juiste plaats
        swapFirstIntoPlace(list);
    }

    private static <T extends Comparable<T>> void swapFirstIntoPlace(List<T> list) {
        if (list.size() <= 1) return;

        var first = list.getFirst();
        var rest = list.subList(1, list.size());

        if (first.compareTo(rest.getFirst()) > 0) {
            // first > second: moet omwisselen...
            Collections.swap(list, 0, 1);
            // en verder swappen tot element op de juiste plaats staat
            swapFirstIntoPlace(rest);
        }
    }
}

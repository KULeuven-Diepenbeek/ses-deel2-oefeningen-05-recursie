package exercises.ex03_searchelement;

import java.util.List;

public class SearchElement {

    public static <T> int search(
            List<? extends T> elements,
            T elementToFind) {
        if (elements.isEmpty()) return -1;
        if (elements.getLast().equals(elementToFind)) return elements.size() - 1;
        return search(elements.subList(0, elements.size() - 1), elementToFind);
    }

    public static <T> int search_alt(
            List<? extends T> elements,
            T elementToFind) {
        // alternatieve versie die met het eerste element vergelijkt (iets complexer)
        if (elements.isEmpty()) return -1;
        if (elements.getFirst().equals(elementToFind)) return 0;
        var result = search_alt(elements.subList(1, elements.size()), elementToFind);
        if (result == -1) return -1;
        return 1 + result;
    }

}

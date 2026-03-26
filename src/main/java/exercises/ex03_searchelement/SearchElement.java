package exercises.ex03_searchelement;

import java.util.List;

public class SearchElement {

    public static <T> int search(
            List<? extends T> elements,
            T elementToFind) {
        if (elements.isEmpty()) return -1;
        if (elements.size() == 1) {
            if (elementToFind.equals(elements.getFirst()))
                return 0;
            return -1;
        };

        var mid = elements.size() / 2;
        var left = elements.subList(0, mid);
        var right = elements.subList(mid, elements.size());

        var foundAt = search(left, elementToFind);
        if (foundAt >= 0) return foundAt;
        foundAt = search(right, elementToFind);
        if (foundAt == -1) return -1;
        return foundAt + mid;
    }

    public static <T> int search2(
            List<? extends T> elements,
            T elementToFind) {
        if (elements.isEmpty()) return -1;
        if (elements.getLast().equals(elementToFind))
            return elements.size() - 1;
        var prefix = elements.subList(0, elements.size() - 1);
        return search2(prefix, elementToFind);
    }

}

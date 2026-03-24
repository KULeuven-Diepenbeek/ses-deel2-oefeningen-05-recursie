package exercises.ex18_sort;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Ex18SorterTest {

    @Test
    public void sortEmptyList() {
        List<String> list = new ArrayList<>();
        Sorter.sort(list);
        assertThat(list).isSorted();
    }

    @Test
    public void sortListWithOneElement() {
        List<String> list = new ArrayList<>(List.of("A"));
        Sorter.sort(list);
        assertThat(list).isSorted();
    }

    @Test
    public void sortListWithTwoElements() {
        List<String> list = new ArrayList<>(List.of("B", "A"));
        Sorter.sort(list);
        assertThat(list).isSorted();
    }

    @Test
    public void sortListWithFiveElements() {
        List<String> list = new ArrayList<>(List.of("B", "A", "C", "E", "D"));
        Sorter.sort(list);
        assertThat(list).isSorted();
    }

    @Test
    public void sortListWithAllSameElements() {
        List<String> list = new ArrayList<>(List.of("A", "A", "A", "A"));
        Sorter.sort(list);
        assertThat(list).isSorted();
    }

    @Test
    public void sortReverselySortedList() {
        List<String> list = new ArrayList<>(List.of("E", "D", "C", "B", "A"));
        Sorter.sort(list);
        assertThat(list).isSorted();
    }

}

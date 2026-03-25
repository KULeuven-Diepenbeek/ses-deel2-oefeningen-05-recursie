package exercises.ex19_reduce;

import java.util.List;
import java.util.function.BiFunction;

public class Reduce {

    public static <T, R> R reduce(List<T> lst, R initial, BiFunction<? super R, ? super T, ? extends R> reducer) {
        if (lst.isEmpty()) return initial;

        var first = lst.getFirst();
        var rest = lst.subList(1, lst.size());

        var newInitial = reducer.apply(initial, first);

        return reduce(rest, newInitial, reducer);
    }
}

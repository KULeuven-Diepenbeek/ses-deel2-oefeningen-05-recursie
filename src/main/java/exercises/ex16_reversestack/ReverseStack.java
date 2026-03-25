package exercises.ex16_reversestack;

import java.util.*;

public class ReverseStack {
    public static <T> void reverse(Deque<T> stack) {
        if (stack.isEmpty()) return;

        var first = stack.pollFirst();
        reverse(stack);
        insertAtBottom(stack, first);
    }

    private static <T> void insertAtBottom(Deque<T> stack, T element) {
        if (stack.isEmpty()) {
            stack.addFirst(element);
        } else {
            var first = stack.pollFirst();;
            insertAtBottom(stack, element);
            stack.addFirst(first);
        }
    }
}

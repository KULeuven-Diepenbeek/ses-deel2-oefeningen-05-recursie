package exercises.ex20_tree;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class TreeUtils {

    public static int treeSize(TreeNode<?> tree) {
        if (tree == null) return 0;

        return 1 + treeSize(tree.left()) + treeSize(tree.right());
    }

    public static int treeHeight(TreeNode<?> tree) {
        if (tree == null) return 0;
        if (tree.left() == null && tree.right() == null) return 0;

        return 1 + Math.max(treeHeight(tree.left()), treeHeight(tree.right()));
    }

    public static <T> void visitDepthFirstPreOrder(TreeNode<T> tree, Consumer<T> consumer) {
        if (tree == null) return;

        consumer.accept(tree.value());
        visitDepthFirstPreOrder(tree.left(), consumer);
        visitDepthFirstPreOrder(tree.right(), consumer);
    }

    public static <T> void visitDepthFirstInOrder(TreeNode<T> tree, Consumer<T> consumer) {
        if (tree == null) return;

        visitDepthFirstInOrder(tree.left(), consumer);
        consumer.accept(tree.value());
        visitDepthFirstInOrder(tree.right(), consumer);
    }

    public static <T> TreeNode<T> mirror(TreeNode<T> tree) {
        if (tree == null) return null;

        var newLeft = mirror(tree.right());
        var newRight = mirror(tree.left());
        return new TreeNode<>(tree.value(), newLeft, newRight);
    }

    public static <T> String prettyPrint(TreeNode<T> tree) {
        if (tree == null) return "";

        StringBuilder result = new StringBuilder(tree.value().toString() + "\n");

        var childNodes = new ArrayList<TreeNode<T>>();
        if (tree.left() != null) childNodes.add(tree.left());
        if (tree.right() != null) childNodes.add(tree.right());

        if (!childNodes.isEmpty()) {
            result.append("|\n");
            while (!childNodes.isEmpty()) {
                var nextChild = childNodes.removeFirst();
                var isLast = childNodes.isEmpty();
                result.append(prettyPrint(nextChild).lines()
                        .reduce("", appendAndIndent(isLast ? "'-- " : "+-- ", isLast ? "    " : "|   ")));
            }
        }
        return result.toString();
    }

    /**
     * Returns an operator that appends an indented version of the second parameter to the first parameter.
     * The indentation string is given by the parameters.
     */
    private static BinaryOperator<String> appendAndIndent(String indentFirst, String indentNext) {
        return (previous, strToAppend) -> (previous.isEmpty() ? indentFirst : previous + indentNext) + strToAppend + "\n";
    }

    static void main() {
        var tree = new TreeNode<>("A",
                new TreeNode<>("B",
                        new TreeNode<>("C", null, null),
                        new TreeNode<>("D", null, null)),
                new TreeNode<>("E",
                        new TreeNode<>("F", null, null),
                        null));
        System.out.println(prettyPrint(tree));
    }
}

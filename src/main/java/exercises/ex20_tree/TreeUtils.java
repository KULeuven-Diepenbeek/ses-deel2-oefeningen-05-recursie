package exercises.ex20_tree;

import java.util.function.Consumer;

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
}

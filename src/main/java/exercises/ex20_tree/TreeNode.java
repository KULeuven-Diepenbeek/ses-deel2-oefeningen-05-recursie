package exercises.ex20_tree;

public record TreeNode<T>(T value, TreeNode<T> left, TreeNode<T> right) {
}

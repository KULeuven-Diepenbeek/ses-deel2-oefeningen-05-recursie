package exercises.ex20_tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Ex20TreeTest {

    @Test
    public void height_of_single_node() {
        var tree = new TreeNode<>("A", null, null);
        assertThat(TreeUtils.treeHeight(tree)).isEqualTo(0);
    }

    @Test
    public void height_of_multiple_node() {
        var tree = new TreeNode<>("A",
                new TreeNode<>("B",
                        new TreeNode<>("C", null, null),
                        null),
                new TreeNode<>("D", null, null));
        assertThat(TreeUtils.treeHeight(tree)).isEqualTo(2);
    }

    @Test
    public void size_of_multiple_node() {
        var tree = new TreeNode<>("A",
                new TreeNode<>("B",
                        new TreeNode<>("C", null, null),
                        null),
                new TreeNode<>("D", null, null));
        assertThat(TreeUtils.treeSize(tree)).isEqualTo(4);
    }

    @Test
    public void mirror_of_single_node() {
        var tree = new TreeNode<>("A", null, null);
        assertThat(TreeUtils.mirror(tree)).isEqualTo(tree);
    }

    @Test
    public void mirror_of_example_tree() {
        var tree = new TreeNode<>("A",
                new TreeNode<>("B",
                        new TreeNode<>("C", null, null),
                        new TreeNode<>("D", null, null)),
                new TreeNode<>("E",
                        new TreeNode<>("F", null, null),
                        null));
        var mirrored = new TreeNode<>("A",
                new TreeNode<>("E",
                        null,
                        new TreeNode<>("F", null, null)),
                new TreeNode<>("B",
                        new TreeNode<>("D", null, null),
                        new TreeNode<>("C", null, null))
        );
        assertThat(TreeUtils.mirror(tree)).isEqualTo(mirrored);
    }

    @Test
    public void depth_first_pre_order() {
        var tree = new TreeNode<>("A",
                new TreeNode<>("B",
                        new TreeNode<>("C", null, null),
                        new TreeNode<>("D", null, null)),
                new TreeNode<>("E",
                        new TreeNode<>("F", null, null),
                        null));
        var result = new ArrayList<>();
        TreeUtils.visitDepthFirstPreOrder(tree, result::add);
        assertThat(result).isEqualTo(List.of("A", "B", "C", "D", "E", "F"));
    }

    @Test
    public void depth_first_in_order() {
        var tree = new TreeNode<>("A",
                new TreeNode<>("B",
                        new TreeNode<>("C", null, null),
                        new TreeNode<>("D", null, null)),
                new TreeNode<>("E",
                        new TreeNode<>("F", null, null),
                        null));
        var result = new ArrayList<>();
        TreeUtils.visitDepthFirstInOrder(tree, result::add);
        assertThat(result).isEqualTo(List.of("C", "B", "D", "A", "F", "E"));
    }
}

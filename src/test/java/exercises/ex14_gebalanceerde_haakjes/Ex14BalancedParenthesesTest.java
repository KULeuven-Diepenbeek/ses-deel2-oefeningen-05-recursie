package exercises.ex14_gebalanceerde_haakjes;

import org.junit.jupiter.api.Test;

import static exercises.ex14_gebalanceerde_haakjes.BalancedParentheses.isBalancedContinuation;
import static org.assertj.core.api.Assertions.assertThat;

public class Ex14BalancedParenthesesTest {

    @Test
    public void empty_string() {
        assertThat(isBalancedContinuation("")).isTrue();
    }

    @Test
    public void single_char() {
        assertThat(isBalancedContinuation("x")).isTrue();
    }

    @Test
    public void many_chars() {
        assertThat(isBalancedContinuation("aaa")).isTrue();
    }

    @Test
    public void single_open() {
        assertThat(isBalancedContinuation("(")).isFalse();
    }

    @Test
    public void single_closed() {
        assertThat(isBalancedContinuation(")")).isFalse();
    }

    @Test
    public void single_open_close() {
        assertThat(isBalancedContinuation("()")).isTrue();
    }

    @Test
    public void single_close_open() {
        assertThat(isBalancedContinuation(")(")).isFalse();
    }

    @Test
    public void double_open() {
        assertThat(isBalancedContinuation("((")).isFalse();
    }

    @Test
    public void double_closed() {
        assertThat(isBalancedContinuation("))")).isFalse();
    }

    @Test
    public void sequence() {
        assertThat(isBalancedContinuation("()()")).isTrue();
    }

    @Test
    public void nested() {
        assertThat(isBalancedContinuation("x(x(x(xax)x)(xb)x)x")).isTrue();
    }

    @Test
    public void missing_one() {
        assertThat(isBalancedContinuation("a(bc(def(xy))z")).isFalse();
    }

}

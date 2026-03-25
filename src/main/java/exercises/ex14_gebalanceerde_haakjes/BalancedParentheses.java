package exercises.ex14_gebalanceerde_haakjes;

public class BalancedParentheses {
    public static boolean isBalancedContinuation(String s) {
        return isBalancedContinuation(s, 0);
    }

    /**
     * Ga na of de gegeven string een gebalanceerde verderzetting is
     * van een prefix met het gegeven aantal open haakjes
     * bv. is s="x)(y)z)" een gebalanceerde verderzetting van "(("? (JA)
     */
    private static boolean isBalancedContinuation(String s, int nbOpen) {
        if (nbOpen < 0) return false;
        if (s.isEmpty()) return nbOpen == 0;

        var firstChar = s.charAt(0);
        var suffix = s.substring(1);

        if (firstChar == '(')
            nbOpen++;
        else if (firstChar == ')')
            nbOpen--;

        return isBalancedContinuation(suffix, nbOpen);
    }
}

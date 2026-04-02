package exercises.ex05_trap;

public class TrapTreden {
    public static int trapTreden(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        return trapTreden(n-1) + trapTreden(n-2);
    }

}

package exercises.ex05_trap;

public class TrapTreden {
    public static int trapTreden(int n) {
        // er is slechts 1 manier om een trap met 0 of 1 trede(n) op te gaan
        if (n <= 1) return 1;
        // om een trap met n treden op te gaan, kan je
        // - eindigen met een stap van 1 trede, door eerst tot trede n-1 gaan, of
        // - eindigen met een stap van 2 treden tegelijk, door eerst tot trede n-2 gaan
        return trapTreden(n - 1) + trapTreden(n - 2);
        // dit is dezelfde recursie als bij de Fibonacci-getallen
    }

}

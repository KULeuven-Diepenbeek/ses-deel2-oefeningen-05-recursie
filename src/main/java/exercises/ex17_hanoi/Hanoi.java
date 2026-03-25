package exercises.ex17_hanoi;

public class Hanoi {

    public static void hanoi(int n, String from, String to, String helper1, String helper2) {
        /*
            from  h1   h2  to           from   h1   h2   to
             |    |    |    |              |    |    |    |
             =    |    |    |       =>     |    |    |    =
            ===   |    |    |              |    |    |   ===
           =====  |    |    |              |    |    |  =====
         */
        if (n <= 0) return;
        if (n == 1) {
            System.out.println("Move from " + from + " to " + to); // laatste schijf
        } else {
            hanoi(n - 2, from, helper1, helper2, to); // alles behalve onderste twee schijven
        /*
            from  h1   h2  to
             |    |    |    |
             |    |    |    |
            ===   |    |    |
           =====  =    |    |
         */
            hanoi(1, from, helper2, helper1, to); // voorlaatste schijf
        /*
            from  h1   h2  to
             |    |    |    |
             |    |    |    |
             |    |    |    |
           =====  =   ===   |
         */
            hanoi(1, from, to, helper1, helper2); // laatste schijf
        /*
            from  h1   h2  to
             |    |    |    |
             |    |    |    |
             |    |    |    |
             |    =   === =====
         */
            hanoi(1, helper2, to, helper1, from); // voorlaatste schijf
        /*
            from  h1   h2  to
             |    |    |    |
             |    |    |    |
             |    |    |   ===
             |    =    |  =====
         */
            hanoi(n - 2, helper1, to, from, helper2); // rest
        /*
            from  h1   h2  to
             |    |    |    |
             |    |    |    =
             |    |    |   ===
             |    |    |  =====
         */
        }
    }
    public static void main(String[] args) {
        hanoi(4, "A", "B", "C", "D");
    }

}

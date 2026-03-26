package voorbeelden;

public class Hanoi {
    public static void hanoi(int n, String from, String to, String helper) {
        if (n <= 0) return;
        hanoi(n-1, from, helper, to); // verplaats n-1 schijven van `from` naar `helper`, met `to` als hulpstapel
        System.out.println("Verplaats de bovenste schijf van " + from + " naar " + to);
        hanoi(n-1, helper, to, from); // verplaats n-1 schijven van `helper` naar `to`, met `from` als hulpstapel
    }

    static void main() {
        hanoi(8, "sleutels", "gsm", "portefeuille");
    }
}

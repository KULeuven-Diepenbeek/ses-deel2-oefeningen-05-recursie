package exercises.ex02_reverse_string;

public class ReverseString {

    public static String reverse(String str) {
        if (str.length() <= 1) return str;

        var last = str.charAt(str.length() - 1);
        var prefix = str.substring(0, str.length() - 1);

        return last + reverse(prefix);
    }

    public static String reverse2(String str) {
        if (str.length() <= 1) return str;

        var mid = str.length() / 2;
        var left = str.substring(0, mid);
        var right = str.substring(mid);

        return reverse2(right) + reverse2(left);
    }
}

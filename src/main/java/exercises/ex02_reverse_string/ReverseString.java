package exercises.ex02_reverse_string;

public class ReverseString {

    public static String reverse(String str) {
        if (str.isEmpty()) return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }
}

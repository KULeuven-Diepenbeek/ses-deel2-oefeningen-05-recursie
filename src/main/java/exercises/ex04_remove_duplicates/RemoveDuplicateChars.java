package exercises.ex04_remove_duplicates;

public class RemoveDuplicateChars {

    public static String removeDuplicateCharacters(String str) {
        if (str.length() <= 1) return str;
        var first = str.charAt(0);
        var second = str.charAt(1);
        var resultWithoutFirst = removeDuplicateCharacters(str.substring(1));
        if (first == second) return resultWithoutFirst;
        return first + resultWithoutFirst;
    }
}

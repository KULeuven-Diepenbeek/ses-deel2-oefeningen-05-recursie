package exercises.ex04_remove_duplicates;

public class RemoveDuplicateChars {

    public static String removeDuplicateCharacters(String str) {
        if (str.length() <= 1) return str;
        var first = str.charAt(0);
        var rest = removeDuplicateCharacters(str.substring(1));
        if (first != rest.charAt(0))
            rest = first + rest;
        return rest;
    }
}

package exercises.ex15_longest_common_subsequence;

public class LongestCommonSubsequence {
    public static String longestCommonSubsequences(String str1, String str2) {
        if (str1.isEmpty() || str2.isEmpty()) return "";

        var first1 = str1.charAt(0);
        var rest1 = str1.substring(1);
        var first2 = str2.charAt(0);
        var rest2 = str2.substring(1);

        // 2 mogelijkheden:
        // - str1 en str2 beginnen met hetzelfde karakter => karakter maakt sowieso deel uit van LCS
        // - str1 en str2 beginnen met verschillend karakter: 2 opties
        //    - eerste karakter van str1 maakt geen deel uit van LCS => zoek LCS tussen rest1 en str2
        //    - eerste karakter van str2 maakt geen deel uit van LCS => zoek LCS tussen str1 en rest2
        //      (het geval waar beide eerste karakters geen deel uitmaken zit al vervat in bovenstaande opties)

        if (first1 == first2) {
            return first1 + longestCommonSubsequences(rest1, rest2);
        } else {
            var lcs1 = longestCommonSubsequences(rest1, str2);
            var lcs2 = longestCommonSubsequences(str1, rest2);
            if (lcs1.length() >= lcs2.length())
                return lcs1;
            else
                return lcs2;
        }
    }


    /**
     * Een snellere versie van het LCS algoritme, die eerst gaat kijken of
     */

    public static String longestCommonSubsequences_fast(String str1, String str2) {
        if (str1.isEmpty() || str2.isEmpty()) return "";

        var first1 = str1.charAt(0);
        var rest1 = str1.substring(1);
        var indexInStr2 = str2.indexOf(first1);
        if (indexInStr2 == -1) {
            // nergens gevonden in str2 => first1 hoort niet in LCS
            return longestCommonSubsequences_fast(rest1, str2);
        } else {
            // first1 komt voor in str2;
            // ofwel gebruiken we dit karakter:
            var opt1 = first1 + longestCommonSubsequences_fast(rest1, str2.substring(indexInStr2 + 1));
            // ofwel negeren we het:
            var opt2 = longestCommonSubsequences_fast(rest1, str2);
            if (opt1.length() >= opt2.length())
                return opt1;
            return opt2;
        }
    }

}

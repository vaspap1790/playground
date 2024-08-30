package org.example;

public class PalindromeVerifier {

    public static boolean isPalindrome(String str){
        if (str == null || str.length() == 0) return false;

        final var cleanStr = getCleanStr(str);
        int start = 0;
        int end = cleanStr.length() - 1;

        while(start < end){
            if (cleanStr.charAt(start) != cleanStr.charAt(end)) return false;
            start++;
            end--;
        }

        return true;
    }

    private static String getCleanStr(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }
}

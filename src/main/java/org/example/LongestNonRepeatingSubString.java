package org.example;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingSubString {

    public static int lengthOfLongestSubstring(String str) {
        int max = 0, left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(right < str.length()){
            char c = str.charAt(right);
            if(map.containsKey(c)){
                max = Math.max(max, right - left);
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, right);
            right++;
        }
        return Math.max(max, right - left);
    }

}

package org.example;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {

    public static boolean containsDuplicates(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return true;
        }
        return false;
    }

    public static boolean containsNearbyDuplicates(int[] nums, int k){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.size() > k) set.remove(i - k - 1);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }

}

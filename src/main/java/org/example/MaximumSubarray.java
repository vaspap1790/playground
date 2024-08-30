package org.example;

public class MaximumSubarray {

    public static int findMaxSubarray(int[] arr){
        if(arr == null || arr.length == 0) return 0;

        int localMax = 0;
        int globalMax = Integer.MIN_VALUE;

        for(int num : arr) {
            localMax = Math.max(num, num + localMax);
            globalMax = Math.max(globalMax, localMax);
        }

        return globalMax;
    }

}

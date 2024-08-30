package org.example;

public class MostWaterContainer {

    public static int mostWaterContainer(int[] arr){

        int maxArea = 0, left = 0, right = arr.length - 1;

        while(left < right){
            maxArea = Math.max(maxArea, getArea(left, right, arr));
            if (arr[left] <= arr[right]) left++;
            else right --;
        }

        return maxArea;
    }

    private static int getArea(int left, int right, int[] arr){
        return (right - left) * Math.max(arr[left], arr[right]);
    }
}

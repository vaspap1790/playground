package org.example;

public class ArrayProblems {

    public static int searchInRotatedSortedArray(int[] arr, int target){
        int pivot;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right){
            pivot = left + (right - left) / 2;

            if (target == arr[pivot]) return pivot;

            if (arr[left] <= arr[pivot]) {  //first subarray is sorted
                if (target >= arr[left] && target < arr[pivot]) right = pivot - 1;
                else left = pivot + 1;
            } else { //second subarray is sorted
                if (target > arr[pivot] && target <= arr[right]) left = pivot + 1;
                else right = pivot - 1;
            }

        }
        return -1;
    }

}

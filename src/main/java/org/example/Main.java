package org.example;

public class Main {
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};
        KthLargestOfStream kthLargest = new KthLargestOfStream(k, nums);
        System.out.println(kthLargest.add(3));
    }
}
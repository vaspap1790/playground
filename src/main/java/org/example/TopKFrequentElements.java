package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums){
            frequencies.merge(num, 1, Integer::sum);
            //frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
            Comparator.comparingInt(Map.Entry::getValue)
            //(a, b) -> Integer.compare(a.getValue(), b.getValue())
        );

        for(Map.Entry<Integer, Integer> entry : frequencies.entrySet()){
            minHeap.offer(entry);
            if(minHeap.size() > k) minHeap.poll();
        }

        return minHeap.stream().map(Map.Entry::getKey).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

}

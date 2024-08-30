package org.example;

import java.util.PriorityQueue;

public class KthLargestOfStream {
    private final int k;
    private final PriorityQueue<Integer> q;

    public KthLargestOfStream(int k, int[] nums) {
        this.k = k;
        this.q = new PriorityQueue<Integer>();
        for(int num : nums){
            this.q.offer(num);
        }
        while(this.q.size() > k) this.q.poll();
    }

    public int add(int val) {
        q.offer(val);
        while(q.size() > k) q.poll();
        return q.peek();
    }
}

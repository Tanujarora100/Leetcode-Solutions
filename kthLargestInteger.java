package Heap.KthPattern;

import java.util.Collections;
import java.util.PriorityQueue;

public class kthLargestInteger {

    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        String[] arr = { "6", "3", "7", "10" };
        kthLargestInteger obj = new kthLargestInteger();
        System.out.println(obj.kthLargestNumber(arr, 4));

    }
}

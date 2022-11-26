package Heap.KthPattern;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class kthLargest {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    static int largest(Integer[] arr, int k) {

        Arrays.sort(arr, Collections.reverseOrder());

        return arr[k - 1];

    }

    static void kthLarge(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        System.out.println(pq.peek());
    }

    public static void main(String[] args) {
        Integer[] arr = { 7, 8, 5, 4, 3, 2, 1 };
        // kthLarge(arr, 2);

        System.out.println(largest(arr, 2));
    }
}

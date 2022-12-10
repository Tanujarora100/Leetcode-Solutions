package Heap.KthPattern;

import java.util.Collections;
import java.util.PriorityQueue;

public class kthsmallestelement {

    public static int kthSmallest(int[] arr, int l, int r, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            pq.add(i);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {

    }
}

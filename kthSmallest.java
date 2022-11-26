package Heap.KthPattern;

import java.util.Collections;
import java.util.PriorityQueue;

public class kthSmallest {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
    // static ArrayList<Integer> ans= new ArrayList<>();

    static void kthLargest(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        System.out.println(pq.peek());
    }

    static void kthSmall(int arr[], int k) {
        for (int i = 0; i < arr.length; i++) {
            p.add(arr[i]);
            if (p.size() > k) {
                p.remove();
            }
        }
        System.out.println(p.peek());
    }

    public static void main(String[] args) {
        int arr[] = { 7, 8, 5, 4, 3, 2, 1 };
        kthLargest(arr, 3);
        kthSmall(arr, 3);

    }
}

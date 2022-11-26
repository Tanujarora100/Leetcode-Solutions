package Heap.KthPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.PriorityQueue;

public class klargestelements {

    public ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();

        // adding elements to LinkedHashSet
        for (int i = 0; i < A.size(); i++) {
            set.add(A.get(i));
        }

        Integer[] Geeks = set.toArray(new Integer[set.size()]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < Geeks.length; i++) {
            pq.add(Geeks[0]);
            if (pq.size() > B) {
                pq.remove();
            }

            while (pq.size() > 0) {
                ans.add(pq.peek());
                pq.remove();
            }
        }
        return ans;
    }

}

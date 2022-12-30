package Array.Easy;

import java.util.HashSet;
import java.util.PriorityQueue;

public class makeArrayZero {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == 0)
                continue;
            else {
                set.add(nums[i]);
            }
        return set.size();

    }

    public int minimumOperationsUsingPQ(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int oper = 0;
        int total = 0;
        for (int item : nums)
            queue.add(item);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current <= total)
                continue;
            oper++;
            total = current;
        }
        return oper;
    }
}

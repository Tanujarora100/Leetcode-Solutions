package Array.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class findDuplicateNumber {
    public int findDuplicate(int[] nums) {
        if (nums.length == 0)
            return -1;
        Arrays.sort(nums);
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1])
                continue;
            else
                answer = nums[i];
        }
        return answer;
    }

    public int findDuplicateHashMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        int answer = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() >= 2)
                answer = entry.getKey();
        return answer;

    }

    public int findDuplicateSlowandFastPointer(int[] nums) {
        int tort = nums[0];
        int hare = nums[0];
        do {
            tort = nums[tort];
            hare = nums[nums[hare]];
        } while (tort != hare);

        tort = nums[0];
        while (tort != hare) {
            tort = nums[tort];
            hare = nums[hare];
        }
        return hare;
    }

}

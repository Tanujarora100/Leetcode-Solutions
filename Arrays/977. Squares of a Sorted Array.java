package Array.LeetCodeExplore;

import java.util.Arrays;

public class squaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int result[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int num = (int) Math.pow(nums[i], 2);
            result[i] = num;
        }
        Arrays.sort(result);
        return result;
    }

    /*
     * TC-O(NLOGN)
     * SC-O(NLOGN) as JAVA USES DUAL PIVOT QUICKSORT
     */
    public int[] sortedSquaresMySolution(int[] nums) {
        int[] result = new int[nums.length];
        int start = 0;
        /*
         * Whenever Using two pointers try to iterate backwards it makes the problem
         * easier.
         */
        int end = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[start]) >= Math.abs(nums[end])) {
                result[i] = nums[start] * nums[start];
                start++;
            } else {
                result[i] = nums[end] * nums[end];
                end--;
            }
        }
        return result;
    }
    /*
     * Using two Pointers
     * TC-O(N)
     * SC-O(N)
     */
}

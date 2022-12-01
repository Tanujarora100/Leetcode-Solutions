  public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
//Moore Algorithm

//Second Solution Using HashMap
class Solution {
   public int majorityElement(int[] nums) {
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int freq = map.get(nums[i]);
                freq++;
                map.put(nums[i], freq);
            } else {
                map.put(nums[i], 1);
            }

        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() > nums.length / 2)
                result = entry.getKey();

        return result;

    }
}

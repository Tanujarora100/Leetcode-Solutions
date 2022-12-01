class Solution {
   public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<arr.length;i++)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        HashSet<Integer> set = new HashSet<>(map.values());
        // treating values like elements of array if every key is unique which is no of
        // Occurence
        // Think Values like an array of elements and every element is unique
        // if we are adding everything to this hashset then the total elements must be
        // same
        // If there is 3,1,2,3-->hash set will have 3,1,2 while map has 3,1,2,3
        // Just compare the size of both set and map and return the ans
        return set.size() == map.size() ? true : false;
    }
}

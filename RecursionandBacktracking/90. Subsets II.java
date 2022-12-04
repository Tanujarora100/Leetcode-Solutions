class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> ans= new HashSet<>();
        // Solve(nums,index, ans, new ArrayList<>());
        Arrays.sort(nums);
        Solve(nums,0,ans, new ArrayList<>());
        return new ArrayList<>(ans);
    }
    public void Solve(int[] nums, int index, Set<List<Integer>> ans, List<Integer> ds)
    {
        if(index==nums.length)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }
        ds.add(nums[index]);
        Solve(nums,index+1,ans,ds);
        ds.remove(ds.size()-1);
        Solve(nums,index+1,ans,ds);
    }
    
}

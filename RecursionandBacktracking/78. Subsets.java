    public List<List<Integer>> subsets(int[] nums) {
                List<List<Integer>> ans= new ArrayList<>();
        Solve(nums,0,new ArrayList<>(), ans);
        return ans;
            }
        public void Solve(int [] nums, int index, List<Integer> list, List<List<Integer>> ans)
        {
        if(index==nums.length){
            ans.add(new ArrayList<>(list));
            return;}
        //Before Picking Up adding the current element
        list.add(nums[index]);
        Solve(nums,index+1,list,ans);
        list.remove(list.size()-1);
        Solve(nums,index+1,list,ans);
        }
}

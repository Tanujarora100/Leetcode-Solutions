class Solution{
     List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> src = new ArrayList<>();
        for(int a : nums) src.add(a);
        traversal(src, new ArrayList<>());
        return ans;
    }

    private void traversal(List<Integer> src, List<Integer> build){
        if(src.size() == 0) ans.add(build);
        for(int i = 0; i < src.size(); i++){
            if(i > 0 && src.get(i) == src.get(i - 1)) continue;
            List<Integer> newBuild = new ArrayList<>(build);
            List<Integer> newSrc = new ArrayList<>(src);
            newBuild.add(src.get(i));
            newSrc.remove(i);
            traversal(newSrc, newBuild);
        }
    }
}

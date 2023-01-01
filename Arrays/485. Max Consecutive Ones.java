  public int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int globalMax=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1)
                count++;
            else
            {
                globalMax=Math.max(globalMax,count);
                count=0;
            }
        }
        return Math.max(count,globalMax);
    }

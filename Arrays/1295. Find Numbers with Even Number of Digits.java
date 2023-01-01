  public int findNumbers(int[] nums) {
   int count = 0;
        for (int i = 0; i < nums.length; i++) {
            String str = String.valueOf(nums[i]);
            if (str.length() % 2 != 0)
                continue;
            else {
                count++;
            }
        }
        return count;
  }
   public int findNumbersUsingMath(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = (int) Math.log10(nums[i]) + 1;
            // example (234 log 10 + 1) = ( 2 + 1 ) = 3 - number of digit
            if (count % 2 == 0)
                result++;
        }

        return result;
    }

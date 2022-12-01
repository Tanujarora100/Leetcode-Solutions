 public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            // Top ka element chota hona chayiye Array ke element se pop karne ke liye taaki
            // bade element par jaa paye neeche
            // Increasing Order mei store karengey elements isliye neeche dhundega agar nahi
            // milega to doosro ke liye khud ban jayega
            // Apne aap ko push karke Stack mein.
            while (!st.isEmpty() && st.peek() <= nums[i % n])
                st.pop();
            if (i < n) {
                if (st.isEmpty() == false)
                    result[i] = st.peek();
                else
                    result[i] = -1;
            }
            st.push(nums[i % n]);
        }
        return result;
    }

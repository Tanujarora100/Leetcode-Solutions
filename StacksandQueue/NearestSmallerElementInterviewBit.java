public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < A.size(); i++) {
            if(A.size()==1) 
            {
                ans.add(-1);
                return ans;
            }
            //Edge Case.
           while(!st.isEmpty() && A.get(i)<=st.peek())
            st.pop();
           if(!st.isEmpty())
            ans.add(st.peek());
            else ans.add(-1);
            
            st.push(A.get(i));
    }
        return ans;
    }
}

 public List<String> generateParenthesis(int n) {
       List<String> ans= new ArrayList<>();
        Solve(n ,ans, n,0,"");
        return ans;
        
    }
    public void Solve(int n, List<String> ans, int left, int right, String s)
    {
        if(left==0 && right==0)
        {
            ans.add(s);
        }
        //We are picking all the open brackets
        if(left>0)
            Solve(n,ans,left-1,right+1,s+"(");
        if(right>0)
            Solve(n,ans,left,right-1,s+")");
        //Idea is to Count all the Open brackets and assign the value to right
        //then we Collect all the Closed brackets and decrease the value of right
        //If right also becomes 0 that means left bracket==right brackets
        //Resulstant combination of Brackets will be balanced always.
        
    }

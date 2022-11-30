 public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                st.add(s.charAt(i));
            else {
                if (st.isEmpty())
                    count++;
                // Can be the case that there are no opening brackets and only closed brackets
                // If there is we are just incrementing count/
                else
                    st.pop();
                // If not we are Popping Opening bracket and work for this specific bracket is
                // over.
            }
        }
        // This may happen that there is a string- )(()
        // Ans is 2 first is closed so count=1 + one Open Bracket waiting in Stack
        // In this case there is an extra opening bracket waiting to be popped in stack
        // so we need to add that also.
        return st.size() + count;
    }

    public int minAddToMakeValidtrick(String S) {
        // Balance Trick
        int ans = 0, bal = 0;
        for (int i = 0; i < S.length(); ++i) {
            bal += S.charAt(i) == '(' ? 1 : -1;
            // It is guaranteed bal >= -1
            if (bal == -1) {
                ans++;
                bal++;
            }
        }

        return ans + bal;
    }

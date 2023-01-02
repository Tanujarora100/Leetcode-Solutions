package Strings;

import java.util.Stack;

public class reverseStringProblem {
    public void reverseString(char[] s) {
        /*
         * Time Complexity-O(N)
         * Space Complexity-O(N)
         */
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length; i++)
            st.add(s[i]);
        int k = 0;
        while (!st.isEmpty())
            s[k++] = st.pop();
    }

    /*
     * Time Complexity-O(N)
     * Space Complexity-O(1)
     */
    public void reverse(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start <= end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public void reverseStringExtra(char[] s) {
        /*
         * Time Complexity-O(N)
         * Space Complexity-O(1)
         */
        String str = ""; // Allocate extra space
        for (int i = s.length - 1; i >= 0; i--) /* Add to extra space from rear to front */
            str += s[i];

        for (int i = 0; i < s.length; i++) /* Set reversed 'str' into char array 's' */
            s[i] = str.charAt(i);
    }
}

package Strings;

import java.util.Stack;

public class isPalindromeProblem {
    int isPalindrome(String S) {
        // Using Recursion
        return isPalindromeHelper(S, 0, S.length() - 1);
    }

    int isPalindromeHelper(String s, int start, int end) {
        if (start >= end) {
            return 1;
        }
        if (s.charAt(start) != s.charAt(end)) {
            return 0;
        }
        return isPalindromeHelper(s, start + 1, end - 1);
    }

    int isPalindromeUsingStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }
        String reverse = " ";
        while (!stack.isEmpty()) {
            reverse += stack.pop();
        }
        if (s.equals(reverse))
            return 1;
        else
            return 0;
    }

    int isPalindromeUsingIteration(String s) {
        if (s.length() == 0)
            return 1;
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return 0;
            start++;
            end--;
        }
        return 1;
    }
}

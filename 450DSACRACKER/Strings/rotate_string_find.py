from collections import deque


class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        return len(s) == len(goal) and goal in s+s

    def rotateString(self, s: str, goal: str) -> bool:
       # Whenever you see something related to rotation try to think of a deque
        # By appending something and removing somethin
        if s == goal:
            return True
        deq_one = deque(s)
        deq_two = deque(goal)
        i = 0
        while i < len(s):
            deq_one.append(deq_one.popleft())
            if deq_two == deq_one:
                return True
            i = i+1
        return False
    '''
    The time complexity of this algorithm is O(n), where n is the length of the input strings. 
    This is because the loop runs for at most n iterations and each deque operation takes O(1) time.
    The space complexity is also O(n), because the algorithm creates two deques with a combined length of n.
    
    '''

    '''
    ABCDE--> PopLeft()-->BCDEA compare with CDEAB-->Move ahea
    BCDEA-->PopLeft()-->CDEAB--> compare with CDEAB-->Both same so return True
    '''

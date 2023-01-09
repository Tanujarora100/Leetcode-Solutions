from ast import List


def reverseString(self, s: List[str]) -> None:
    start = 0
    end = len(s)-1
    while start <= end:
        s[start], s[end] = s[end], s[start]
        start = start+1
        end -= 1


def reverse(self, s: List[str]) -> None:
    stack = []
    for i in range(0, len(s)):
        stack.append(s.pop())
    for i in range(0, len(stack)):
        s.append(stack[i])

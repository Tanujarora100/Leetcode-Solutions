import math


class Solution:
    def largestOddNumber(self, num: str) -> str:
        num = list(num)
        max_num = -math.inf
        print(num)
        for i in range(len(num)):
            if num[i] % 2 != 0:
                max_num = max(max_num, num[i])
        return max_num
